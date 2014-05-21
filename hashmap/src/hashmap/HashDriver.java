package hashmap;

public class HashDriver {

	public static void main(String[] args) {
		HashTable<Worker, Worker> students = new HashTable<>();

		Worker fred = new Worker("Fred", 612852);
		students.add(fred, fred);
		
		students.find(new Worker("", 612852));
	}

}
