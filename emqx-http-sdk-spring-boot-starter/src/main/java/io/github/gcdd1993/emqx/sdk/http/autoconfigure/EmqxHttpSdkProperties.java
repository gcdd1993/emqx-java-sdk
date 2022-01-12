package io.github.gcdd1993.emqx.sdk.http.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Collections;
import java.util.List;

/**
 * @author gcdd1993
 * @since 2022/1/12
 */
@Data
@ConfigurationProperties("emqx.http.sdk")
public class EmqxHttpSdkProperties {

    /**
     * EMQX 服务器地址
     */
    private String url;

    /**
     * AppID
     */
    private String appId;

    /**
     * AppSecret
     */
    private String appSecret;

    /**
     * 禁用的Api列表，默认不禁用
     *
     * @see EmqxApiType
     */
    private List<EmqxApiType> disabled = Collections.emptyList();
}
