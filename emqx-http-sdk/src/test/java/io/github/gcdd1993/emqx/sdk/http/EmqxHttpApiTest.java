package io.github.gcdd1993.emqx.sdk.http;

import io.github.gcdd1993.emqx.sdk.http.model.EmqxResponse;
import io.github.gcdd1993.emqx.sdk.http.model.Endpoint;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author gcdd1993
 * @since 2022/1/10
 */
@Slf4j
class EmqxHttpApiTest {

    private EmqxHttpApi emqxHttpApi;

    @BeforeEach
    void setUp() {
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
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient)
                .build();
        emqxHttpApi = retrofit.create(EmqxHttpApi.class);
    }

    @Test
    void endpoints() throws IOException {
        Response<EmqxResponse<List<Endpoint>>> response = emqxHttpApi.endpoints().execute();
        EmqxResponse<List<Endpoint>> endpoints = response.body();
        log.info("endpoints: {}", endpoints);
    }
}