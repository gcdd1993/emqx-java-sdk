package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.model.response.BrokerDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
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
import java.util.List;
import java.util.TimeZone;

/**
 * @author gcdd1993
 * @since 2022/1/10
 */
@Slf4j
class EmqxBrokerApiTest {

    private EmqxBrokerApi emqxBrokerApi;
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
        emqxBrokerApi = retrofit.create(EmqxBrokerApi.class);
    }

    @Test
    void brokers() throws IOException {
        Response<EmqxResponseDto<List<BrokerDto>>> response = emqxBrokerApi.brokers().execute();
        EmqxResponseDto<List<BrokerDto>> brokers = response.body();

        Assertions.assertTrue(brokers.getCode() == 0);
        log.info("brokers: {}", brokers.getData());
    }

    @Test
    void broker() throws IOException {
        Response<EmqxResponseDto<List<BrokerDto>>> response = emqxBrokerApi.brokers().execute();
        EmqxResponseDto<List<BrokerDto>> brokers = response.body();

        Assertions.assertTrue(brokers.getCode() == 0);

        brokers.getData()
                .forEach(broker -> {
                    try {
                        Response<EmqxResponseDto<BrokerDto>> res = emqxBrokerApi.broker(broker.getNode()).execute();
                        EmqxResponseDto<BrokerDto> brokerInfo = res.body();

                        Assertions.assertTrue(brokerInfo.getCode() == 0);

                        log.info("broker: {}", broker);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}