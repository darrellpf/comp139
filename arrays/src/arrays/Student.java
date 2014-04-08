package arrays;
public class Student {

	private String firstName;
	private String lastName;
	private int age;

	public Student(String suppliedFirstName, String suppliedLastName,
			int suppliedAge) {
		firstName = suppliedFirstName;
		lastName = suppliedLastName;
		age = suppliedAge;
	}

	public Student(String suppliedFirstName, String suppliedLastName) {
		firstName = suppliedFirstName;
		lastName = suppliedLastName;
		age = 0;
	}

	public void setAge(int suppliedAge) {
		age = suppliedAge;
	}

	public int getAge() {
		return age;
	}

	public void setFirstName(String inFirst) {
		firstName = inFirst;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String inLast) {
		lastName = inLast;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		String result = "";

		result += firstName + " ";
		result += lastName + " ";
		result += age;

		return result;
	}
}
