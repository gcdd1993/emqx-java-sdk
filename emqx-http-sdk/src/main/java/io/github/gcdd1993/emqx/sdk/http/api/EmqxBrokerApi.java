package io.github.gcdd1993.emqx.sdk.http.api;

import io.github.gcdd1993.emqx.sdk.http.model.response.BrokerDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
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
    Call<EmqxResponseDto<List<BrokerDto>>> brokers();

    /**
     * 获取节点 node 的基本信息
     *
     * @param node 节点名称
     * @return 节点的基本信息
     */
    @GET("/api/v4/brokers/{node}")
    Call<EmqxResponseDto<BrokerDto>> broker(@Path("node") String node);

}
