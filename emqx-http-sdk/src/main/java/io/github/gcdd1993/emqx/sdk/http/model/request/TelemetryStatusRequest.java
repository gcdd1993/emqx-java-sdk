package io.github.gcdd1993.emqx.sdk.http.model.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据遥测功能启用/关闭
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@Builder
@NoArgsConstructor
public class TelemetryStatusRequest {
    /**
     * 是否启用
     */
    private boolean enabled;
}
