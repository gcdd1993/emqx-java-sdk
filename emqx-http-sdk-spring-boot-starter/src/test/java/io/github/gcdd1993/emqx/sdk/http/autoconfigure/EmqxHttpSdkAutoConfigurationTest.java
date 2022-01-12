package io.github.gcdd1993.emqx.sdk.http.autoconfigure;

import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.api.EmqxAclCacheApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author gcdd1993
 * @since 2022/1/12
 */
@SpringBootTest
@ActiveProfiles("test")
class EmqxHttpSdkAutoConfigurationTest {

    @Autowired(required = false)
    private EmqxAclCacheApi emqxAclCacheApi;

    @Autowired(required = false)
    private EmqxApiFactory emqxApiFactory;

    @Test
    public void autoconfigure() {
        Assertions.assertNotNull(emqxApiFactory);
        Assertions.assertNotNull(emqxAclCacheApi);
    }

}