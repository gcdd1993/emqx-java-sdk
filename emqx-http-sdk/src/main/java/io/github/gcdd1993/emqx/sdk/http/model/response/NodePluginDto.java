package io.github.gcdd1993.emqx.sdk.http.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 节点下的插件信息
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
public class NodePluginDto {

    /**
     * 节点名称
     */
    private String node;

    /**
     * 节点下的所有插件信息
     */
    private List<PluginDto> plugins;
}
