package io.github.gcdd1993.emqx.sdk.http.autoconfigure;

import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * @author gcdd1993
 * @since 2022/1/12
 */
@EnableConfigurationProperties(EmqxHttpSdkProperties.class)
public class EmqxHttpSdkAutoConfiguration {

    @Bean
    public EmqxApiFactory emqxApiFactory(EmqxHttpSdkProperties properties,
                                         ApplicationContext ctx) {
        EmqxApiFactory emqxApiFactory = new EmqxApiFactory(properties.getUrl(), properties.getAppId(), properties.getAppSecret());

        Arrays.stream(EmqxApiType.values())
                .filter(type -> !properties.getDisabled().contains(type))
                .forEach(type -> registerApi(ctx, emqxApiFactory, type));
        return emqxApiFactory;
    }

    private void registerApi(ApplicationContext ctx,
                             EmqxApiFactory emqxApiFactory,
                             EmqxApiType type) {
        ConfigurableListableBeanFactory beanFactory = ((ConfigurableApplicationContext) ctx).getBeanFactory();
        Object obj = emqxApiFactory.create(type.getApiClass());
        beanFactory.registerSingleton(type.getApiClass().getCanonicalName(), obj);
    }


}
