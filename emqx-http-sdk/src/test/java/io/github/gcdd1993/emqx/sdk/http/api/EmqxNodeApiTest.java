package io.github.gcdd1993.emqx.sdk.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.model.response.EmqxResponseDto;
import io.github.gcdd1993.emqx.sdk.http.model.response.NodeDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.util.List;

import static io.github.gcdd1993.emqx.sdk.http.TestConstants.*;

/**
 * @author gcdd1993
 * @since 2022/1/11
 */
@Slf4j
class EmqxNodeApiTest {

    private EmqxNodeApi emqxNodeApi;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    private final EmqxApiFactory emqxApiFactory = new EmqxApiFactory(HOST, USERNAME, PASSWORD);

    @BeforeEach
    void setUp() {
        emqxNodeApi = emqxApiFactory.create(EmqxNodeApi.class);
    }

    @Test
    @SneakyThrows
    void nodes() {
        Response<EmqxResponseDto<List<NodeDto>>> response = emqxNodeApi.nodes().execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<List<NodeDto>> nodes = response.body();
        Assertions.assertEquals(0, nodes.getCode());

        log.info("nodes: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(nodes.getData()));

    }

    @Test
    @SneakyThrows
    void node() {
        Response<EmqxResponseDto<NodeDto>> response = emqxNodeApi.node(NODE).execute();

        Assertions.assertEquals(200, response.code());

        EmqxResponseDto<NodeDto> node = response.body();
        Assertions.assertEquals(0, node.getCode());

        log.info("nodes: \n{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(node.getData()));

    }
}