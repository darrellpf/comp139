public class Driver {

	public static void main(String[] args) {

		Patient[] testPatients = {
				new Patient("Grumpy", "Dwarf", "headache", 100),
				new Patient("Snow", "White", "narcolepsy", 200),
				new Patient("Sneezy", "Dwarf", "head cold", 150),
				new Patient("Bashful", "Dwarf", "anxiety", 125),
				};

		PatientPool allPatients = new PatientPool();

		for (Patient who : testPatients) {
			allPatients.add(who);
		}

		while (allPatients.size() > 0) {
			Patient who = allPatients.nextPatient();
			System.out.println(who);
		}
	}

}
