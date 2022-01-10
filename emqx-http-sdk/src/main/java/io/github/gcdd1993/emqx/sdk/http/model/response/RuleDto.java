package io.github.gcdd1993.emqx.sdk.http.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
}
