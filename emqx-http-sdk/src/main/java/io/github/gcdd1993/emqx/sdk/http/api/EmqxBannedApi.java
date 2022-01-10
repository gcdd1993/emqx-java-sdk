package io.github.gcdd1993.emqx.sdk.http.api;

import io.github.gcdd1993.emqx.sdk.http.model.response.BannedDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * 黑名单
 *
 * @author gcdd1993
 * @since 2022/1/10
 */
public interface EmqxBannedApi {

    /**
     * 获取黑名单
     *
     * @return 黑名单
     */
    @GET("/api/v4/banned")
    Call<EmqxResponseDto<List<BannedDto>>> banned();

    /**
     * 将对象添加至黑名单
     *
     * @param banned 黑名单
     * @return 黑名单
     */
    @POST("/api/v4/banned")
    Call<EmqxResponseDto<BannedDto>> addBanned(@Body BannedDto banned);

    /**
     * 将对象从黑名单中删除
     *
     * @param as  用于区分黑名单对象类型，可以是 clientid，username，peerhost
     * @param who 添加至黑名单的对象，可以是客户端标识符、用户名和 IP 地址
     * @return {"code":0}
     */
    @DELETE("/api/v4/banned/{as}/{who}")
    Call<EmqxResponseDto<Void>> removeBanned(@Path("as") String as,
                                             @Path("who") String who);

}
