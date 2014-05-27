package duplicates;

public class Student {
	private String firstName;
	private int sin;
	private int classesCompleted;
	
	public Student(String inFirst, int inSin) {
		firstName = inFirst;
		sin = inSin;
		classesCompleted = 0;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public int hashCode() {
		return sin;
	}
	
	public boolean equals(Object what) {
		Student other = (Student) what;
		return sin == other.sin;
	}
	
	public void addToClassesCompleted(int howMany) {
		classesCompleted += howMany;
	}
	
	public int getSIN() {
		return sin;
	}
	
	public String toString() {
		return firstName + " " + sin + " " + classesCompleted;
	}
}
