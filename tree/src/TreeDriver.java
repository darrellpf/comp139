
public class TreeDriver {

	public static void main(String[] args) {
		Tree<Worker> workers = new Tree<>();
		
		Worker m = new Worker("m", "m");
		
		workers.add(m);
		
		workers.add(new Worker("f", "f"));
		
		workers.add(new Worker("s", "s"));
		
		workers.add(new Worker("c", "c"));
		
		Worker foundWorker = workers.search(new Worker("c", "x"));
		
		System.out.println("found: " + foundWorker.getFirstName());
		
		System.out.println();
		System.out.println("Alphabetical order");
		System.out.println();

		for(Worker who : workers) {
			System.out.println(who.getFirstName());			
		}
		
		workers.forEach(null);
	}

}
