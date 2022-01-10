package io.github.gcdd1993.emqx.sdk.http.api;

import io.github.gcdd1993.emqx.sdk.http.model.response.ActionDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * 动作
 * <p>
 * 查询规则引擎的动作。注意动作只能由 emqx 提供，不能添加
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxActionApi {

    /**
     * 获取某个动作的详情，包括动作名字、参数列表等
     *
     * @param actionName 可选，动作名。如不指定 action_name 则
     *                   以数组形式返回当前支持的所有动作
     * @return 动作
     */
    @GET("/v4/actions/{action_name}")
    Call<EmqxResponseDto<List<ActionDto>>> actions(@Path("action_name") String actionName);

}
