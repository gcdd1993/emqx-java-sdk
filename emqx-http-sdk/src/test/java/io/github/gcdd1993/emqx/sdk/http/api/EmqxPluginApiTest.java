package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.NodePluginDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.PluginDto;
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
class EmqxPluginApiTest {

    private EmqxPluginApi emqxPluginApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxPluginApi = emqxApiFactory.create(EmqxPluginApi.class);
    }

    @Test
    @SneakyThrows
    void plugins() {
        Response<EmqxResponseDto<List<NodePluginDto>>> response = emqxPluginApi.plugins().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<NodePluginDto>> plugins = response.body();

        Assertions.assertEquals(0, plugins.getCode());
        log.info("plugins: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(plugins.getData()));
    }

    @Test
    @SneakyThrows
    void testPlugins() {
        Response<EmqxResponseDto<List<PluginDto>>> response = emqxPluginApi.plugins(NODE).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<PluginDto>> plugins = response.body();

        Assertions.assertEquals(0, plugins.getCode());
        log.info("plugins: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(plugins.getData()));
    }

    @Test
    @SneakyThrows
    void loadPlugin() {
        Response<EmqxResponseDto<Void>> response = emqxPluginApi.loadPlugin(NODE, "emqx_auth_clientid").execute();

        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals(0, response.body().getCode());
    }

    @Test
    @SneakyThrows
    void unloadPlugin() {
        Response<EmqxResponseDto<Void>> response = emqxPluginApi.unloadPlugin(NODE, "emqx_auth_clientid").execute();

        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals(0, response.body().getCode());
    }

    @Test
    @SneakyThrows
    void reloadPlugin() {
        Response<EmqxResponseDto<Void>> response = emqxPluginApi.reloadPlugin(NODE, "emqx_auth_clientid").execute();

        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals(0, response.body().getCode());
    }
}