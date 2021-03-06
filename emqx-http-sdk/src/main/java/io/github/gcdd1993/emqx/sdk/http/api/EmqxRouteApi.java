package io.github.gcdd1993.emqx.sdk.http.api;

import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.RouteDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * 路由
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxRouteApi {

    /**
     * 返回集群下的所有路由信息，支持分页机制
     *
     * @param queryMap 查询参数
     * @return 路由信息
     */
    @GET("/api/v4/routes")
    Call<EmqxResponseDto<List<RouteDto>>> routes(@QueryMap Map<String, Object> queryMap);

    /**
     * 返回集群下指定主题的路由信息
     *
     * @param topic    主题
     * @param queryMap 查询参数
     * @return 路由信息
     */
    @GET("/api/v4/routes/{topic}")
    Call<EmqxResponseDto<List<RouteDto>>> routesByTopic(@Path("topic") String topic,
                                                        @QueryMap Map<String, Object> queryMap);
}
