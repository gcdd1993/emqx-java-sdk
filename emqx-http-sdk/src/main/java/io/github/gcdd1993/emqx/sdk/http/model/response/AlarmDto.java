package io.github.gcdd1993.emqx.sdk.http.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 告警信息
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlarmDto {
    /**
     * 告警名称
     */
    private String name;

    /**
     * 人类易读的告警信息
     */
    private String message;

    /**
     * 告警详情
     */
    private AlarmDetailsDto details;

    /**
     * 告警激活时间，以微秒为单位的 UNIX 时间戳
     */
    @JsonProperty("activate_at")
    private Long activateAt;

    /**
     * 告警取消激活时间，以微秒为单位的 UNIX 时间戳
     */
    @JsonProperty("deactivate_at")
    private Long deactivateAt;

    /**
     * 是否激活
     */
    private boolean activated;

}
