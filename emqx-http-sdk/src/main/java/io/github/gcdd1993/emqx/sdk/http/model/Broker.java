package io.github.gcdd1993.emqx.sdk.http.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Broker 信息
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Broker {
    /**
     * EMQ X 版本
     */
    private String version;

    /**
     * EMQ X 运行时间，格式为 "H hours, m minutes, s seconds"
     */
    private String uptime;

    /**
     * 软件描述
     */
    private String sysdescr;

    /**
     * EMQ X 使用的 Erlang/OTP 版本
     */
    @JsonProperty("otp_release")
    private String otpRelease;

    /**
     * 节点状态
     */
    @JsonProperty("node_status")
    private String nodeStatus;

    /**
     * 节点名称
     */
    private String node;

    /**
     * 当前时间，格式为 "YYYY-MM-DD HH:mm:ss"
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime datetime;
}
