package io.github.gcdd1993.emqx.sdk.http.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 节点的状态数据
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
public class NodeStatsDto {

    /**
     * 节点名称
     */
    private String node;

    /**
     * 节点下的所有统计指标数据
     */
    private StatsDto stats;
}
