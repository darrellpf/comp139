package arrays;

public class ArraysDriver {

	public static void main(String[] args) {
		
		int [] marks;
		marks = new int[20];
		System.out.println(marks.length);
		
		int nextFreeSlot = 0;
		
		marks[nextFreeSlot] = 56;
		nextFreeSlot++;
		
		marks[nextFreeSlot] = 34;
		nextFreeSlot++;
		
		
		Student [] allStudents;
		allStudents = new Student[20];
		Student fred = new Student("Fred", "Flint", 23);
		allStudents[0] = fred;
		fred = null;
		System.out.println(allStudents[0].getFirstName());
	}

}
