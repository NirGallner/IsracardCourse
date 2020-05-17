package isracard.exceptions.java;

public class EtiClass {
 public EtiClass(int age) throws EtiException {
	 if (age < 0) {
		 throw new EtiException("Age cannot be less then 0");
	 }
 }
}
