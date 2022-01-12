package io.github.gcdd1993.emqx.sdk.http.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author gcdd1993
 * @since 2022/1/10
 */
@Data
@NoArgsConstructor
public class ResourceDto {

    /**
     * 资源 ID
     */
    private String id;

    /**
     * 资源所从属的资源类型的名字
     */
    private String type;

    /**
     * 资源的描述信息，中英文
     */
    private String description;

    /**
     * 资源的配置
     * <p>
     * 参数以 key-value 形式表示
     */
    private Map<String, Object> config;

    /**
     * 资源在每个节点的状态
     */
    private List<ResourceStatusDto> status;

    @Data
    @NoArgsConstructor
    public static class ResourceStatusDto {
        private String node;

        @JsonProperty("is_alive")
        private boolean alive;
    }

}
