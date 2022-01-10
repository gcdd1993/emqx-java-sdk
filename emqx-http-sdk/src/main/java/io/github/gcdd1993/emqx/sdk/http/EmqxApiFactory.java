package io.github.gcdd1993.emqx.sdk.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;
import java.util.TimeZone;

/**
 * @author gcdd1993
 * @since 2022/1/10
 */
public class EmqxApiFactory {
    private final Retrofit retrofit;

    public EmqxApiFactory(String baseUrl,
                          String appId,
                          String appSecret) {
        this(baseUrl, appId, appSecret, new OkHttpClient.Builder(), new ObjectMapper());
    }


    public EmqxApiFactory(String baseUrl,
                          String appId,
                          String appSecret,
                          OkHttpClient.Builder httpClientBuilder,
                          ObjectMapper objectMapper) {
        Objects.requireNonNull(baseUrl, "请设置 EMQX base_url 参数");
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(baseUrl);
        if (objectMapper != null) {
            objectMapper
                    .setTimeZone(TimeZone.getTimeZone("UTC"))
                    .registerModule(new JavaTimeModule());
            builder.addConverterFactory(JacksonConverterFactory.create(objectMapper));
        }
        if (httpClientBuilder == null) {
            httpClientBuilder = new OkHttpClient.Builder();
        }
        String basicToken = Base64.getEncoder().encodeToString((appId + ":" + appSecret).getBytes(StandardCharsets.UTF_8));
        httpClientBuilder.addInterceptor(chain -> {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("Authorization", "Basic " + basicToken)
                    .build();
            return chain.proceed(request);
        });

        builder.client(httpClientBuilder.build());
        this.retrofit = builder.build();
    }

    /**
     * 创建 Api 实例
     *
     * @param clazz 泛型 T 的类型
     * @param <T>   泛型
     * @return Api 实例
     */
    public <T> T create(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}
