package io.github.gcdd1993.emqx.sdk.http.api;

import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.model.request.PublishRequest;
import io.github.gcdd1993.emqx.sdk.http.model.request.SubscribeRequest;
import io.github.gcdd1993.emqx.sdk.http.model.request.UnsubscribeRequest;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static io.github.gcdd1993.emqx.sdk.http.TestConstants.*;

/**
 * @author gcdd1993
 * @since 2022/1/11
 */
@Slf4j
class EmqxOperationApiTest {

    private final String clientId = "76ab00ed3dcd42688dd11a5cc60ebe78";

    private EmqxOperationApi emqxOperationApi;
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxOperationApi = emqxApiFactory.create(EmqxOperationApi.class);
    }

    @Test
    @SneakyThrows
    void publish() {
        PublishRequest request = PublishRequest.builder()
                .clientId("76ab00ed3dcd42688dd11a5cc60ebe78")
                .payload("test")
                .qos(0)
//                .topic("/samples")
                .topics("/samples,/samples2")
                .retain(false)
                .build();
        Response<EmqxResponseDto<Void>> response = emqxOperationApi.publish(request).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<Void> published = response.body();

        Assertions.assertEquals(0, published.getCode());
    }

    @Test
    @SneakyThrows
    void batchPublish() {
        List<PublishRequest> request = IntStream.range(0, 10)
                .boxed()
                .map(i -> PublishRequest.builder()
                        .clientId(clientId)
                        .payload("发布消息 " + (i + 1))
                        .qos(0)
                        .topic("/samples")
//                        .topics("/samples,/samples2")
                        .retain(false)
                        .build())
                .collect(Collectors.toUnmodifiableList());

        Response<EmqxResponseDto<Void>> response = emqxOperationApi.batchPublish(request).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<Void> published = response.body();

        Assertions.assertEquals(0, published.getCode());
    }

    @Test
    @SneakyThrows
    void subscribe() {
        String topic = "/samples3";
        SubscribeRequest request = SubscribeRequest.builder()
                .clientId(clientId)
                .topic(topic)
                .qos(2)
                .build();

        Response<EmqxResponseDto<Void>> response = emqxOperationApi.subscribe(request).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<Void> published = response.body();

        Assertions.assertEquals(0, published.getCode());

        List<PublishRequest> request1 = IntStream.range(0, 10)
                .boxed()
                .map(i -> PublishRequest.builder()
                        .clientId(clientId)
                        .payload("发布消息 " + (i + 1))
                        .qos(0)
                        .topic(topic)
                        .retain(false)
                        .build())
                .collect(Collectors.toUnmodifiableList());

        emqxOperationApi.batchPublish(request1).execute();
    }

    @Test
    @SneakyThrows
    void batchSubscribe() {
        List<SubscribeRequest> request = IntStream.range(0, 10)
                .boxed()
                .map(i -> SubscribeRequest.builder()
                        .clientId(clientId)
                        .topic("/sample/" + (i + 1))
                        .qos(2)
                        .build())
                .collect(Collectors.toUnmodifiableList());

        Response<EmqxResponseDto<Void>> response = emqxOperationApi.batchSubscribe(request).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<Void> published = response.body();

        Assertions.assertEquals(0, published.getCode());
    }

    @Test
    @SneakyThrows
    void unsubscribe() {
        UnsubscribeRequest request = UnsubscribeRequest.builder()
                .clientId(clientId)
                .topic("/samples")
                .build();
        Response<EmqxResponseDto<Void>> response = emqxOperationApi.unsubscribe(request).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<Void> published = response.body();

        Assertions.assertEquals(0, published.getCode());
    }

    @Test
    @SneakyThrows
    void batchUnsubscribe() {
        List<UnsubscribeRequest> request = IntStream.range(0, 10)
                .boxed()
                .map(i -> UnsubscribeRequest.builder()
                        .clientId(clientId)
                        .topic("/sample/" + (i + 1))
                        .build())
                .collect(Collectors.toUnmodifiableList());

        Response<EmqxResponseDto<Void>> response = emqxOperationApi.batchUnsubscribe(request).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<Void> published = response.body();

        Assertions.assertEquals(0, published.getCode());
    }
}