package io.github.gcdd1993.emqx.sdk.http.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 告警详情
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@NoArgsConstructor
@Data
public class AlarmDetailsDto {

    @JsonProperty("high_watermark")
    private Integer highWatermark;
}
