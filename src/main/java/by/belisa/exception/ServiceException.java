package by.belisa.exception;

public class ServiceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1594683401091405418L;

	private ServiceErrorCode code;

	private Object[] params;

	private String message;

	private DaoException daoException;

	public ServiceException() {
		super();
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
		this.message = message;
	}

	public ServiceException(ServiceErrorCode code, Object... params) {
		super();
		init(code, params);
	}

	public ServiceException(DaoException e, ServiceErrorCode code,
			Object... params) {
		super(e);
		this.daoException = e;
		init(code, params);
	}

	private void init(ServiceErrorCode code, Object... params) {
		this.code = code;
		this.params = params;
		this.message = String.format(code.toString(), params);
	}

	public ServiceErrorCode getCode() {
		return code;
	}

	public void setCode(ServiceErrorCode code) {
		this.code = code;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DaoException getDaoException() {
		return daoException;
	}

	public void setDaoException(DaoException daoException) {
		this.daoException = daoException;
	}

}
