package io.github.gcdd1993.emqx.sdk.http.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 节点下的监听器信息
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodeListener {

    /**
     * 节点名称
     */
    private String node;

    /**
     * 节点下的所有监听器信息
     */
    private List<Listener> listeners;
}
