package rangeview;

public class Person {
	private String name;
	
	public Person(String inName) {
		name = inName;
	}
	
	public void setName(String inName) {
		name = inName;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
