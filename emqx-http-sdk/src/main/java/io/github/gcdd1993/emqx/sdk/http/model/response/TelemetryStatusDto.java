package io.github.gcdd1993.emqx.sdk.http.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据遥测功能状态
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
public class TelemetryStatusDto {

    /**
     * 是否启用
     */
    private boolean enabled;
}
