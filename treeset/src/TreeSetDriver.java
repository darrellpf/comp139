import java.util.*;

public class TreeSetDriver {
	Student[] allStudents =
		{
			new Student("King",		"Don",		65),
			new Student("Johnson",	"Margaret",	23),
			new Student("Student",	"Joe",		20),
			new Student("Jones",	"Sam",		43),
			new Student("Vanity",	"Fair",		21),
			new Student("Lambert",	"Ken",		32),
			new Student("Anderson",	"Fred",		22),
			new Student("Osborne",	"Martin",	24),
			new Student("Platypus",	"Duck",		33),
			new Student("Cook",		"Captain",	81),
			new Student("Rainer",	"Prince",	38),
			new Student("Quincy",	"Susan", 	24),
			};

	public TreeSetDriver() {
		// Make a new tree set to hold the students in sorted order.
		// Sets cannot contain duplicates

		Set<Student> theClass = new TreeSet<>();

		// Add all the students into the tree.
		// The tree's add method will call the Student's compareTo to place
		// the students into the tree.

		for (Student who : allStudents) {
			theClass.add(who);
		}

		// Try printing out all the students in the tree. They should appear
		// sorted by last name (since that's the ordering imposed by the
		// student's compareTo method)

		System.out.println("The sorted list of students is");

		for (Student who : allStudents) {
			System.out.println(who);
		}

		// Rather than adding the students to a set one at a time,
		// try adding the entire array. You can make a collection directly
		// from another collection, but an array isn't an official collection.
		// Instead, we use the Arrays class to turn the array of students into
		// a list of students, then add the list of students to the tree set.
		// Remove doesn't work on this set.

		Set<Student> arrayFromSet = new TreeSet<>(Arrays.asList(allStudents));

		// Make some slightly different test sets

		Set<Student> comp139 = new TreeSet<>(theClass);
		comp139.remove(allStudents[3]);
		comp139.remove(allStudents[5]);
		comp139.remove(allStudents[1]);
		System.out.println("Comp139 students " + comp139);

		Set<Student> comp182 = new TreeSet<>(theClass);
		comp182.remove(allStudents[2]);
		comp182.remove(allStudents[6]);
		comp182.remove(allStudents[1]);
		System.out.println("Comp182 students " + comp182);

		// Find the union of all the students

		Set<Student> union = new TreeSet<Student>(comp139);
		union.addAll(comp182);

		System.out.println("All students combined from 139 and 182 " + union);

		// Find the intersection students in the two classes

		Set<Student> intersection = new TreeSet<>(comp139);
		intersection.retainAll(comp182);

		System.out.println(
			"Students in both 139 and 182 (intersection) " + intersection);

		// Find students who are in once class but not the other

		Set<Student> difference = new TreeSet<>(comp182);
		difference.removeAll(comp139);

		System.out.println(
			"Students in comp 182 who are not in comp 139 too " + difference);

		// If you even need to get the items back into an array (usually to pass
		// to a method that insists on an array), you can retrieve the references
		// into an array

		Object[] someStudent;

		someStudent = difference.toArray();

		System.out.println("The first student of that group is " + someStudent[0]);
	}

	public static void main(String[] args) {
		new TreeSetDriver();
	}
}