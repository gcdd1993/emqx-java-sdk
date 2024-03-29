package io.github.gcdd1993.emqx.sdk.http.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 主题订阅
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@Builder
public class SubscribeRequest {
    /**
     * 主题，与 topics 至少指定其中之一
     */
    private String topic;

    /**
     * 以 , 分割的多个主题，使用此字段能够同时订阅多个主题
     */
    private String topics;

    /**
     * QoS 等级
     */
    private Long qos;

    /**
     * 客户端标识符
     */
    @JsonProperty("clientid")
    private String clientId;
}
