package io.github.gcdd1993.emqx.sdk.http.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订阅信息
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

    /**
     * 订阅主题
     */
    private String topic;

    /**
     * QoS 等级
     */
    private Integer qos;

    /**
     * 节点名称
     */
    private String node;

    /**
     * 客户端标识符
     */
    private String clientid;
}
