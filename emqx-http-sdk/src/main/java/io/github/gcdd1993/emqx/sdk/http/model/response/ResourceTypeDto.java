package io.github.gcdd1993.emqx.sdk.http.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 规则引擎的资源类型
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
public class ResourceTypeDto {

    /**
     * 资源类型名称
     */
    private String name;

    /**
     * 资源类型的简述，中英文
     */
    private DescriptionDto title;

    /**
     * 动作的描述信息，中英文
     */
    private DescriptionDto description;

    /**
     * 资源类型的描述信息，中英文
     */
    private String provider;

    /**
     * 资源类型的参数列表
     * <p>
     * 参数以 key-value 形式表示
     */
    private Map<String, Object> params;

}
