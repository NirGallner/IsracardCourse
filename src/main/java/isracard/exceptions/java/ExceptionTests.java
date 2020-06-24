package isracard.exceptions.java;

public class ExceptionTests {

	public ExceptionTests() {
		// throw new IsracardException("can throw also in the constructor");
	}

	public void tryMe() throws IsracardException {
		throw new IsracardException("This is Isracard Exception");

	}

	public void tryMeRoot() {
		try {
			int x = 3 / 0;
		} catch (Exception e) {
			throw new IsracardRootCauseException("non checked exception", e);
		}

	}

	public void tryMeError() {
		throw new IsracardError("Error of Isracard");
	}

	@Override
	public String toString() {
		return "this is my ExceptionTests Demo";
	}

}
