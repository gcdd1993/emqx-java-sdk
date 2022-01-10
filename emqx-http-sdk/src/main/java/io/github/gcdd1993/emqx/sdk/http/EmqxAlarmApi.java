package io.github.gcdd1993.emqx.sdk.http;

import io.github.gcdd1993.emqx.sdk.http.model.request.DeactivateAlarmRequest;
import io.github.gcdd1993.emqx.sdk.http.model.response.Alarm;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponse;
import io.github.gcdd1993.emqx.sdk.http.model.response.NodeAlarm;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * 告警
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxAlarmApi {

    /**
     * 返回集群下当前告警信息
     *
     * @return 告警信息
     */
    @GET("/api/v4/alarms")
    Call<EmqxResponse<List<NodeAlarm>>> alarms();

    /**
     * 返回指定节点下的告警信息
     *
     * @param node 节点名称
     * @return 告警信息
     */
    @GET("/api/v4/nodes/{node}/alarms")
    Call<EmqxResponse<List<Alarm>>> alarms(@Path("node") String node);

    /**
     * 返回集群下激活中的告警
     *
     * @return 告警信息
     */
    @GET("/api/v4/alarms/activated")
    Call<EmqxResponse<List<NodeAlarm>>> activatedAlarms();

    /**
     * 返回指定节点下激活中的告警
     *
     * @param node 节点名称
     * @return 告警信息
     */
    @GET("/api/v4/nodes/{node}/alarms/activated")
    Call<EmqxResponse<List<Alarm>>> activatedAlarms(@Path("node") String node);

    /**
     * 返回集群下已经取消的告警
     *
     * @return 告警信息
     */
    @GET("/api/v4/alarms/deactivated")
    Call<EmqxResponse<List<NodeAlarm>>> deactivatedAlarms();

    /**
     * 返回指定节点下已经取消的告警
     *
     * @param node 节点名称
     * @return 告警信息
     */
    @GET("/api/v4/nodes/{node}/alarms/deactivated")
    Call<EmqxResponse<List<Alarm>>> deactivatedAlarms(@Path("node") String node);

    /**
     * 取消指定告警
     *
     * @param request 取消指定告警请求
     * @return {"code":0}
     */
    @POST("/api/v4/alarms/deactivated")
    Call<EmqxResponse<?>> deactivateAlarm(@Body DeactivateAlarmRequest request);

    /**
     * 清除所有已经取消的告警
     *
     * @return {"code":0}
     */
    @DELETE("/api/v4/alarms/deactivated")
    Call<EmqxResponse<?>> cleanDeactivateAlarm();

    /**
     * 清除指定节点下所有已经取消的告警
     *
     * @param node 节点名称
     * @return {"code":0}
     */
    @DELETE("/api/v4/nodes/{node}/alarms/deactivated")
    Call<EmqxResponse<?>> cleanDeactivateAlarm(@Path("node") String node);

}
