package by.belisa.exception;

public enum DaoErrorCode {
	ERR_DAO_000("Cannot get %s by id=%s"),
	ERR_DAO_001("Cannot get %s by name=%s"),
    ERR_DAO_002("Cannot get list of <%s>"),
    ERR_DAO_003("Cannot create object %s"),
    ERR_DAO_004("Cannot update object %s"),
    ERR_DAO_005("Cannot delete object %s"),
    ERR_DAO_006("Cannot create criteria for type %s"),
    ERR_DAO_007("Cannot create hql: %s");
	
	private DaoErrorCode(String msg){
		this.value = msg;
	}
	private String value;
	@Override
	public String toString() {
		return this.value;
	}
	
}
