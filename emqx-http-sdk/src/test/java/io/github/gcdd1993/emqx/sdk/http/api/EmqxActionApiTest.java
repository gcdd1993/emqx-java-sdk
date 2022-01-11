package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.model.response.ActionDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
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
 * @since 2022/1/10
 */
@Slf4j
class EmqxActionApiTest {

    private EmqxActionApi emqxActionApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxActionApi = emqxApiFactory.create(EmqxActionApi.class);
    }

    @Test
    @SneakyThrows
    void actions() {
        Response<EmqxResponseDto<ActionDto>> response = emqxActionApi.actions("do_nothing").execute();
        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<ActionDto> action = response.body();
        Assertions.assertEquals(0, action.getCode());

        log.info("actions: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(action.getData()));

    }

    @Test
    @SneakyThrows
    void actions1() {
        Response<EmqxResponseDto<List<ActionDto>>> response = emqxActionApi.actions().execute();
        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<ActionDto>> actions = response.body();
        Assertions.assertEquals(0, actions.getCode());

        log.info("actions: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(actions.getData()));

    }
}