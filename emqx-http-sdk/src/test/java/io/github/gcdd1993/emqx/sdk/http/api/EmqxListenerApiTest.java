package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.TestConstants;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.ListenerDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.NodeListenerDto;
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
class EmqxListenerApiTest {

    private EmqxListenerApi emqxListenerApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxListenerApi = emqxApiFactory.create(EmqxListenerApi.class);
    }

    @Test
    @SneakyThrows
    void listeners() {
        Response<EmqxResponseDto<List<NodeListenerDto>>> response = emqxListenerApi.listeners().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<NodeListenerDto>> listeners = response.body();

        Assertions.assertEquals(0, listeners.getCode());

        log.info("listeners: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listeners.getData()));

    }

    @Test
    @SneakyThrows
    void testListeners() {
        Response<EmqxResponseDto<List<ListenerDto>>> response = emqxListenerApi.listeners(TestConstants.NODE).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<ListenerDto>> listeners = response.body();

        Assertions.assertEquals(0, listeners.getCode());

        log.info("listeners: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listeners.getData()));

    }
}