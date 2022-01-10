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
public class UnsubscribeRequest {
    /**
     * 主题
     */
    private String topic;

    /**
     * 客户端标识符
     */
    @JsonProperty("clientid")
    private String clientId;
}
