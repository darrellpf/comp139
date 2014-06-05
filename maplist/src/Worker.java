

public class Worker {
	private String firstName;
	private int age;

	public Worker(String inFirstName, int inAge) {
		firstName = inFirstName;
		age = inAge;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public int hashCode() {
		return age;
	}
	
	@Override
	public boolean equals(Object what) {
		Worker other = (Worker) what;
		
		return firstName.equals(other.firstName);
	}


	public String getFirstName() {
		return firstName;
	}

}
