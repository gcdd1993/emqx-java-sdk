package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.model.request.RuleRequest;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.RuleDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.github.gcdd1993.emqx.sdk.http.TestConstants.*;

/**
 * @author gcdd1993
 * @since 2022/1/12
 */
@Slf4j
class EmqxRuleApiTest {

    private EmqxRuleApi emqxRuleApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxRuleApi = emqxApiFactory.create(EmqxRuleApi.class);
    }

    @Test
    @SneakyThrows
    void rule() {
        Response<EmqxResponseDto<List<RuleDto>>> response = emqxRuleApi.rules().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<RuleDto>> rules = response.body();

        Assertions.assertEquals(0, rules.getCode());

        log.info("rules: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rules.getData()));
    }

    @Test
    @SneakyThrows
    void createRule() {
        Map<String, Object> ruleActionParams = new HashMap<>();
        ruleActionParams.put("payload_tmpl", "${payload}");
        ruleActionParams.put("target_qos", 0);
        ruleActionParams.put("target_topic", "repub/to/${clientid}");
        RuleRequest.RuleActionRequest action = RuleRequest.RuleActionRequest.builder()
                .name("republish")
                .params(ruleActionParams)
                .fallbacks(List.of())
                .build();
        RuleRequest request = RuleRequest.builder()
                .id("132132132")
                .description("测试")
                .actions(List.of(action))
                .rawsql("SELECT payload.msg as msg FROM \"t/#\" WHERE msg = 'hello'")
                .build();

        Response<EmqxResponseDto<RuleDto>> response = emqxRuleApi.createRule(request).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<RuleDto> resource = response.body();

        Assertions.assertEquals(0, resource.getCode());

        log.info("create resource: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resource.getData()));
    }

    @Test
    @SneakyThrows
    void updateRule() {
        String ruleId = "132132132";
        Map<String, Object> ruleActionParams = new HashMap<>();
        ruleActionParams.put("payload_tmpl", "${payload}");
        ruleActionParams.put("target_qos", 0);
        ruleActionParams.put("target_topic", "repub/to/${clientid}");
        RuleRequest.RuleActionRequest action = RuleRequest.RuleActionRequest.builder()
                .name("republish")
                .params(ruleActionParams)
                .fallbacks(List.of())
                .build();
        RuleRequest request = RuleRequest.builder()
                .id(ruleId) // 不一致会400
                .description("测试")
                .actions(List.of(action))
                .rawsql("SELECT payload.msg as msg1 FROM \"t/#\" WHERE msg = 'hello'")
                .build();

        Response<EmqxResponseDto<RuleDto>> response = emqxRuleApi.updateRule(ruleId, request).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<RuleDto> resource = response.body();

        Assertions.assertEquals(0, resource.getCode());

        log.info("create resource: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resource.getData()));
    }

    @Test
    @SneakyThrows
    void removeRule() {
        String ruleId = "rule_1";
        Response<EmqxResponseDto<Void>> response = emqxRuleApi.removeRule(ruleId).execute();

        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals(0, response.body().getCode());
    }
}