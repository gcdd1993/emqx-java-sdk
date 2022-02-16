package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.TestConstants;
import io.github.gcdd1993.emqx.sdk.http.model.request.TopicMetricsRequest;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.MetricsDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.NodeMetricsDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.TopicMetricsDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.util.List;

import static io.github.gcdd1993.emqx.sdk.http.TestConstants.*;

/**
 * @author gcdd1993
 * @since 2022/1/11
 */
@Slf4j
class EmqxMetricsApiTest {

    private EmqxMetricsApi emqxMetricsApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxMetricsApi = emqxApiFactory.create(EmqxMetricsApi.class);
    }

    @Test
    @SneakyThrows
    void metrics() {
        Response<EmqxResponseDto<List<NodeMetricsDto>>> response = emqxMetricsApi.metrics().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<NodeMetricsDto>> metrics = response.body();
        Assertions.assertEquals(0, metrics.getCode());

        log.info("metrics: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(metrics.getData()));

        metrics.getData().forEach(m -> {
            log.info("node {} messages.qos0.received : {}", m.getNode(), m.getMetrics().get("messages.qos0.received"));
        });
    }

    @Test
    @SneakyThrows
    void nodeMetrics() {
        Response<EmqxResponseDto<MetricsDto>> response = emqxMetricsApi.nodeMetrics(TestConstants.NODE).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<MetricsDto> metrics = response.body();
        Assertions.assertEquals(0, metrics.getCode());

        log.info("metrics: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(metrics.getData()));
    }

    @Test
    @SneakyThrows
    void topicMetrics() {
        Response<EmqxResponseDto<List<TopicMetricsDto>>> response = emqxMetricsApi.topicMetrics().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<TopicMetricsDto>> metrics = response.body();
        Assertions.assertEquals(0, metrics.getCode());

        log.info("topic metrics: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(metrics.getData()));
    }

    @Test
    @SneakyThrows
    void testTopicMetrics() {
        Response<EmqxResponseDto<MetricsDto>> response = emqxMetricsApi.topicMetrics("/sample").execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<MetricsDto> metrics = response.body();
        Assertions.assertEquals(0, metrics.getCode());

        log.info("metrics: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(metrics.getData()));
    }

    @Test
    @SneakyThrows
    void startTopicMetrics() {
        TopicMetricsRequest request = TopicMetricsRequest.builder()
                .topic("/sample")
                .build();
        Response<EmqxResponseDto<Void>> response = emqxMetricsApi.startTopicMetrics(request).execute();

        // module not loaded
        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals(0, response.body().getCode());
    }

    @Test
    @SneakyThrows
    void stopTopicMetrics() {
        Response<EmqxResponseDto<Void>> response = emqxMetricsApi.stopTopicMetrics("/sample").execute();

        // module not loaded
        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals(0, response.body().getCode());
    }

    @Test
    @SneakyThrows
    void testStopTopicMetrics() {
        Response<EmqxResponseDto<Void>> response = emqxMetricsApi.stopTopicMetrics().execute();

        // module not loaded
        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals(0, response.body().getCode());
    }
}