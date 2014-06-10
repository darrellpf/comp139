package heap;
import java.util.Comparator;

public class Patient implements Comparable<Patient> {
	private String firstName;
	private String lastName;
	private String complaint;
	private int priority;

	public Patient(String inFirstName, String inLastName, String inComplaint,
			int inPriority) {
		firstName = inFirstName;
		lastName = inLastName;
		complaint = inComplaint;
		priority = inPriority;
	}

	public int compareTo(Patient other) {
		return priority - other.priority;
	}

	public static Comparator<Patient> byLastName() {
		return new Comparator<Patient>() {
			public int compare(Patient a, Patient b) {
				int comp = a.lastName.compareTo(b.lastName);
				if (comp != 0) {
					return comp;
				}

				return a.firstName.compareTo(b.firstName);
			}
		};
	}

	@Override
	public String toString() {
		return " firstname: " + firstName + " lastname: " + lastName
				+ " complaint: " + complaint + " priority: " + priority;
	}

}
