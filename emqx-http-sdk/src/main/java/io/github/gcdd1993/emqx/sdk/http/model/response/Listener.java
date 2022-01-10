package io.github.gcdd1993.emqx.sdk.http.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 监听器
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Listener {

    /**
     * Acceptor 进程数量
     */
    private Integer acceptors;

    /**
     * 监听端口
     */
    @JsonProperty("listen_on")
    private String listenOn;

    /**
     * 协议
     */
    private String protocol;

    /**
     * 当前连接数量
     */
    @JsonProperty("current_conns")
    private Integer currentConns;

    /**
     * 允许建立的最大连接数量
     */
    @JsonProperty("max_conns")
    private Integer maxConns;

    /**
     * 连接关闭原因及计数
     * <p>
     * fixme shutdownCount 数据结构未知
     */
    @JsonProperty("shutdown_count")
    private List<?> shutdownCount;
}
