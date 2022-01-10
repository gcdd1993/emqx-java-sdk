package io.github.gcdd1993.emqx.sdk.http;

import io.github.gcdd1993.emqx.sdk.http.model.request.RuleRequest;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.RuleDto;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * 规则
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxRuleApi {

    /**
     * 获取某个规则的详情，包括规则的 SQL、Topics 列表、动作列表等。还会返回当前规则和动作的统计指标的值。
     *
     * @param ruleId 规则ID
     * @return 规则
     */
    @GET("/api/v4/rules/{rule_id}")
    Call<EmqxResponseDto<RuleDto>> rule(@Path("rule_id") String ruleId);

    /**
     * 创建规则，返回规则 ID
     *
     * @param request 规则
     * @return 规则
     */
    @POST("/api/v4/rules")
    Call<EmqxResponseDto<RuleDto>> createRule(@Body RuleRequest request);

    /**
     * 创建规则，返回规则 ID
     *
     * @param ruleId  规则ID
     * @param request 规则
     * @return 规则
     */
    @PUT("/api/v4/rules/{rule_id}")
    Call<EmqxResponseDto<RuleDto>> updateRule(@Path("rule_id") String ruleId,
                                              @Body RuleRequest request);

    /**
     * 删除规则
     *
     * @param ruleId 规则ID
     * @return {"code":0}
     */
    @DELETE("/api/v4/rules/{rule_id}")
    Call<EmqxResponseDto<?>> removeRule(@Path("rule_id") String ruleId);


}
