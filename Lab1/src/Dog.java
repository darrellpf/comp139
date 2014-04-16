
public class Dog {
	private String name;
	private int barks;
	
	private static int equalsCalled = 0;
	
	public Dog(String inName, int inBarks) {
		name = inName;
		barks = inBarks;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBarks() {
		return barks;
	}
	
	public boolean equals(Object what) {
		Dog other = (Dog) what;
		equalsCalled++;
		return name.equals(other.name);
	}
	
	public static int getEqualsCalled() {
		return equalsCalled;
	}
}
