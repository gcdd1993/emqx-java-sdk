package io.github.gcdd1993.emqx.sdk.http.autoconfigure;

import io.github.gcdd1993.emqx.sdk.http.api.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author gcdd1993
 * @since 2022/1/12
 */
@RequiredArgsConstructor
@Getter
public enum EmqxApiType {
    ACL_CACHE(EmqxAclCacheApi.class),
    ACTION(EmqxActionApi.class),
    ALARM(EmqxAlarmApi.class),
    BANNED(EmqxBannedApi.class),
    BROKER(EmqxBrokerApi.class),
    CLIENT(EmqxClientApi.class),
    ENDPOINT(EmqxEndpointApi.class),
    LISTENER(EmqxListenerApi.class),
    METRICS(EmqxMetricsApi.class),
    MODULE(EmqxModuleApi.class),
    NODE(EmqxNodeApi.class),
    OPERATION(EmqxOperationApi.class),
    PLUGIN(EmqxPluginApi.class),
    RESOURCE(EmqxResourceApi.class),
    ROUTE(EmqxRouteApi.class),
    RULE(EmqxRuleApi.class),
    STATS(EmqxStatsApi.class),
    SUBSCRIPTION(EmqxSubscriptionApi.class),
    TELEMETRY(EmqxTelemetryApi.class),
    ;


    private final Class<?> apiClass;
}
