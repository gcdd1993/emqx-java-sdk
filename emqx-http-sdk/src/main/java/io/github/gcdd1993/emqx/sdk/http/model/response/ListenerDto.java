package io.github.gcdd1993.emqx.sdk.http.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
public class ListenerDto {

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
     */
    @JsonProperty("shutdown_count")
    @JsonDeserialize(using = ShutdownCountDto.ShutdownCountDtoJsonSerializer.class)
    private List<ShutdownCountDto> shutdownCount;
}
