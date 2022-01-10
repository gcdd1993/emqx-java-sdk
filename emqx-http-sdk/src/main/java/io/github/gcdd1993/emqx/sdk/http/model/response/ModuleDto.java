package io.github.gcdd1993.emqx.sdk.http.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 内置模块
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDto {

    /**
     * 模块名
     */
    private String name;

    /**
     * 模块功能描述
     */
    private String description;

    /**
     * 是否处于活跃状态（是否正在运行）
     */
    private boolean active;
}
