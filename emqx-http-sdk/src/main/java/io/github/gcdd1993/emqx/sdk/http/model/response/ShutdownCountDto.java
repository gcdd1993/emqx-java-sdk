package io.github.gcdd1993.emqx.sdk.http.model.response;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 连接关闭原因及计数，具体字段请参考文档
 *
 * @author gcdd1993
 * @since 2022/1/11
 */
@Data
@NoArgsConstructor
public class ShutdownCountDto extends LinkedHashMap<String, Integer> {

    /**
     * https://stackoverflow.com/questions/8305565/jackson-deserialize-object-or-array
     */
    public static class ShutdownCountDtoJsonSerializer extends JsonDeserializer<List<ShutdownCountDto>> {
        @Override
        public List<ShutdownCountDto> deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JacksonException {
            ObjectCodec codec = p.getCodec();
            TreeNode node = codec.readTree(p);
            if (node.isArray()) {
                ArrayNode arrayNode = (ArrayNode) node;
                List<ShutdownCountDto> result = new ArrayList<>(node.size());
                for (JsonNode n : arrayNode) {
                    result.add(nodeToValue(n, codec));
                }
                return result;
            } else {
                return Collections.singletonList(nodeToValue(node, codec));
            }
        }

        private ShutdownCountDto nodeToValue(TreeNode node, ObjectCodec codec) throws JsonProcessingException {
            return codec.treeToValue(node, ShutdownCountDto.class);
        }
    }
}
