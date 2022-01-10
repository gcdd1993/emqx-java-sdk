package io.github.gcdd1993.emqx.sdk.http;

import io.github.gcdd1993.emqx.sdk.http.model.EmqxResponse;
import io.github.gcdd1993.emqx.sdk.http.model.Node;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * 节点
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxNodeApi {

    /**
     * 获取所有节点的状态
     *
     * @return 所有节点的状态
     */
    @GET("/api/v4/nodes")
    Call<EmqxResponse<List<Node>>> nodes();

    /**
     * 获取节点 node 的基本信息
     *
     * @param node 节点名称
     * @return 节点的状态
     */
    @GET("/api/v4/brokers/{node}")
    Call<EmqxResponse<Node>> node(@Path("node") String node);

}
