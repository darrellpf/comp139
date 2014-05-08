
public class TreeDriver {

	public static void main(String[] args) {
		Tree<Worker> workers = new Tree<>();
		
		Worker m = new Worker("m", "m");
		
		workers.add(m);
		
		workers.add(new Worker("f", "f"));
		
		workers.add(new Worker("s", "s"));
		
		workers.add(new Worker("c", "c"));
		
		System.out.println();
	}

}
