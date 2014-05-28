import java.util.*;

public class PatientPool implements Iterable<Patient> {
	private PriorityQueue<Patient> allPatients;

	public PatientPool() {
		allPatients = new PriorityQueue<Patient>();
	}

	public void add(Patient who) {
		allPatients.add(who);
	}

	public Patient nextPatient() {
		return allPatients.remove();
	}

	public int size() {
		return allPatients.size();
	}

	public Iterator<Patient> iterator() {
		return allPatients.iterator();
	}

}
