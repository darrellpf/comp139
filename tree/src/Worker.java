import java.util.Comparator;



public class Worker implements Comparable<Worker>{
	private String firstName;
	private String title;

	public Worker(String inFirstName, String inTitle) {
		firstName = inFirstName;
		title = inTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public int compareTo(Worker other) {
		return firstName.compareTo(other.firstName);
	}
	
	public Comparator<Worker> byTitle() {
		return new Comparator<Worker>() {
			public int compare(Worker a, Worker b) {
				return a.title.compareTo(b.title);
			}
		};
	}
}
