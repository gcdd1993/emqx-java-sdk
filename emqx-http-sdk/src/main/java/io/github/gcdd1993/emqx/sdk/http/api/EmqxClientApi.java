package io.github.gcdd1993.emqx.sdk.http.api;

import io.github.gcdd1993.emqx.sdk.http.model.response.ClientAclCacheDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.ClientDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * 客户端
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxClientApi {

    /**
     * 返回集群下所有客户端的信息，支持分页
     *
     * @param queryMap 多条件查询，参见<a href="https://docs.emqx.cn/broker/v4.3/advanced/http-api.html#%E5%AE%A2%E6%88%B7%E7%AB%AF"></a>
     * @return 客户端的信息
     */
    @GET("/api/v4/clients")
    Call<EmqxResponseDto<List<ClientDto>>> clients(@QueryMap Map<String, Object> queryMap);

    /**
     * 返回指定客户端的信息
     *
     * @param clientId 客户端ID
     * @return 客户端的信息，客户端ID错误，返回空数组
     */
    @GET("/api/v4/clients/{clientId}")
    Call<EmqxResponseDto<List<ClientDto>>> client(@Path("clientId") String clientId);

    /**
     * 踢除指定客户端
     * <p>
     * 注意踢除客户端操作会将连接与会话一并终结
     *
     * @param clientId 客户端ID
     * @return {"code":0}
     */
    @DELETE("/api/v4/clients/{clientId}")
    Call<EmqxResponseDto<Void>> removeClient(@Path("clientId") String clientId);

    /**
     * 返回指定节点下所有客户端的信息，支持分页
     *
     * @param node     节点编号
     * @param queryMap 查询参数
     * @return 客户端的信息
     */
    @GET("/api/v4/nodes/{node}/clients")
    Call<EmqxResponseDto<List<ClientDto>>> nodeClients(@Path("node") String node,
                                                       @QueryMap Map<String, Object> queryMap);


    /**
     * 返回指定节点下指定客户端的信息
     *
     * @param node     节点编号
     * @param clientId 客户端ID
     * @return 客户端的信息
     */
    @GET("/api/v4/nodes/{node}/clients/{clientId}")
    Call<EmqxResponseDto<List<ClientDto>>> client(@Path("node") String node,
                                                  @Path("clientId") String clientId);


    /**
     * 踢除指定节点下的指定客户端
     * <p>
     * 注意踢除客户端操作会将连接与会话一并终结
     *
     * @param node     节点编号
     * @param clientId 客户端ID
     * @return {"code":0}
     */
    @DELETE("/api/v4/nodes/{node}/clients/{clientId}")
    Call<EmqxResponseDto<Void>> removeNodeClient(@Path("node") String node,
                                                 @Path("clientId") String clientId);


    /**
     * 通过 Username 查询客户端的信息
     * <p>
     * 由于可能存在多个客户端使用相同的用户名的情况，所以可能同时返回多个客户端信息。
     *
     * @param username Username
     * @return 客户端的信息
     */
    @GET("/api/v4/clients/username/{username}")
    Call<EmqxResponseDto<List<ClientDto>>> clientsByUsername(@Path("username") String username);


    /**
     * 在指定节点下，通过 Username 查询指定客户端的信息
     * <p>
     * 由于可能存在多个客户端使用相同的用户名的情况，所以可能同时返回多个客户端信息。
     *
     * @param node 节点名称
     * @param username Username
     * @return 客户端的信息
     */
    @GET("/api/v4/nodes/{node}/clients/username/{username}")
    Call<EmqxResponseDto<List<ClientDto>>> nodeClientsByUsername(@Path("node") String node,
                                                                 @Path("username") String username);

    /**
     * 查询指定客户端的 ACL 缓存
     *
     * @param clientId 客户端ID
     * @return 客户端的 ACL 缓存
     */
    @GET("/api/v4/clients/{clientId}/acl_cache")
    Call<EmqxResponseDto<List<ClientAclCacheDto>>> clientAclCache(@Path("clientId") String clientId);

    /**
     * 清除指定客户端的 ACL 缓存
     *
     * @param clientId 客户端ID
     * @return {"code":0}
     */
    @DELETE("/api/v4/clients/{clientId}/acl_cache")
    Call<EmqxResponseDto<Void>> removeClientAclCache(@Path("clientId") String clientId);

}
