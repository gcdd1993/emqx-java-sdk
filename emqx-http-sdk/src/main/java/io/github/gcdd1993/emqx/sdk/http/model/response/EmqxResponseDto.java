package io.github.gcdd1993.emqx.sdk.http.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
public class EmqxResponseDto<T> {

    /**
     * 返回码
     *
     * <a href="https://docs.emqx.cn/broker/v4.3/advanced/http-api.html#%E5%93%8D%E5%BA%94%E7%A0%81"></a>
     */
    private Integer code;

    /**
     * 仅在发生错误时返回，用于提供更详细的错误信息
     */
    private String message;

    /**
     * 接口数据
     */
    private T data;

    /**
     * 分页信息
     */
    private MetaDto meta;
}
