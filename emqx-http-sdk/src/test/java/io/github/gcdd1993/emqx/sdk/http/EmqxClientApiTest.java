package io.github.gcdd1993.emqx.sdk.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.model.response.Client;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author gcdd1993
 * @since 2022/1/10
 */
@Slf4j
class EmqxClientApiTest {

    private EmqxClientApi emqxClientApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .setTimeZone(TimeZone.getTimeZone("UTC"))
            .registerModule(new JavaTimeModule());

    @BeforeEach
    void setUp() {
        // https://docs.emqx.cn/broker/v4.3/advanced/http-api.html#%E6%8E%A5%E5%8F%A3%E5%AE%89%E5%85%A8
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("Authorization", "Basic YWRtaW46cHVibGlj")
                            .build();
                    return chain.proceed(request);
                })
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8081")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .client(httpClient)
                .build();
        emqxClientApi = retrofit.create(EmqxClientApi.class);
    }

    @Test
    void clients() throws IOException {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("_page", 1);
        queryMap.put("_limit", 100);
        Response<EmqxResponse<List<Client>>> response = emqxClientApi.clients(queryMap).execute();
        EmqxResponse<List<Client>> clients = response.body();

        Assertions.assertTrue(clients.getCode() == 0);

        log.info("clients: {}", clients);
    }

    @Test
    void client() {
    }

    @Test
    void removeClient() {
    }

    @Test
    void nodeClients() {
    }

    @Test
    void testClient() {
    }

    @Test
    void removeNodeClient() {
    }

    @Test
    void clientsByUsername() {
    }

    @Test
    void nodeClientsByUsername() {
    }

    @Test
    void clientAclCache() {
    }
}