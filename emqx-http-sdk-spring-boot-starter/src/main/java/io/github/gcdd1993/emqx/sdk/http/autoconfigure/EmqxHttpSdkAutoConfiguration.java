package io.github.gcdd1993.emqx.sdk.http.autoconfigure;

import io.github.gcdd1993.emqx.sdk.http.EmqxApiFactory;
import io.github.gcdd1993.emqx.sdk.http.api.*;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

/**
 * @author gcdd1993
 * @since 2022/1/12
 */
@EnableConfigurationProperties(EmqxHttpSdkProperties.class)
public class EmqxHttpSdkAutoConfiguration {

    @Bean
    @AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
    public EmqxApiFactory emqxApiFactory(EmqxHttpSdkProperties properties) {
        return new EmqxApiFactory(properties.getUrl(), properties.getAppId(), properties.getAppSecret());
    }

    @Bean
    public EmqxAclCacheApi aclCacheApi(EmqxHttpSdkProperties properties,
                                       EmqxApiFactory emqxApiFactory) {
        return (EmqxAclCacheApi) createApi(properties, emqxApiFactory, EmqxApiType.ACL_CACHE);
    }

    @Bean
    public EmqxActionApi actionApi(EmqxHttpSdkProperties properties,
                                   EmqxApiFactory emqxApiFactory) {
        return (EmqxActionApi) createApi(properties, emqxApiFactory, EmqxApiType.ACTION);
    }

    @Bean
    public EmqxAlarmApi alarmApi(EmqxHttpSdkProperties properties,
                                 EmqxApiFactory emqxApiFactory) {
        return (EmqxAlarmApi) createApi(properties, emqxApiFactory, EmqxApiType.ALARM);
    }

    @Bean
    public EmqxBannedApi bannedApi(EmqxHttpSdkProperties properties,
                                   EmqxApiFactory emqxApiFactory) {
        return (EmqxBannedApi) createApi(properties, emqxApiFactory, EmqxApiType.BANNED);
    }

    @Bean
    public EmqxBrokerApi brokerApi(EmqxHttpSdkProperties properties,
                                   EmqxApiFactory emqxApiFactory) {
        return (EmqxBrokerApi) createApi(properties, emqxApiFactory, EmqxApiType.BROKER);
    }

    @Bean
    public EmqxClientApi clientApi(EmqxHttpSdkProperties properties,
                                   EmqxApiFactory emqxApiFactory) {
        return (EmqxClientApi) createApi(properties, emqxApiFactory, EmqxApiType.CLIENT);
    }

    @Bean
    public EmqxEndpointApi endpointApi(EmqxHttpSdkProperties properties,
                                       EmqxApiFactory emqxApiFactory) {
        return (EmqxEndpointApi) createApi(properties, emqxApiFactory, EmqxApiType.ENDPOINT);
    }

    @Bean
    public EmqxListenerApi listenerApi(EmqxHttpSdkProperties properties,
                                       EmqxApiFactory emqxApiFactory) {
        return (EmqxListenerApi) createApi(properties, emqxApiFactory, EmqxApiType.LISTENER);
    }

    @Bean
    public EmqxMetricsApi metricsApi(EmqxHttpSdkProperties properties,
                                     EmqxApiFactory emqxApiFactory) {
        return (EmqxMetricsApi) createApi(properties, emqxApiFactory, EmqxApiType.METRICS);
    }

    @Bean
    public EmqxModuleApi moduleApi(EmqxHttpSdkProperties properties,
                                   EmqxApiFactory emqxApiFactory) {
        return (EmqxModuleApi) createApi(properties, emqxApiFactory, EmqxApiType.MODULE);
    }

    @Bean
    public EmqxNodeApi nodeApi(EmqxHttpSdkProperties properties,
                               EmqxApiFactory emqxApiFactory) {
        return (EmqxNodeApi) createApi(properties, emqxApiFactory, EmqxApiType.NODE);
    }

    @Bean
    public EmqxOperationApi operationApi(EmqxHttpSdkProperties properties,
                                         EmqxApiFactory emqxApiFactory) {
        return (EmqxOperationApi) createApi(properties, emqxApiFactory, EmqxApiType.OPERATION);
    }

    @Bean
    public EmqxPluginApi pluginApi(EmqxHttpSdkProperties properties,
                                   EmqxApiFactory emqxApiFactory) {
        return (EmqxPluginApi) createApi(properties, emqxApiFactory, EmqxApiType.PLUGIN);
    }

    @Bean
    public EmqxResourceApi resourceApi(EmqxHttpSdkProperties properties,
                                       EmqxApiFactory emqxApiFactory) {
        return (EmqxResourceApi) createApi(properties, emqxApiFactory, EmqxApiType.RESOURCE);
    }

    @Bean
    public EmqxRouteApi routeApi(EmqxHttpSdkProperties properties,
                                 EmqxApiFactory emqxApiFactory) {
        return (EmqxRouteApi) createApi(properties, emqxApiFactory, EmqxApiType.ROUTE);
    }

    @Bean
    public EmqxRuleApi ruleApi(EmqxHttpSdkProperties properties,
                               EmqxApiFactory emqxApiFactory) {
        return (EmqxRuleApi) createApi(properties, emqxApiFactory, EmqxApiType.RULE);
    }

    @Bean
    public EmqxStatsApi statsApi(EmqxHttpSdkProperties properties,
                                 EmqxApiFactory emqxApiFactory) {
        return (EmqxStatsApi) createApi(properties, emqxApiFactory, EmqxApiType.STATS);
    }

    @Bean
    public EmqxSubscriptionApi subscriptionApi(EmqxHttpSdkProperties properties,
                                               EmqxApiFactory emqxApiFactory) {
        return (EmqxSubscriptionApi) createApi(properties, emqxApiFactory, EmqxApiType.SUBSCRIPTION);
    }

    @Bean
    public EmqxTelemetryApi telemetryApi(EmqxHttpSdkProperties properties,
                                         EmqxApiFactory emqxApiFactory) {
        return (EmqxTelemetryApi) createApi(properties, emqxApiFactory, EmqxApiType.TELEMETRY);
    }

    private Object createApi(EmqxHttpSdkProperties properties,
                             EmqxApiFactory emqxApiFactory,
                             EmqxApiType type) {
        if (properties.getDisabled().contains(EmqxApiType.CLIENT)) {
            return null;
        } else {
            return emqxApiFactory.create(type.getApiClass());
        }
    }

}
