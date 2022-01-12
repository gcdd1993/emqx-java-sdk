package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.NodeStatsDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.StatsDto;
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
 * @since 2022/1/12
 */
@Slf4j
class EmqxStatsApiTest {

    private EmqxStatsApi emqxStatsApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxStatsApi = emqxApiFactory.create(EmqxStatsApi.class);
    }

    @Test
    @SneakyThrows
    void stats() {
        Response<EmqxResponseDto<List<NodeStatsDto>>> response = emqxStatsApi.stats().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<NodeStatsDto>> stats = response.body();

        Assertions.assertEquals(0, stats.getCode());

        log.info("stats: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stats.getData()));
    }

    @Test
    @SneakyThrows
    void testStats() {
        Response<EmqxResponseDto<StatsDto>> response = emqxStatsApi.stats(NODE).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<StatsDto> stats = response.body();

        Assertions.assertEquals(0, stats.getCode());

        log.info("stats: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stats.getData()));
    }
}