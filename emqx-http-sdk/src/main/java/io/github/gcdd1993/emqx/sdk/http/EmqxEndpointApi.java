package io.github.gcdd1993.emqx.sdk.http;

import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponse;
import io.github.gcdd1993.emqx.sdk.http.model.response.Endpoint;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * API Endpoints
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxEndpointApi {

    /**
     * 返回 EMQ X 支持的所有 Endpoints
     *
     * @return Endpoints
     */
    @GET("/api/v4")
    Call<EmqxResponse<List<Endpoint>>> endpoints();
}
