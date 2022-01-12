package io.github.gcdd1993.emqx.sdk.http.model.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 规则
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@Builder
public class RuleRequest {

    private String id;

    /**
     * 规则的 SQL 语句
     */
    private String rawsql;

    /**
     * 可选，规则描述
     */
    private String description;

    /**
     * 动作列表
     */
    private List<RuleActionRequest> actions;

    @Data
    @Builder
    public static class RuleActionRequest {
        private String name;
        private Map<String, Object> params;
        private List<Object> fallbacks;
    }
}
