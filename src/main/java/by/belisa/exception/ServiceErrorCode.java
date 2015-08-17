package by.belisa.exception;

public enum ServiceErrorCode {
	ERR_SRVC_000("Failed to add item %s."),
	ERR_SRVC_001("Failed to update item %s."),
	ERR_SRVC_002("Failed to get item %s, id=%d."),
	ERR_SRVC_003("Failed to get item %s by name=%s"),
	ERR_SRVC_004("Failed to delete item %s"),
	ERR_SRVC_005("Failed to get list %s");

	private final String value;

	private ServiceErrorCode(String s) {
		value = s;
	}

	public boolean equalsValue(String value2) {
		return (value2 != null) && value.equals(value2);
	}

	public String toString() {
		return value;
	}
}
