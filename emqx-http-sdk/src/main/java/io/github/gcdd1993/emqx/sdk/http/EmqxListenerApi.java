package io.github.gcdd1993.emqx.sdk.http;

import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponse;
import io.github.gcdd1993.emqx.sdk.http.model.response.Listener;
import io.github.gcdd1993.emqx.sdk.http.model.response.NodeListener;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * 监听器
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxListenerApi {

    /**
     * 返回集群下的所有监听器信息
     *
     * @return 监听器信息
     */
    @GET("/api/v4/listeners")
    Call<EmqxResponse<List<NodeListener>>> listeners();

    /**
     * 返回指定节点的监听器信息
     *
     * @param node 节点名称
     * @return 监听器信息
     */
    @GET("/api/v4/nodes/{node}/listeners")
    Call<EmqxResponse<List<Listener>>> listeners(@Path("node") String node);
}
