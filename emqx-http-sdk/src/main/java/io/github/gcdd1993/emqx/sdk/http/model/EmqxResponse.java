package io.github.gcdd1993.emqx.sdk.http.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmqxResponse<T> {

    /**
     * 返回码
     *
     * <a href="https://docs.emqx.cn/broker/v4.3/advanced/http-api.html#%E5%93%8D%E5%BA%94%E7%A0%81"></a>
     */
    private Integer code;

    /**
     * 接口数据
     */
    private T data;
}
