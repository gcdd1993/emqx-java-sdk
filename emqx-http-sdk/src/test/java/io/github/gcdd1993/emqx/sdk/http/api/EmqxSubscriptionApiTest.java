package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.SubscriptionDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.github.gcdd1993.emqx.sdk.http.TestConstants.*;

/**
 * @author gcdd1993
 * @since 2022/1/12
 */
@Slf4j
class EmqxSubscriptionApiTest {

    private EmqxSubscriptionApi emqxSubscriptionApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxSubscriptionApi = emqxApiFactory.create(EmqxSubscriptionApi.class);
    }

    @Test
    @SneakyThrows
    void subscriptions() {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("_page", 1);
        queryMap.put("_limit", 10);
        Response<EmqxResponseDto<List<SubscriptionDto>>> response = emqxSubscriptionApi.subscriptions(queryMap).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<SubscriptionDto>> subscriptions = response.body();

        Assertions.assertEquals(0, subscriptions.getCode());

        log.info("subscriptions: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(subscriptions.getData()));

    }

    @Test
    @SneakyThrows
    void subscriptionsByClient() {
        String clientId = "76ab00ed3dcd42688dd11a5cc60ebe78";
        Response<EmqxResponseDto<List<SubscriptionDto>>> response = emqxSubscriptionApi.subscriptionsByClient(clientId).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<SubscriptionDto>> subscriptions = response.body();

        Assertions.assertEquals(0, subscriptions.getCode());

        log.info("subscriptions: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(subscriptions.getData()));
    }

    @Test
    @SneakyThrows
    void subscriptionsByNode() {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("_page", 1);
        queryMap.put("_limit", 10);
        Response<EmqxResponseDto<List<SubscriptionDto>>> response = emqxSubscriptionApi.subscriptionsByNode(NODE, queryMap).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<SubscriptionDto>> subscriptions = response.body();

        Assertions.assertEquals(0, subscriptions.getCode());

        log.info("subscriptions: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(subscriptions.getData()));
    }

    @Test
    @SneakyThrows
    void subscriptionsByNodeAndClient() {
        String clientId = "76ab00ed3dcd42688dd11a5cc60ebe78";
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("_page", 1);
        queryMap.put("_limit", 10);
        Response<EmqxResponseDto<List<SubscriptionDto>>> response = emqxSubscriptionApi.subscriptionsByNodeAndClient(NODE, clientId, queryMap).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<SubscriptionDto>> subscriptions = response.body();

        Assertions.assertEquals(0, subscriptions.getCode());

        log.info("subscriptions: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(subscriptions.getData()));
    }
}