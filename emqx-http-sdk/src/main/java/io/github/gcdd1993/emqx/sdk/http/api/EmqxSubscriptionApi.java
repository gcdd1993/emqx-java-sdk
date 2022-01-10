package io.github.gcdd1993.emqx.sdk.http.api;

import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.SubscriptionDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * 订阅信息
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxSubscriptionApi {

    /**
     * 返回集群下所有订阅信息，支持分页机制
     *
     * @param queryMap 查询参数
     * @return 订阅信息
     */
    @GET("/api/v4/subscriptions")
    Call<EmqxResponseDto<List<SubscriptionDto>>> subscriptions(@QueryMap Map<String, Object> queryMap);

    /**
     * 返回集群下指定客户端的订阅信息
     *
     * @param clientId clientId
     * @return 订阅信息
     */
    @GET("/api/v4/subscriptions/{clientId}")
    Call<EmqxResponseDto<List<SubscriptionDto>>> subscriptionsByClient(@Path("clientId") String clientId);


    /**
     * 返回指定节点下的所有订阅信息，支持分页机制
     *
     * @param node     节点名称
     * @param queryMap 查询参数
     * @return 订阅信息
     */
    @GET("/api/v4/nodes/{node}/subscriptions")
    Call<EmqxResponseDto<List<SubscriptionDto>>> subscriptionsByNode(@Path("node") String node,
                                                                     @QueryMap Map<String, Object> queryMap);


    /**
     * 在指定节点下，查询某 clientId 的所有订阅信息，支持分页机制
     *
     * @param node     节点名称
     * @param clientId clientId
     * @param queryMap 查询参数
     * @return 订阅信息
     */
    @GET("/api/v4/nodes/{node}/subscriptions/{clientId}")
    Call<EmqxResponseDto<List<SubscriptionDto>>> subscriptionsByNodeAndClient(@Path("node") String node,
                                                                              @Path("clientId") String clientId,
                                                                              @QueryMap Map<String, Object> queryMap);

}
