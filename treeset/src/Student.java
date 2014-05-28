public class Student implements Comparable<Student> {
	private String lastName;
	private String firstName;
	private int age;

	public Student(String inLastName, String inFirstName, int inAge) {
		lastName = inLastName;
		firstName = inFirstName;
		age = inAge;
	}

	@Override
	public int compareTo(Student who) {

		int comparison = lastName.compareTo(who.lastName);

		if (comparison != 0) {
			return comparison;
		}

		comparison = firstName.compareTo(who.firstName);

		return comparison;
	}

	@Override
	public String toString() {
		return lastName + ", " + firstName + " " + age;
	}
}