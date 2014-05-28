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

	@Override
	public int compareTo(Patient who) {
		return priority - who.priority;
	}

	@Override
	public String toString() {
		return " firstname: " + firstName + " lastname: " + lastName
				+ " complaint: " + complaint + " priority: " + priority;
	}

}
