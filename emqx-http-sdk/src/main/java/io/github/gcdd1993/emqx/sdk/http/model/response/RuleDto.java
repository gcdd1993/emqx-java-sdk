package io.github.gcdd1993.emqx.sdk.http.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
public class RuleDto {

    /**
     * Rule ID
     */
    private String id;

    /**
     * 规则的描述信息
     */
    private String description;

    /**
     * SQL 语句
     */
    private String rawsql;

    /**
     * Topic 列表，表示哪些 topic 可以匹配到此规则
     */
    @JsonProperty("for")
    private List<String> forTopic;

    /**
     * 是否启用
     */
    private boolean enabled;

    @JsonProperty("on_action_failed")
    private String onActionFailed;

    /**
     * 规则的动作
     */
    private List<RuleActionDto> actions;

    /**
     * 统计数据
     */
    private List<RuleMetricsDto> metrics;

    /**
     * 规则统计指标数据
     */
    @Data
    @NoArgsConstructor
    public static class RuleMetricsDto {
        @JsonProperty("speed_max")
        private Integer speedMax;
        @JsonProperty("speed_last5m")
        private Double speedLast5m;
        private Double speed;
        private String node;
        private Integer matched;
    }

    @Data
    @NoArgsConstructor
    public static class RuleActionDto {
        private String id;
        private String name;
        /**
         * 动作的参数列表。参数以 key-value 形式表示
         */
        private Map<String, Object> params;
        /**
         * 统计指标数据
         */
        private List<RuleActionMetricsDto> metrics;
        // fixme 未知数据结构
        private List<Object> fallbacks;
    }

    @Data
    @NoArgsConstructor
    public static class RuleActionMetricsDto {
        private String node;
        private Integer success;
        private Integer failed;
    }

}
