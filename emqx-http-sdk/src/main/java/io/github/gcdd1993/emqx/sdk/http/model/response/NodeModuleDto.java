package io.github.gcdd1993.emqx.sdk.http.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 节点下的内置模块信息
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
public class NodeModuleDto {

    /**
     * 节点名称
     */
    private String node;

    /**
     * 节点下的所有内置模块信息
     */
    private List<ModuleDto> modules;
}
