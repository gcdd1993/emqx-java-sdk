package io.github.gcdd1993.emqx.sdk.http.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gcdd1993
 * @since 2022/1/12
 */
@Slf4j
@SpringBootApplication
public class EmqxSdkHttpSampleApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(EmqxSdkHttpSampleApplication.class, args);
        } catch (Exception ex) {
            log.error("app run error.", ex);
            System.exit(1);
        }
    }
}
