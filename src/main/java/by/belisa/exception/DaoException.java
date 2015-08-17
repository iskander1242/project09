package by.belisa.exception;

public class DaoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4497851139100073227L;
	private String message;
	private Object[] params;
	private DaoErrorCode daoErrorCode;
	
	public DaoException(Exception e){
		super(e);
	}
	
	public DaoException(Exception e, DaoErrorCode code, Object...params ){
		super(e);
		this.message = String.format(code.toString(), params);
		this.daoErrorCode = code;
		this.params = params;		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public DaoErrorCode getDaoErrorCode() {
		return daoErrorCode;
	}

	public void setDaoErrorCode(DaoErrorCode daoErrorCode) {
		this.daoErrorCode = daoErrorCode;
	}
	
	

}
