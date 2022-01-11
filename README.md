完整地实现了[EMQX HTTP Api](https://docs.emqx.cn/broker/v4.3/advanced/http-api.html)，并做了较为完备的测试。

# 使用

**引入依赖**

**入门**

```java
EmqxApiFactory emqxApiFactory = new EmqxApiFactory("http://localhost:8081", "admin", "public");
EmqxClientApi emqxClientApi = emqxApiFactory.create(EmqxClientApi.class);
Response<EmqxResponseDto<List<ClientDto>>> response = emqxClientApi.clients(Collections.emptyMap()).execute();

EmqxResponseDto<List<ClientDto>> clients = response.body();

Assertions.assertTrue(clients.getCode() == 0);

log.info("clients: {}", clients);
```

更多的使用例子可以参考：[单元测试](https://github.com/gcdd1993/emqx-java-sdk/tree/master/emqx-http-sdk/src/test/java/io/github/gcdd1993/emqx/sdk/http)

# 依赖

- https://github.com/square/retrofit
- https://github.com/FasterXML/jackson