package io.github.gcdd1993.emqx.sdk.http;

import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponse;
import io.github.gcdd1993.emqx.sdk.http.model.response.NodePlugin;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.util.List;

/**
 * 插件信息
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxPluginApi {

    /**
     * 返回集群下的所有插件信息
     *
     * @return 插件信息
     */
    @GET("/api/v4/plugins")
    Call<EmqxResponse<List<NodePlugin>>> plugins();

    /**
     * 返回指定节点下的插件信息
     *
     * @param node 节点名称
     * @return 插件信息
     */
    @GET("/api/v4/nodes/{node}/plugins")
    Call<EmqxResponse<List<NodePlugin>>> plugins(@Path("node") String node);

    /**
     * 加载指定节点下的指定插件
     *
     * @param node   节点名称
     * @param plugin 插件名称
     * @return {"code":0}
     */
    @PUT("/api/v4/nodes/{node}/plugins/{plugin}/load")
    Call<EmqxResponse<?>> loadPlugin(@Path("node") String node,
                                     @Path("plugin") String plugin);

    /**
     * 卸载指定节点下的指定插件
     *
     * @param node   节点名称
     * @param plugin 插件名称
     * @return {"code":0}
     */
    @PUT("/api/v4/nodes/{node}/plugins/{plugin}/unload")
    Call<EmqxResponse<?>> unloadPlugin(@Path("node") String node,
                                       @Path("plugin") String plugin);

    /**
     * 重新加载指定节点下的指定插件
     *
     * @param node   节点名称
     * @param plugin 插件名称
     * @return {"code":0}
     */
    @PUT("/api/v4/nodes/{node}/plugins/{plugin}/reload")
    Call<EmqxResponse<?>> reloadPlugin(@Path("node") String node,
                                       @Path("plugin") String plugin);

}
