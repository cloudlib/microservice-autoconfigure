package io.cloudlib.spring.cloud.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("io.cloudlib.spring.cloud.autoconfigure")
@ConditionalOnProperty("microservice.auditing.services")
public class ServiceAuditingAutoConfiguration {
}
