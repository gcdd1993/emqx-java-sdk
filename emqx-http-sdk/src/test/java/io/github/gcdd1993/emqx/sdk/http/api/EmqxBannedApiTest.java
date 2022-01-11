package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.model.request.BannedRequest;
import io.github.gcdd1993.emqx.sdk.http.model.response.BannedDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static io.github.gcdd1993.emqx.sdk.http.TestConstants.*;

/**
 * @author gcdd1993
 * @since 2022/1/11
 */
@Slf4j
class EmqxBannedApiTest {

    private EmqxBannedApi emqxBannedApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxBannedApi = emqxApiFactory.create(EmqxBannedApi.class);
    }

    @Test
    @SneakyThrows
    void banned() {
        Response<EmqxResponseDto<List<BannedDto>>> response = emqxBannedApi.banned().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<BannedDto>> banned = response.body();
        Assertions.assertEquals(0, banned.getCode());

        log.info("banned : \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(banned.getData()));

    }

    @Test
    @SneakyThrows
    void addBanned() {
        BannedRequest request = BannedRequest.builder()
                .who("admin1")
                .as("username")
                .reason("测试黑名单功能")
                .by("me")
                .at(System.currentTimeMillis() / 1000)
                .until(System.currentTimeMillis() / 1000 + 60)
                .build();

        log.info("request: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(request));

        Response<EmqxResponseDto<BannedDto>> response = emqxBannedApi.addBanned(request).execute();
        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<BannedDto> banned = response.body();

        log.info("banned: {}", banned);
        Assertions.assertEquals(0, banned.getCode());

        log.info("banned : \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(banned.getData()));
    }

    @Test
    @SneakyThrows
    void removeBanned() {
        // add banned
        BannedRequest request = BannedRequest.builder()
                .who("admin1")
                .as("username")
                .reason("测试黑名单功能")
                .by("me")
                .at(System.currentTimeMillis() / 1000)
                .until(System.currentTimeMillis() / 1000 + 60)
                .build();

        emqxBannedApi.addBanned(request).execute();
        // assert banned user exists
        Response<EmqxResponseDto<List<BannedDto>>> response = emqxBannedApi.banned().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<BannedDto>> banned = response.body();
        Assertions.assertEquals(0, banned.getCode());

        Optional<BannedDto> myBanned = banned.getData().stream()
                .filter(it -> Objects.equals(it.getAs(), "username"))
                .findAny();

        Assertions.assertTrue(myBanned.isPresent());

        // remove

        Response<EmqxResponseDto<Void>> res = emqxBannedApi.removeBanned(myBanned.get().getAs(), myBanned.get().getWho()).execute();
        Assertions.assertEquals(200, response.code());

        response = emqxBannedApi.banned().execute();

        Assertions.assertEquals(200, response.code());

        banned = response.body();
        Assertions.assertEquals(0, banned.getCode());

        myBanned = banned.getData().stream()
                .filter(it -> Objects.equals(it.getAs(), "username"))
                .findAny();

        Assertions.assertFalse(myBanned.isPresent());

    }

}