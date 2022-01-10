package io.github.gcdd1993.emqx.sdk.http;

import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.NodePluginDto;
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
    Call<EmqxResponseDto<List<NodePluginDto>>> plugins();

    /**
     * 返回指定节点下的插件信息
     *
     * @param node 节点名称
     * @return 插件信息
     */
    @GET("/api/v4/nodes/{node}/plugins")
    Call<EmqxResponseDto<List<NodePluginDto>>> plugins(@Path("node") String node);

    /**
     * 加载指定节点下的指定插件
     *
     * @param node   节点名称
     * @param plugin 插件名称
     * @return {"code":0}
     */
    @PUT("/api/v4/nodes/{node}/plugins/{plugin}/load")
    Call<EmqxResponseDto<?>> loadPlugin(@Path("node") String node,
                                        @Path("plugin") String plugin);

    /**
     * 卸载指定节点下的指定插件
     *
     * @param node   节点名称
     * @param plugin 插件名称
     * @return {"code":0}
     */
    @PUT("/api/v4/nodes/{node}/plugins/{plugin}/unload")
    Call<EmqxResponseDto<?>> unloadPlugin(@Path("node") String node,
                                          @Path("plugin") String plugin);

    /**
     * 重新加载指定节点下的指定插件
     *
     * @param node   节点名称
     * @param plugin 插件名称
     * @return {"code":0}
     */
    @PUT("/api/v4/nodes/{node}/plugins/{plugin}/reload")
    Call<EmqxResponseDto<?>> reloadPlugin(@Path("node") String node,
                                          @Path("plugin") String plugin);

}
