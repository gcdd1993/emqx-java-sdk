package io.github.gcdd1993.emqx.sdk.http.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 节点的告警信息
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodeAlarm {

    /**
     * 节点名称
     */
    private String node;

    /**
     * 节点下的所告警信息
     */
    private List<Alarm> alarms;
}
