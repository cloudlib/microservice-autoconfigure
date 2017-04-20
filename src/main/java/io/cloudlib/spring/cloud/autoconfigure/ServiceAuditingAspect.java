package io.cloudlib.spring.cloud.autoconfigure;

import static io.cloudlib.spring.cloud.support.Constants.AuditParamConstants.ARGS;
import static io.cloudlib.spring.cloud.support.Constants.AuditParamConstants.INVOKED_CLASS;
import static io.cloudlib.spring.cloud.support.Constants.AuditParamConstants.INVOKED_METHOD;
import static io.cloudlib.spring.cloud.support.Constants.EventConstants.AUDIT_EVENT;
import static io.cloudlib.spring.cloud.support.Constants.EventConstants.EVENT_TYPE_KEY;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnProperty("microservice.auditing.services")
public class ServiceAuditingAspect {

	private final Tracer tracer;

	@Autowired
	public ServiceAuditingAspect(Tracer tracer) {
		this.tracer = tracer;
	}

	@Pointcut("within(@org.springframework.stereotype.Service *)")
	public void decorateServices() {
	}

	@Before("decorateServices()")
	public void decorate(JoinPoint jp) {
		Map<String, String> tags = params(jp);
		Span span = tracer.createSpan(AUDIT_EVENT);
		try {
			for (Entry<String, String> tag : tags.entrySet()) {
				tracer.addTag(tag.getKey(), tag.getValue());
			}
			tags.put(EVENT_TYPE_KEY, AUDIT_EVENT);
		} finally {
			tracer.close(span);
		}
	}

	private Map<String, String> params(JoinPoint jp) {
		Map<String, String> tags = new HashMap<>();
		tags.put(INVOKED_CLASS, jp.getSignature().getDeclaringTypeName());
		tags.put(INVOKED_METHOD, jp.getSignature().getName());
		tags.put(ARGS, Arrays.toString(jp.getArgs()));
		return tags;
	}
}
