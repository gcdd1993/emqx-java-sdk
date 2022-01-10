package io.github.gcdd1993.emqx.sdk.http;

import io.github.gcdd1993.emqx.sdk.http.model.response.Broker;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Broker 基本信息
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxBrokerApi {

    /**
     * 获取所有节点的基本信息
     *
     * @return 节点的基本信息列表
     */
    @GET("/api/v4/brokers")
    Call<EmqxResponse<List<Broker>>> brokers();

    /**
     * 获取节点 node 的基本信息
     *
     * @param node 节点名称
     * @return 节点的基本信息
     */
    @GET("/api/v4/brokers/{node}")
    Call<EmqxResponse<Broker>> broker(@Path("node") String node);

}
