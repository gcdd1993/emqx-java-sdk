package io.github.gcdd1993.emqx.sdk.http.api;

import io.github.gcdd1993.emqx.sdk.http.model.request.TopicMetricsRequest;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.MetricsDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.NodeMetricsDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.TopicMetricsDto;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * 统计指标
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxMetricsApi {

    /**
     * 返回集群下所有统计指标数据
     *
     * @return 统计指标数据
     */
    @GET("/api/v4/metrics")
    Call<EmqxResponseDto<List<NodeMetricsDto>>> metrics();

    /**
     * 返回集群下所有统计指标数据
     *
     * @param node 节点名称
     * @return 统计指标数据
     */
    @GET("/api/v4/nodes/{node}/metrics")
    Call<EmqxResponseDto<MetricsDto>> nodeMetrics(@Path("node") String node);

    /**
     * 返回集群下所有统计指标数据
     *
     * @return 统计指标数据
     */
    @GET("/api/v4/topic-metrics")
    Call<EmqxResponseDto<List<TopicMetricsDto>>> topicMetrics();

    /**
     * 返回指定主题的统计指标数据
     *
     * @param topic 主题名称
     * @return 统计指标数据
     */
    @GET("/api/v4/topic-metrics/{topic}")
    Call<EmqxResponseDto<MetricsDto>> topicMetrics(@Path("topic") String topic);

    /**
     * 开启对指定主题的指标统计
     *
     * @param request 主题名称
     * @return {"code":0}
     */
    @POST("/api/v4/topic-metrics")
    Call<EmqxResponseDto<Void>> startTopicMetrics(@Body TopicMetricsRequest request);

    /**
     * 关闭对指定主题的指标统计
     *
     * @param topic 主题名称
     * @return {"code":0}
     */
    @DELETE("/api/v4/topic-metrics/{topic}")
    Call<EmqxResponseDto<Void>> stopTopicMetrics(@Path("topic") String topic);

    /**
     * 关闭所有主题的指标统计
     *
     * @return {"code":0}
     */
    @DELETE("/api/v4/topic-metrics/{topic}")
    Call<EmqxResponseDto<Void>> stopTopicMetrics();


}
