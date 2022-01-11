package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.github.gcdd1993.emqx.sdk.http.TestConstants.*;

/**
 * @author gcdd1993
 * @since 2022/1/11
 */
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
    void banned() {

    }

    @Test
    void addBanned() {
    }

    @Test
    void removeBanned() {
    }
}