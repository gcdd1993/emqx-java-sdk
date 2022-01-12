package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.model.request.TelemetryStatusRequest;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.TelemetryDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.TelemetryStatusDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static io.github.gcdd1993.emqx.sdk.http.TestConstants.*;

/**
 * @author gcdd1993
 * @since 2022/1/12
 */
@Slf4j
class EmqxTelemetryApiTest {

    private EmqxTelemetryApi emqxTelemetryApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxTelemetryApi = emqxApiFactory.create(EmqxTelemetryApi.class);
    }

    @Test
    @SneakyThrows
    void changeStatus() {
        TelemetryStatusRequest request = TelemetryStatusRequest.builder()
                .enabled(true)
                .build();
        Response<EmqxResponseDto<Void>> response = emqxTelemetryApi.changeStatus(request).execute();

        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals(0, response.body().getCode());
    }

    @Test
    @SneakyThrows
    void status() {
        Response<EmqxResponseDto<TelemetryStatusDto>> response = emqxTelemetryApi.status().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<TelemetryStatusDto> status = response.body();

        Assertions.assertEquals(0, status.getCode());

        log.info("status: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(status.getData()));
    }

    @Test
    @SneakyThrows
    void data() {
        Response<EmqxResponseDto<TelemetryDto>> response = emqxTelemetryApi.data().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<TelemetryDto> telemetryData = response.body();

        Assertions.assertEquals(0, telemetryData.getCode());

        log.info("telemetryData: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(telemetryData.getData()));
    }
}