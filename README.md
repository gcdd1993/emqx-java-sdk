完整地实现了[EMQX HTTP Api](https://docs.emqx.cn/broker/v4.3/advanced/http-api.html)，并做了较为完备的测试。

# 使用

## 引入依赖

```groovy
implementation("io.github.gcdd1993:emqx-http-sdk:$version")
```

## 入门

```java
EmqxApiFactory emqxApiFactory = new EmqxApiFactory("http://localhost:8081", "admin", "public");
EmqxClientApi emqxClientApi = emqxApiFactory.create(EmqxClientApi.class);
Response<EmqxResponseDto<List<ClientDto>>> response = emqxClientApi.clients(Collections.emptyMap()).execute();

EmqxResponseDto<List<ClientDto>> clients = response.body();

Assertions.assertTrue(clients.getCode() == 0);

log.info("clients: {}", clients);
```

更多的使用例子可以参考：[单元测试](https://github.com/gcdd1993/emqx-java-sdk/tree/master/emqx-http-sdk/src/test/java/io/github/gcdd1993/emqx/sdk/http)

## 另外

设计了较为简单的方式来方便地使用他们，并对Api做了分组（按照模块区分）。

如果你想获取`Client`的信息，只需要

```java
EmqxClientApi emqxClientApi = emqxApiFactory.create(EmqxClientApi.class);
Response<EmqxResponseDto<List<ClientDto>>> response = emqxClientApi.clients(Collections.emptyMap()).execute();

EmqxResponseDto<List<ClientDto>> clients = response.body();
```

或者你想管理订阅，那么创建`EmqxSubscriptionApi`的实例

```java
EmqxSubscriptionApi emqxSubscriptionApi = emqxApiFactory.create(EmqxSubscriptionApi.class);
Response<EmqxResponseDto<List<SubscriptionDto>>> response = emqxSubscriptionApi.subscriptions(Collections.emptyMap()).execute();

EmqxResponseDto<List<SubscriptionDto>> subscriptions = response.body();
```

所有地模块都可以以简单地方式创建出来，你唯一要做的就是，创建`EmqxApiFactory`

```java
EmqxApiFactory emqxApiFactory = new EmqxApiFactory("http://localhost:8081", "admin", "public");
```

需要提供EMQX服务器地址，用户名和密码，参见：[接口安全](https://docs.emqx.cn/broker/v4.3/advanced/http-api.html#%E6%8E%A5%E5%8F%A3%E5%AE%89%E5%85%A8)

## 在SpringBoot中使用

### 引入依赖

```groovy
implementation("io.github.gcdd1993:emqx-http-sdk-spring-boot-starter:$version")
```

### 示例

```java
@RestController
@RequestMapping("/api/emqx")
public class EmqxTestController {

    @Autowired
    private EmqxClientApi emqxClientApi;

    @Autowired
    private EmqxSubscriptionApi emqxSubscriptionApi;

    @GetMapping("/clients")
    public List<ClientDto> getClients() {
        try {
            Response<EmqxResponseDto<List<ClientDto>>> response = emqxClientApi.clients(Collections.emptyMap()).execute();
            if (response.code() == HttpStatus.OK.value()) {
                EmqxResponseDto<List<ClientDto>> body = response.body();
                if (body.getCode() == 0) {
                    return body.getData();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @GetMapping("/subscriptions")
    public List<SubscriptionDto> subscriptions() {
        try {
            Response<EmqxResponseDto<List<SubscriptionDto>>> response = emqxSubscriptionApi.subscriptions(Collections.emptyMap()).execute();
            if (response.code() == HttpStatus.OK.value()) {
                EmqxResponseDto<List<SubscriptionDto>> body = response.body();
                if (body.getCode() == 0) {
                    return body.getData();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
```

如果你希望禁用一些Api，那么可以做如下配置，会禁用`EmqxClientApi`

```yaml
emqx:
  http:
    sdk:
      url: "http://localhost:8081"
      app-id: "admin"
      app-secret: "public"
      disabled:
        - client
```

# 依赖

- https://github.com/square/retrofit
- https://github.com/FasterXML/jackson

# 未竟事宜

## 未知数据模型

在官方文档中，有些数据模型未在文档中体现，而且模拟请求未获得数据，所以只能暂时使用`Object`来代替

- `ClientDto#mountpoint`
- `RuleDto#RuleActionDto#fallbacks`

希望有知晓的可以告知一下