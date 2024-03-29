package io.github.gcdd1993.emqx.sdk.http.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 客户端的信息
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
public class ClientDto {

    /**
     * 客户端所连接的节点名称
     */
    private String node;

    /**
     * 客户端标识符
     */
    private String clientid;

    /**
     * 客户端连接时使用的用户名
     */
    private String username;

    /**
     * 客户端协议名称
     */
    @JsonProperty("proto_name")
    private String protoName;

    /**
     * 客户端使用的协议版本
     */
    @JsonProperty("proto_ver")
    private Long protoVer;

    /**
     * 客户端的 IP 地址
     */
    @JsonProperty("ip_address")
    private String ipAddress;

    /**
     * 客户端的端口
     */
    private Long port;

    /**
     * 指示客户端是否通过桥接方式连接
     */
    @JsonProperty("is_bridge")
    private boolean bridge;

    /**
     * 客户端连接时间
     */
    @JsonProperty("connected_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime connectedAt;

    /**
     * 客户端离线时间，此字段仅在 connected 为 false 时有效并被返回
     */
    @JsonProperty("disconnected_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime disconnectedAt;

    /**
     * 客户端是否处于连接状态
     */
    private boolean connected;

    /**
     * 指示客户端使用的配置组
     */
    private String zone;

    /**
     * 保持连接时间，单位：秒
     */
    private Long keepalive;

    /**
     * 指示客户端是否使用了全新的会话
     */
    @JsonProperty("clean_start")
    private Boolean cleanStart;

    /**
     * 会话过期间隔，单位：秒
     */
    @JsonProperty("expiry_interval")
    private Long expiryInterval;

    /**
     * 会话创建时间
     */
    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * 此客户端已建立的订阅数量
     */
    @JsonProperty("subscriptions_cnt")
    private Long subscriptionsCnt;

    /**
     * 此客户端允许建立的最大订阅数量
     */
    @JsonProperty("max_subscriptions")
    private Long maxSubscriptions;

    /**
     * 飞行队列当前长度
     */
    private Long inflight;

    /**
     * 飞行队列最大长度
     */
    @JsonProperty("max_inflight")
    private Long maxInflight;

    /**
     * 消息队列当前长度
     */
    @JsonProperty("mqueue_len")
    private Long mqueueLen;

    /**
     * 消息队列最大长度
     */
    @JsonProperty("max_mqueue")
    private Long maxMqueue;

    /**
     * 消息队列因超出长度而丢弃的消息数量
     */
    @JsonProperty("mqueue_dropped")
    private Long mqueueDropped;

    /**
     * 未确认的 PUBREC 报文数量
     */
    @JsonProperty("awaiting_rel")
    private Long awaitingRel;

    /**
     * 允许存在未确认的 PUBREC 报文的最大数量
     */
    @JsonProperty("max_awaiting_rel")
    private Long maxAwaitingRel;

    /**
     * EMQ X Broker（下同）接收的字节数量
     */
    @JsonProperty("recv_oct")
    private Long recvOct;

    /**
     * 接收的 TCP 报文数量
     */
    @JsonProperty("recv_cnt")
    private Long recvCnt;

    /**
     * 接收的 MQTT 报文数量
     */
    @JsonProperty("recv_pkt")
    private Long recvPkt;

    /**
     * 接收的 PUBLISH 报文数量
     */
    @JsonProperty("recv_msg")
    private Long recvMsg;

    /**
     * 发送的字节数量
     */
    @JsonProperty("send_oct")
    private Long sendOct;

    /**
     * 发送的 TCP 报文数量
     */
    @JsonProperty("send_cnt")
    private Long sendCnt;

    /**
     * 发送的 MQTT 报文数量
     */
    @JsonProperty("send_pkt")
    private Long sendPkt;

    /**
     * 发送的 PUBLISH 报文数量
     */
    @JsonProperty("send_msg")
    private Long sendMsg;

    /**
     * 进程邮箱大小
     */
    @JsonProperty("mailbox_len")
    private Long mailboxLen;

    /**
     * 进程堆栈大小，单位：字节
     */
    @JsonProperty("heap_size")
    private Long heapSize;

    /**
     * Erlang reduction
     */
    private Long reductions;

    /**
     * fixme 未知参数，文档上没有
     */
    private String mountpoint;
}
