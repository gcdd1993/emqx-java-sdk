package io.github.gcdd1993.emqx.sdk.http.model.request;

import lombok.Builder;
import lombok.Data;

/**
 * 主题统计指标
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@Builder
public class TopicMetricsRequest {

    /**
     * 主题名
     */
    private String topic;

}
