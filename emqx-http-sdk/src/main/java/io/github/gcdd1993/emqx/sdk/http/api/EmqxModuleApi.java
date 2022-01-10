package io.github.gcdd1993.emqx.sdk.http.api;

import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.NodeModuleDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.util.List;

/**
 * 内置模块
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxModuleApi {

    /**
     * 返回集群下所有内置模块信息
     *
     * @return 内置模块信息
     */
    @GET("/api/v4/modules")
    Call<EmqxResponseDto<List<NodeModuleDto>>> modules();

    /**
     * 返回指定节点下所有内置模块信息
     *
     * @param node 节点名称
     * @return 内置模块信息
     */
    @GET("/api/v4/nodes/{node}/modules")
    Call<EmqxResponseDto<List<Module>>> modules(@Path("node") String node);

    /**
     * 加载集群下所有节点的指定内置模块
     *
     * @param module 模块名称
     * @return {"code":0}
     */
    @PUT("/api/v4/modules/{module}/load")
    Call<EmqxResponseDto<Void>> loadModule(@Path("module") String module);

    /**
     * 加载指定节点下的指定内置模块
     *
     * @param node   节点名称
     * @param module 模块名称
     * @return {"code":0}
     */
    @PUT("/api/v4/nodes/{node}/modules/{module}/load")
    Call<EmqxResponseDto<Void>> loadModule(@Path("node") String node,
                                           @Path("module") String module);

    /**
     * 卸载集群下所有节点的指定内置模块
     *
     * @param module 模块名称
     * @return {"code":0}
     */
    @PUT("/api/v4/modules/{module}/unload")
    Call<EmqxResponseDto<Void>> unloadModule(@Path("module") String module);

    /**
     * 卸载指定节点下的指定内置模块
     *
     * @param node   节点名称
     * @param module 模块名称
     * @return {"code":0}
     */
    @PUT("/api/v4/nodes/{node}/modules/{module}/unload")
    Call<EmqxResponseDto<Void>> unloadModule(@Path("node") String node,
                                             @Path("module") String module);

    /**
     * 重新加载集群下所有节点的指定内置模块，仅为 emqx_mod_acl_internal 提供此功能
     *
     * @param module 模块名称
     * @return {"code":0}
     */
    @PUT("/api/v4/modules/{module}/reload")
    Call<EmqxResponseDto<Void>> reloadModule(@Path("module") String module);

    /**
     * 重新加载指定节点下的指定内置模块，仅为 emqx_mod_acl_internal 提供此功能
     *
     * @param node   节点名称
     * @param module 模块名称
     * @return {"code":0}
     */
    @PUT("/api/v4/nodes/{node}/modules/{module}/reload")
    Call<EmqxResponseDto<Void>> reloadModule(@Path("node") String node,
                                             @Path("module") String module);


}
