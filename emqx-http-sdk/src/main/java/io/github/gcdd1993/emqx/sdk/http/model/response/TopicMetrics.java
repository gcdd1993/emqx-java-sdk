package io.github.gcdd1993.emqx.sdk.http.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 主题统计指标
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicMetrics {

    /**
     * 主题名
     */
    private String topic;

    /**
     * 主题统计指标数据
     */
    private Metrics metrics;
}
