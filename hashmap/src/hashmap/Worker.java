package hashmap;

public class Worker {
	private String firstName;
	private int sin;

	public Worker(String inFirstName, int inSIN) {
		firstName = inFirstName;
		sin = inSIN;
	}
	
	@Override
	public int hashCode() {
		return sin;
	}
	
	@Override
	public boolean equals(Object what) {
		Worker other = (Worker) what;
		
		return sin == other.sin;
	}


	public String getFirstName() {
		return firstName;
	}

}
