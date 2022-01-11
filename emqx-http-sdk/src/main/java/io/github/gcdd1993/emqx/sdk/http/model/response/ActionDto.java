package io.github.gcdd1993.emqx.sdk.http.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 动作
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
public class ActionDto {

    private String name;

    /**
     * 动作的简述，中英文
     */
    private DescriptionDto title;

    /**
     * 动作的描述信息，中英文
     */
    private DescriptionDto description;

    /**
     * 指示当前动作从属于那些资源类型
     */
    private List<String> types;

    /**
     * 动作的参数列表。参数以 key-value 形式表示
     */
    private Map<String, Object> params;

    /**
     * Topic 列表，表示哪些 topic 可以匹配到此规则
     */
    @JsonProperty("for")
    private String forTopic;

    /**
     * 动作的提供者
     */
    private String app;

    /**
     * 类别
     */
    private String category;

}
