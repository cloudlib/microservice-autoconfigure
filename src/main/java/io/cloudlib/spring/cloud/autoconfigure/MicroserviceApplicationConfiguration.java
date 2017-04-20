package io.cloudlib.spring.cloud.autoconfigure;


public class MicroserviceApplicationConfiguration {

//	@ConditionalOnExpression("'${spring.profiles.active:full-stack}' == 'local'")
//	@SpringBootApplication(exclude = { SleuthHystrixAutoConfiguration.class, SleuthStreamAutoConfiguration.class,
//			EurekaClientAutoConfiguration.class, MicroserviceApplicationConfiguration.class })
//	@EnableSwagger2
//	static class LocalConfiguration {
//	}
//
//	@ConditionalOnExpression("'${spring.profiles.active:full-stack}'.contains('full-stack')")
//	@SpringBootApplication(exclude = MicroserviceApplicationConfiguration.class)
//	@EnableSwagger2
//	@EnableDiscoveryClient
//	static class FullStackConfiguration {
//	}
//
//	@ConditionalOnExpression("'${spring.profiles.active:full-stack}' == 'test'")
//	@SpringBootApplication(exclude = { SleuthHystrixAutoConfiguration.class, SleuthStreamAutoConfiguration.class,
//			EurekaClientAutoConfiguration.class, MicroserviceApplicationConfiguration.class })
//	static class TestConfiguration {
//	}
}