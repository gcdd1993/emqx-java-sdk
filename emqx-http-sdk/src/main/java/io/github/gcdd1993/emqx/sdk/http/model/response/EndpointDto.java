package io.github.gcdd1993.emqx.sdk.http.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Endpoint
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
public class EndpointDto {
    /**
     * Endpoint路径
     */
    private String path;

    /**
     * Endpoint 名
     */
    private String name;

    /**
     * HTTP Method
     */
    private String method;

    /**
     * 描述
     */
    private String descr;
}
