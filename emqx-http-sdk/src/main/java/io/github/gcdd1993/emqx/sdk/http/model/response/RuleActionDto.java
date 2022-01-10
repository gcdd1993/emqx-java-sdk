package io.github.gcdd1993.emqx.sdk.http.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 规则动作
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RuleActionDto {

    /**
     * Action ID
     */
    private String id;

    /**
     * 动作名称
     */
    private String name;

    /**
     * 动作参数
     */
    private Map<String, Object> params;

    /**
     * 统计指标，具体可参看 Dashboard 上的 Rule Metrics
     */
    private Map<String, Object> metrics;
}
