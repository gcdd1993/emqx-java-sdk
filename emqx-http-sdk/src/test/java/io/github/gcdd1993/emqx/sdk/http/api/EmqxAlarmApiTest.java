package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.TestConstants;
import io.github.gcdd1993.emqx.sdk.http.model.request.DeactivateAlarmRequest;
import io.github.gcdd1993.emqx.sdk.http.model.response.AlarmDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.NodeAlarmDto;
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
class EmqxAlarmApiTest {

    private EmqxAlarmApi emqxAlarmApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxAlarmApi = emqxApiFactory.create(EmqxAlarmApi.class);
    }

    @Test
    @SneakyThrows
    void alarms() {
        Response<EmqxResponseDto<List<NodeAlarmDto>>> response = emqxAlarmApi.alarms().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<NodeAlarmDto>> alarms = response.body();


        Assertions.assertTrue(alarms.getCode() == 0);

        log.info("alarms: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(alarms));
    }

    @Test
    @SneakyThrows
    void testAlarms() {
        Response<EmqxResponseDto<List<AlarmDto>>> response = emqxAlarmApi.alarms(TestConstants.NODE).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<AlarmDto>> alarms = response.body();


        Assertions.assertTrue(alarms.getCode() == 0);

        log.info("alarms: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(alarms));
    }

    @Test
    @SneakyThrows
    void activatedAlarms() {
        Response<EmqxResponseDto<List<NodeAlarmDto>>> response = emqxAlarmApi.activatedAlarms().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<NodeAlarmDto>> alarms = response.body();


        Assertions.assertTrue(alarms.getCode() == 0);

        log.info("activatedAlarms: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(alarms));
    }

    @Test
    @SneakyThrows
    void testActivatedAlarms() {
        Response<EmqxResponseDto<List<AlarmDto>>> response = emqxAlarmApi.activatedAlarms(TestConstants.NODE).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<AlarmDto>> alarms = response.body();


        Assertions.assertTrue(alarms.getCode() == 0);

        log.info("activatedAlarms: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(alarms));
    }

    @Test
    @SneakyThrows
    void deactivatedAlarms() {
        Response<EmqxResponseDto<List<NodeAlarmDto>>> response = emqxAlarmApi.deactivatedAlarms().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<NodeAlarmDto>> alarms = response.body();


        Assertions.assertTrue(alarms.getCode() == 0);

        log.info("deactivatedAlarms: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(alarms));
    }

    @Test
    @SneakyThrows
    void testDeactivatedAlarms() {
        Response<EmqxResponseDto<List<AlarmDto>>> response = emqxAlarmApi.deactivatedAlarms(TestConstants.NODE).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<AlarmDto>> alarms = response.body();


        Assertions.assertTrue(alarms.getCode() == 0);

        log.info("deactivatedAlarms: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(alarms));
    }

    @Test
    @SneakyThrows
    void deactivateAlarm() {
        DeactivateAlarmRequest request = DeactivateAlarmRequest.builder()
                .name("test")
                .node(TestConstants.NODE)
                .build();
        Response<EmqxResponseDto<Void>> response = emqxAlarmApi.deactivateAlarm(request).execute();

        Assertions.assertEquals(200, response.code());
    }

    @Test
    @SneakyThrows
    void cleanDeactivateAlarm() {
        Response<EmqxResponseDto<Void>> response = emqxAlarmApi.cleanDeactivateAlarm().execute();

        Assertions.assertEquals(200, response.code());
    }

    @Test
    @SneakyThrows
    void testCleanDeactivateAlarm() {
        Response<EmqxResponseDto<Void>> response = emqxAlarmApi.cleanDeactivateAlarm(TestConstants.NODE).execute();

        Assertions.assertEquals(200, response.code());
    }
}