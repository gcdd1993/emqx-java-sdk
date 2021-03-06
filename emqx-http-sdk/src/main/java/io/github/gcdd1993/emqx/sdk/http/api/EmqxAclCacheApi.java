package io.github.gcdd1993.emqx.sdk.http.api;

import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

/**
 * ACL 缓存
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxAclCacheApi {

    /**
     * 清除集群中所有的 ACL 缓存
     *
     * @return {"code":0}
     */
    @DELETE("/api/v4/acl-cache")
    Call<EmqxResponseDto<Void>> cleanAclCache();

    /**
     * 清除指定节点的 ACL 缓存
     *
     * @param node 节点名称
     * @return {"code":0}
     */
    @DELETE("/api/v4/node/{node}/acl-cache")
    Call<EmqxResponseDto<Void>> cleanAclCache(@Path("node") String node);

}
