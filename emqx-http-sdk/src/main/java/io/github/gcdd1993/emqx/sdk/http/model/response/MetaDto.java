package io.github.gcdd1993.emqx.sdk.http.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页信息
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
public class MetaDto {

    /**
     * 页码
     */
    private Integer page;

    /**
     * 每页显示的数据条数
     */
    private Integer limit;

    /**
     * 表示总数，在 多条件/模糊查询时，固定为 -1
     */
    private Integer count;

    /**
     * 4.1 新增字段
     * 是否存在下一页
     */
    private Boolean hasnext;
}
