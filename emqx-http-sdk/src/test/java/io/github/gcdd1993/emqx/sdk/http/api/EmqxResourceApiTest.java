package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.model.request.ResourceRequest;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.ResourceDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.ResourceTypeDto;
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
class EmqxResourceApiTest {

    private EmqxResourceApi emqxResourceApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxResourceApi = emqxApiFactory.create(EmqxResourceApi.class);
    }

    @Test
    @SneakyThrows
    void resourceTypes() {
        Response<EmqxResponseDto<List<ResourceTypeDto>>> response = emqxResourceApi.resourceTypes().execute();

        Assertions.assertEquals(200, response.code());
        EmqxResponseDto<List<ResourceTypeDto>> resourceTypes = response.body();

        Assertions.assertEquals(0, resourceTypes.getCode());

        log.info("resourceTypes: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resourceTypes.getData()));
    }

    @Test
    @SneakyThrows
    void testResourceTypes() {
        Response<EmqxResponseDto<ResourceTypeDto>> response = emqxResourceApi.resourceTypes("bridge_rpc").execute();

        Assertions.assertEquals(200, response.code());
        EmqxResponseDto<ResourceTypeDto> resourceType = response.body();

        Assertions.assertEquals(0, resourceType.getCode());

        log.info("resourceTypes: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resourceType.getData()));
    }

    @Test
    @SneakyThrows
    void createResource() {
        Map<String, Object> config = new HashMap<>();
        config.put("url", "http://127.0.0.1:9910");
        config.put("headers", "{\"token\":\"axfw34y235wrq234t4ersgw4t\"}");
        config.put("method", "POST");

        ResourceRequest request = ResourceRequest.builder()
                .type("web_hook")
                .config(config)
                .description("web hook resource-1")
                .build();

        Response<EmqxResponseDto<ResourceDto>> response = emqxResourceApi.createResource(request).execute();

        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals(0, response.body().getCode());
    }

    @Test
    @SneakyThrows
    void removeResource() {
        Response<EmqxResponseDto<Void>> response = emqxResourceApi.removeResource("resource:64b100b7").execute();

        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals(0, response.body().getCode());

    }

    @Test
    @SneakyThrows
    void resources() {
        Response<EmqxResponseDto<List<ResourceDto>>> response = emqxResourceApi.resources().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<ResourceDto>> resources = response.body();

        Assertions.assertEquals(0, resources.getCode());

        log.info("resources: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resources.getData()));
    }

    @Test
    @SneakyThrows
    void testResources() {
        Response<EmqxResponseDto<ResourceDto>> response = emqxResourceApi.resources("resource:64b100b7").execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<ResourceDto> resource = response.body();

        Assertions.assertEquals(0, resource.getCode());

        log.info("resources: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resource.getData()));
    }
}