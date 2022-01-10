package io.github.gcdd1993.emqx.sdk.http.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 节点状态
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodeDto {

    /**
     * EMQ X 版本
     */
    private String version;

    /**
     * EMQ X 运行时间
     */
    private String uptime;

    /**
     * 已占用的进程数量
     */
    @JsonProperty("process_used")
    private Integer processUsed;

    /**
     * 可用的进程数量
     */
    @JsonProperty("process_available")
    private Integer processAvailable;

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
     * VM 已占用的内存大小
     */
    @JsonProperty("memory_used")
    private Integer memoryUsed;

    /**
     * VM 已分配的系统内存
     */
    @JsonProperty("memory_total")
    private Integer memoryTotal;

    /**
     * 操作系统的最大文件描述符限制
     */
    @JsonProperty("max_fds")
    private Integer maxFds;

    /**
     * 15 分钟内的 CPU 平均负载
     */
    private String load5;

    /**
     * 5 分钟内的 CPU 平均负载
     */
    private String load15;

    /**
     * 1 分钟内的 CPU 平均负载
     */
    private String load1;

    /**
     * 当前接入此节点的客户端数量
     */
    private Integer connections;
}
