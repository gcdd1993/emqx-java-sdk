package io.github.gcdd1993.emqx.sdk.http;

import io.github.gcdd1993.emqx.sdk.http.api.EmqxClientApi;
import io.github.gcdd1993.emqx.sdk.http.model.response.ClientDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author gcdd1993
 * @since 2022/1/10
 */
@Slf4j
class EmqxApiFactoryTest {

    @Test
    void create() throws IOException {
        EmqxApiFactory emqxApiFactory = new EmqxApiFactory("http://localhost:8081", "admin", "public");
        EmqxClientApi emqxClientApi = emqxApiFactory.create(EmqxClientApi.class);
        Response<EmqxResponseDto<List<ClientDto>>> response = emqxClientApi.clients(Collections.emptyMap()).execute();

        EmqxResponseDto<List<ClientDto>> clients = response.body();

        Assertions.assertTrue(clients.getCode() == 0);

        log.info("clients: {}", clients);
    }

}