
public class DriverCode {

	public static void main(String[] args) {
		LinkedList<Worker> aList = new LinkedList<Worker>();
		
		aList.duoDuplicate();
		
		aList.add(new Worker("a", "a"));
		
		aList.duoDuplicate();
		
		aList = new LinkedList<Worker>();
				
		aList.add(new Worker("c", "c"));
		aList.add(new Worker("b", "b"));
		aList.add(new Worker("a", "a"));
		
		aList.duoDuplicate();
	}

}
