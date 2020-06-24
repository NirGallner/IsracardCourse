package isracard.exceptions.java;


public class IsracardRootCauseException extends RuntimeException{
	public IsracardRootCauseException(String errMsg, Throwable th) {
		super(errMsg, th);
	}
	
	public IsracardRootCauseException(String errMsg) {
		super(errMsg);
	}
}
