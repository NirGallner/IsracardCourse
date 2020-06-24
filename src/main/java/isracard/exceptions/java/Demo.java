package isracard.exceptions.java;

import isracard.exceptions.java.MyEnumClass.Level;

public class Demo {

	public static void main(String[] args) throws IsracardException {

		ExceptionTests et = new ExceptionTests();
		StringBuilder myString = new StringBuilder();
		myString.append("nir");
		myString.append(3);
		myString.append(3.5);
		myString.append(et);

		Level l = Level.HIGH;
		System.out.println("are they equal?: " + "HIGH".equalsIgnoreCase(l.toString()));
		// System.out.println(myString.toString());

		et.tryMe();

		et.tryMeRoot();

		et.tryMeError();

	}

}
