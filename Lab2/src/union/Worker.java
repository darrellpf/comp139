package union;

public class Worker {
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
	public boolean equals(Object what) {
		Worker other = (Worker) what;
		
		return firstName.equals(other.firstName);
	}
}
