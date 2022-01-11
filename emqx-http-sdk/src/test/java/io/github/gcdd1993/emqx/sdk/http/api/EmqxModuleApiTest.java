package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.ModuleDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.NodeModuleDto;
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
class EmqxModuleApiTest {

    private EmqxModuleApi emqxModuleApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxModuleApi = emqxApiFactory.create(EmqxModuleApi.class);
    }

    @Test
    @SneakyThrows
    void modules() {
        Response<EmqxResponseDto<List<NodeModuleDto>>> response = emqxModuleApi.modules().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<NodeModuleDto>> modules = response.body();
        Assertions.assertEquals(0, modules.getCode());

        log.info("modules: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(modules.getData()));

    }

    @Test
    @SneakyThrows
    void testModules() {
        Response<EmqxResponseDto<List<ModuleDto>>> response = emqxModuleApi.modules(NODE).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<ModuleDto>> modules = response.body();
        Assertions.assertEquals(0, modules.getCode());

        log.info("modules: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(modules.getData()));
    }

    @Test
    @SneakyThrows
    void loadModule() {
        Response<EmqxResponseDto<Void>> response = emqxModuleApi.loadModule("emqx_mod_delayed").execute();

        Assertions.assertEquals(200, response.code());
    }

    @Test
    @SneakyThrows
    void testLoadModule() {
        Response<EmqxResponseDto<Void>> response = emqxModuleApi.loadModule(NODE, "emqx_mod_subscription").execute();

        Assertions.assertEquals(200, response.code());
    }

    @Test
    @SneakyThrows
    void unloadModule() {
        Response<EmqxResponseDto<Void>> response = emqxModuleApi.unloadModule("emqx_mod_delayed").execute();

        Assertions.assertEquals(200, response.code());
    }

    @Test
    @SneakyThrows
    void testUnloadModule() {
        Response<EmqxResponseDto<Void>> response = emqxModuleApi.unloadModule(NODE, "emqx_mod_subscription").execute();

        Assertions.assertEquals(200, response.code());
    }

    @Test
    @SneakyThrows
    void reloadModule() {
        Response<EmqxResponseDto<Void>> response = emqxModuleApi.reloadModule("emqx_mod_acl_internal").execute();

        Assertions.assertEquals(200, response.code());
    }

    @Test
    @SneakyThrows
    void testReloadModule() {
        Response<EmqxResponseDto<Void>> response = emqxModuleApi.reloadModule(NODE, "emqx_mod_acl_internal").execute();

        Assertions.assertEquals(200, response.code());
    }
}