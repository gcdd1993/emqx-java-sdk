package io.github.gcdd1993.emqx.sdk.http.api;

import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.NodeStatsDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.StatsDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * 状态
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxStatsApi {

    /**
     * 返回集群下所有状态数据
     *
     * @return 状态数据
     */
    @GET("/api/v4/stats")
    Call<EmqxResponseDto<List<NodeStatsDto>>> stats();

    /**
     * 返回指定节点上的状态数据
     *
     * @param node 节点名称
     * @return 状态数据
     */
    @GET("/api/v4/nodes/{node}/stats")
    Call<EmqxResponseDto<StatsDto>> stats(@Path("node") String node);

}
