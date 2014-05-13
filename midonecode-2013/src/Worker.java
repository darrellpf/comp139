

public class Worker {

	private String name;
	private String jobTitle;

	public Worker(String aName, String aTitle) {
		name = aName;
		jobTitle = aTitle;
	}

	public void setTitle(String newTitle) {
		jobTitle = newTitle;
	}

	@Override
	public String toString() {
		return name + " : " + jobTitle;
	}
}