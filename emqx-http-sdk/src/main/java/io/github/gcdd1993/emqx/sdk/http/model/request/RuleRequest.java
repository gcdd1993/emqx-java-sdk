package io.github.gcdd1993.emqx.sdk.http.model.request;

import io.github.gcdd1993.emqx.sdk.http.model.response.RuleActionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 规则
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RuleRequest {

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
    private List<RuleActionDto> actions;
}
