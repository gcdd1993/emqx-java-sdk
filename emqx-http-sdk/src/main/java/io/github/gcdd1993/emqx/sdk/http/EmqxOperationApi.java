package io.github.gcdd1993.emqx.sdk.http;

import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.request.PublishRequest;
import io.github.gcdd1993.emqx.sdk.http.model.request.SubscribeRequest;
import io.github.gcdd1993.emqx.sdk.http.model.request.UnsubscribeRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 消息发布/订阅
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxOperationApi {

    /**
     * 发布 MQTT 消息
     *
     * @param request 消息
     * @return {"code":0}
     */
    @POST("/api/v4/mqtt/publish")
    Call<EmqxResponseDto<?>> publish(@Body PublishRequest request);

    /**
     * 批量发布 MQTT 消息
     *
     * @param request 消息
     * @return {"code":0}
     */
    @POST("/api/v4/mqtt/publish_batch")
    Call<EmqxResponseDto<?>> batchPublish(@Body List<PublishRequest> request);

    /**
     * 主题订阅
     *
     * @param request 消息
     * @return {"code":0}
     */
    @POST("/api/v4/mqtt/subscribe")
    Call<EmqxResponseDto<?>> subscribe(@Body SubscribeRequest request);

    /**
     * 批量订阅 MQTT 主题
     *
     * @param request 消息
     * @return {"code":0}
     */
    @POST("/api/v4/mqtt/subscribe_batch")
    Call<EmqxResponseDto<?>> batchSubscribe(@Body List<SubscribeRequest> request);

    /**
     * 取消订阅
     *
     * @param request 消息
     * @return {"code":0}
     */
    @POST("/api/v4/mqtt/unsubscribe")
    Call<EmqxResponseDto<?>> unsubscribe(@Body UnsubscribeRequest request);

    /**
     * 批量取消订阅
     *
     * @param request 消息
     * @return {"code":0}
     */
    @POST("/api/v4/mqtt/unsubscribe_batch")
    Call<EmqxResponseDto<?>> batchUnsubscribe(@Body List<UnsubscribeRequest> request);

}
