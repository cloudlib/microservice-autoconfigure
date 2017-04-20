package io.cloudlib.spring.cloud.services;

import static io.cloudlib.spring.cloud.support.Constants.BusinessParamConstants.OPERATION;
import static io.cloudlib.spring.cloud.support.Constants.BusinessParamConstants.RESOURCE;
import static io.cloudlib.spring.cloud.support.Constants.EventConstants.BUSINESS_EVENT;
import static io.cloudlib.spring.cloud.support.Constants.EventConstants.EVENT_TYPE_KEY;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.logstash.logback.marker.Markers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;

public abstract class BaseLoggingService {

	private static final Logger log = LoggerFactory.getLogger(BaseLoggingService.class);

	private final Tracer tracer;

	public BaseLoggingService(Tracer tracer) {
		this.tracer = tracer;
	}

	protected void logEvent(String message) {
		logEvent(message, new HashMap<String, String>());
	}

	protected void logEvent(Map<String, String> tags) {
		logEvent("", tags);
	}

	protected void logEvent(String message, Map<String, String> tags) {
		Span span = tracer.createSpan(BUSINESS_EVENT);
		try {
			tags.put(EVENT_TYPE_KEY, BUSINESS_EVENT);
			for (Entry<String, String> entry : tags.entrySet()) {
				tracer.addTag(entry.getKey(), entry.getValue());
			}
			log.debug(Markers.appendEntries(tags), message);
		} finally {
			tracer.close(span);
		}
	}

	public static class TagsBuilder {

		private String resource;
		private String operation;

		private Map<String, String> tags = new HashMap<String, String>();

		public TagsBuilder tag(String key, String value) {
			tags.put(key, value);
			return this;
		}

		public TagsBuilder resource(String name) {
			this.resource = name;
			return this;
		}

		public TagsBuilder operation(String name) {
			this.operation = name;
			return this;
		}

		public Map<String, String> build() {
			tags.put(RESOURCE, resource);
			tags.put(OPERATION, operation);
			return tags;
		}
	}

	public static TagsBuilder tags() {
		return new TagsBuilder();
	}
}