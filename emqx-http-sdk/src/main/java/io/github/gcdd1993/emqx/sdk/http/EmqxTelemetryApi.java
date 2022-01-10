package io.github.gcdd1993.emqx.sdk.http;

import io.github.gcdd1993.emqx.sdk.http.model.request.TelemetryStatusRequest;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.TelemetryDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.TelemetryStatusDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;

/**
 * 数据遥测
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxTelemetryApi {

    /**
     * 启用或关闭数据遥测功能
     *
     * @param request 数据遥测功能
     * @return {"code":0}
     */
    @PUT("/api/v4/telemetry/status")
    Call<EmqxResponseDto<?>> changeStatus(@Body TelemetryStatusRequest request);

    /**
     * 查询数据遥测功能是否启用
     *
     * @return 数据遥测功能是否启用
     */
    @GET("/api/v4/telemetry/status")
    Call<EmqxResponseDto<TelemetryStatusDto>> status();

    /**
     * 获取数据遥测功能上报的数据内容
     *
     * @return 遥测数据内容
     */
    @GET("/api/v4/telemetry/data")
    Call<EmqxResponseDto<TelemetryDto>> data();

}
