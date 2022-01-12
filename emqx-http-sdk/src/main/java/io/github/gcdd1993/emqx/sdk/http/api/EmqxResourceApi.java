package io.github.gcdd1993.emqx.sdk.http.api;

import io.github.gcdd1993.emqx.sdk.http.model.request.ResourceRequest;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.ResourceDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.ResourceTypeDto;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * 规则引擎的资源
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxResourceApi {

    /**
     * 查询当前所有的资源类型
     *
     * @return 资源类型
     */
    @GET("/api/v4/resource_types")
    Call<EmqxResponseDto<List<ResourceTypeDto>>> resourceTypes();

    /**
     * 获取某个资源类型，包括资源描述、参数列表等
     * <p>
     * 注意资源类型只能由 emqx 提供，不能添加
     *
     * @param resourceTypeName 资源类型名称
     * @return 资源类型
     */
    @GET("/api/v4/resource_types/{resource_type_name}")
    Call<EmqxResponseDto<ResourceTypeDto>> resourceTypes(@Path("resource_type_name") String resourceTypeName);

    /**
     * 返回当前所有的资源
     *
     * @return 资源的详细信息
     */
    @GET("/api/v4/resources")
    Call<EmqxResponseDto<List<ResourceDto>>> resources();

    /**
     * 获取指定的资源的详细信息
     *
     * @param resourceId 资源类型 ID
     * @return 资源的详细信息
     */
    @GET("/api/v4/resources/{resource_id}")
    Call<EmqxResponseDto<ResourceDto>> resources(@Path("resource_id") String resourceId);

    /**
     * 创建资源，返回资源 ID
     *
     * @param request 资源
     * @return 资源 ID
     */
    @POST("/api/v4/resources")
    Call<EmqxResponseDto<ResourceDto>> createResource(@Body ResourceRequest request);

    /**
     * 删除资源
     *
     * @param resourceId 资源 ID
     * @return {"code":0}
     */
    @DELETE("/api/v4/resources/{resource_id}")
    Call<EmqxResponseDto<Void>> removeResource(@Path("resource_id") String resourceId);


}
