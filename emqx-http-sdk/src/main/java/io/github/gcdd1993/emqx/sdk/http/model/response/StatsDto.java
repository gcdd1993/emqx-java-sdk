package io.github.gcdd1993.emqx.sdk.http.model.response;

import lombok.Data;

import java.util.LinkedHashMap;

/**
 * 状态数据
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
public class StatsDto extends LinkedHashMap<String, Long> {
}
