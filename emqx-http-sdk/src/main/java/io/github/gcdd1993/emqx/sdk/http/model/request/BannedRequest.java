package io.github.gcdd1993.emqx.sdk.http.model.request;

import lombok.Builder;
import lombok.Data;

/**
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@Builder
public class BannedRequest {
    /**
     * 添加至黑名单的对象，可以是客户端标识符、用户名和 IP 地址
     */
    private String who;

    /**
     * 用于区分黑名单对象类型，可以是 clientid，username，peerhost
     */
    private String as;

    /**
     * 详细信息
     */
    private String reason;

    /**
     * 指示该对象被谁添加至黑名单
     */
    private String by;

    /**
     * 添加至黑名单的时间，单位：秒
     */
    private Long at;

    /**
     * 何时从黑名单中解除，单位：秒
     */
    private Long until;

}
