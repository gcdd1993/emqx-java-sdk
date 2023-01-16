package io.github.gcdd1993.emqx.sdk.http.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * MQTT 消息
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@Builder
public class PublishRequest {
    /**
     * 主题，与 topics 至少指定其中之一
     */
    private String topic;

    /**
     * 以 , 分割的多个主题，使用此字段能够同时发布消息到多个主题
     */
    private String topics;

    /**
     * 客户端标识符
     */
    @JsonProperty("clientid")
    private String clientId;

    /**
     * 消息正文
     */
    private String payload;

    /**
     * 消息正文使用的编码方式，目前仅支持 plain 与 base64 两种
     */
    private String encoding;

    /**
     * QoS 等级
     */
    private Long qos;

    /**
     * 是否为保留消息
     */
    private Boolean retain;
}
