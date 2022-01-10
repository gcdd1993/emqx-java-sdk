package io.github.gcdd1993.emqx.sdk.http.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 客户端的ACL缓存
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
public class ClientAclCacheDto {

    /**
     * ACL 缓存建立时间
     */
    @JsonProperty("updated_time")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private Long updatedTime;

    /**
     * MQTT 主题
     */
    private String topic;

    /**
     * 允许/拒绝
     */
    private String result;

    /**
     * 发布/订阅
     */
    private String access;
}
