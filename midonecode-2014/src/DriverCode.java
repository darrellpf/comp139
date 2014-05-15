
public class DriverCode {

	public static void main(String[] args) {
		LinkedList<Worker> aList = new LinkedList<Worker>();
		
		
		aList.add(new Worker("a", "a"));
		
		aList.mirror();
		
		aList = new LinkedList<Worker>();
				
		aList.add(new Worker("d", "d"));
		aList.add(new Worker("c", "c"));
		aList.add(new Worker("b", "b"));
		aList.add(new Worker("a", "a"));
		
		aList.mirror();
		
		for(int i = 0; i < aList.size(); i++) {
			System.out.println(aList.get(i));
		}
	}

}
