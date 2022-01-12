package io.github.gcdd1993.emqx.sdk.http.sample;

import io.github.gcdd1993.emqx.sdk.http.api.EmqxClientApi;
import io.github.gcdd1993.emqx.sdk.http.api.EmqxSubscriptionApi;
import io.github.gcdd1993.emqx.sdk.http.model.response.ClientDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.SubscriptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author gcdd1993
 * @since 2022/1/12
 */
@RestController
@RequestMapping("/api/emqx")
public class EmqxTestController {

    @Autowired
    private EmqxClientApi emqxClientApi;

    @Autowired
    private EmqxSubscriptionApi emqxSubscriptionApi;

    @GetMapping("/clients")
    public List<ClientDto> getClients() {
        try {
            Response<EmqxResponseDto<List<ClientDto>>> response = emqxClientApi.clients(Collections.emptyMap()).execute();
            if (response.code() == HttpStatus.OK.value()) {
                EmqxResponseDto<List<ClientDto>> body = response.body();
                if (body.getCode() == 0) {
                    return body.getData();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @GetMapping("/subscriptions")
    public List<SubscriptionDto> subscriptions() {
        try {
            Response<EmqxResponseDto<List<SubscriptionDto>>> response = emqxSubscriptionApi.subscriptions(Collections.emptyMap()).execute();
            if (response.code() == HttpStatus.OK.value()) {
                EmqxResponseDto<List<SubscriptionDto>> body = response.body();
                if (body.getCode() == 0) {
                    return body.getData();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
