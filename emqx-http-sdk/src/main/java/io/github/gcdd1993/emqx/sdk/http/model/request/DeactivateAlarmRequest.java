package io.github.gcdd1993.emqx.sdk.http.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 取消指定告警
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeactivateAlarmRequest {

    /**
     * 告警所在节点
     */
    private String node;

    /**
     * 告警名称
     */
    private String name;
}
