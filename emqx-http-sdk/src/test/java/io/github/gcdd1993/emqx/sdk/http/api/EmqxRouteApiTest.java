package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.RouteDto;
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
class EmqxRouteApiTest {

    private EmqxRouteApi emqxRouteApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxRouteApi = emqxApiFactory.create(EmqxRouteApi.class);
    }

    @Test
    @SneakyThrows
    void routes() {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("_page", 1);
        queryMap.put("_limit", 10);
        Response<EmqxResponseDto<List<RouteDto>>> response = emqxRouteApi.routes(queryMap).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<RouteDto>> routes = response.body();

        Assertions.assertEquals(0, routes.getCode());

        log.info("routes: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(routes.getData()));
    }

    @Test
    @SneakyThrows
    void routesByTopic() {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("_page", 1);
        queryMap.put("_limit", 10);
        Response<EmqxResponseDto<List<RouteDto>>> response = emqxRouteApi.routesByTopic("/samples3", queryMap).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<RouteDto>> routes = response.body();

        Assertions.assertEquals(0, routes.getCode());

        log.info("routes: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(routes.getData()));
    }
}