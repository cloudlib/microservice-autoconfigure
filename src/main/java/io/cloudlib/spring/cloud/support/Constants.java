package io.cloudlib.spring.cloud.support;

public final class Constants {

	public static final class EventConstants {
		public static final String EVENT_TYPE_KEY = "EVENT_TYPE";
		public static final String AUDIT_EVENT = "AUDIT_EVENT";
		public static final String BUSINESS_EVENT = "BUSINESS_EVENT";
	}

	public static final class AuditParamConstants {
		public static final String INVOKED_CLASS = "INVOKED_CLASS";
		public static final String INVOKED_METHOD = "INVOKED_METHOD";
		public static final String ARGS = "INVOKED_ARGS";
	}

	public static final class BusinessParamConstants {
		public static final String RESOURCE = "RESOURCE";
		public static final String OPERATION = "OPERATION";
	}

	private Constants() {
	}
}
