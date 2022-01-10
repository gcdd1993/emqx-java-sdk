package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.model.response.ClientAclCacheDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.ClientDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gcdd1993
 * @since 2022/1/10
 */
@Slf4j
class EmqxClientApiTest {

    private EmqxClientApi emqxClientApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory("http://localhost:8081", "admin", "public");

    @BeforeEach
    void setUp() {
        emqxClientApi = emqxApiFactory.create(EmqxClientApi.class);
    }

    @Test
    @SneakyThrows
    void clients() {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("_page", 1);
        queryMap.put("_limit", 100);
        Response<EmqxResponseDto<List<ClientDto>>> response = emqxClientApi.clients(queryMap).execute();
        EmqxResponseDto<List<ClientDto>> clients = response.body();

        Assertions.assertTrue(clients.getCode() == 0);

        log.info("clients: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clients));
    }

    @Test
    @SneakyThrows
    void client() {
        Response<EmqxResponseDto<List<ClientDto>>> response = emqxClientApi.client("20f9638c8d1042a6a3e571e574d31851").execute();
        EmqxResponseDto<List<ClientDto>> clients = response.body();

        Assertions.assertTrue(clients.getCode() == 0);

        log.info("clients: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clients));

        response = emqxClientApi.client("notexists client").execute();
        clients = response.body();

        Assertions.assertTrue(clients.getCode() == 0);
        Assertions.assertTrue(clients.getData().isEmpty());
    }

    @Test
    @SneakyThrows
    void removeClient() {
        Response<EmqxResponseDto<List<ClientDto>>> response = emqxClientApi.clients(Collections.emptyMap()).execute();
        EmqxResponseDto<List<ClientDto>> clients = response.body();

        Assertions.assertTrue(clients.getCode() == 0);

        clients.getData().forEach(client -> {
            try {
                Response<EmqxResponseDto<Void>> res1 = emqxClientApi.removeClient(client.getClientid()).execute();
                Assertions.assertTrue(res1.body().getCode() == 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    @SneakyThrows
    void nodeClients() {
        Response<EmqxResponseDto<List<ClientDto>>> response = emqxClientApi.nodeClients("c6e6e46531bf@172.18.0.2", Collections.emptyMap()).execute();
        Assertions.assertTrue(response.isSuccessful());
        EmqxResponseDto<List<ClientDto>> clients = response.body();

        Assertions.assertTrue(clients.getCode() == 0);

        log.info("clients: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clients));

        response = emqxClientApi.nodeClients("notexistsnode", Collections.emptyMap()).execute();
        Assertions.assertFalse(response.isSuccessful());

        Assertions.assertEquals(404, response.code());
    }

    @Test
    @SneakyThrows
    void removeNodeClient() {

    }

    @Test
    @SneakyThrows
    void clientsByUsername() {
        Response<EmqxResponseDto<List<ClientDto>>> response = emqxClientApi.clientsByUsername("undefined").execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<ClientDto>> clients = response.body();

        Assertions.assertTrue(clients.getCode() == 0);

        log.info("clients: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clients));
    }

    @Test
    @SneakyThrows
    void nodeClientsByUsername() {
        // 找不出Username为空的，不支持
        Response<EmqxResponseDto<List<ClientDto>>> response = emqxClientApi.nodeClientsByUsername("c6e6e46531bf@172.18.0.2", "aaa").execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<ClientDto>> clients = response.body();

        Assertions.assertTrue(clients.getCode() == 0);

        log.info("clients: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clients));
    }

    @Test
    @SneakyThrows
    void clientAclCache() {
        Response<EmqxResponseDto<List<ClientAclCacheDto>>> response = emqxClientApi.clientAclCache("20f9638c8d1042a6a3e571e574d31851").execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<ClientAclCacheDto>> aclCaches = response.body();

        Assertions.assertTrue(aclCaches.getCode() == 0);

        log.info("clients: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(aclCaches));
    }

    @Test
    @SneakyThrows
    void removeClientAclCache() {
        Response<EmqxResponseDto<Void>> response = emqxClientApi.removeClientAclCache("20f9638c8d1042a6a3e571e574d31851").execute();

        Assertions.assertEquals(200, response.code());

        Assertions.assertTrue(response.body().getCode() == 0);
    }
}