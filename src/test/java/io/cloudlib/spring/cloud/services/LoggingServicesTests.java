package io.cloudlib.spring.cloud.services;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoggingServicesTests {

	String json = "{\"@timestamp\":\"2016-07-29T11:30:11.475-05:00\",\"@version\":1,\"logger_name\":\"io.cloudlib.spring.cloud.autoconfigure.ServiceAuditingAspect\",\"thread_name\":\"http-nio-9992-exec-1\",\"level\":\"DEBUG\",\"level_value\":10000,\"HOSTNAME\":\"Adeels-MacBook-Air.local\",\"appname\":\"csl-aopdemo-billing-account\",\"X-Span-Export\":\"true\",\"X-B3-SpanId\":\"c2fb17a837a8898f\",\"X-B3-TraceId\":\"138d43770d6809c3\"}";

	@Test
	public void test() throws JsonProcessingException, IOException {

		ObjectMapper m = new ObjectMapper();

		JsonNode nodes = m.readTree(json);

		System.out.println("==== " + nodes.findValue("HOSTNAME"));

		for (Iterator<Entry<String, JsonNode>> iter = nodes.fields(); iter.hasNext();) {
			Entry<String, JsonNode> node = iter.next();
			System.out.println(node.getKey() + " = " + node.getValue());
		}

	}

}
