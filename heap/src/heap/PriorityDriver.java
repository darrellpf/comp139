package heap;

public class PriorityDriver {

	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueueImpl<>();

		q.add(45);
		q.add(12);
		q.add(10);
		q.add(18);
		
		System.out.println("Items in queue");
		
		for(Integer anInt : q) {
			System.out.print(anInt + " ");
		}

		System.out.println();
		System.out.println("Items retrieved from queue");
		
		while(q.size() > 0)  {
			int anInt = q.remove();
			System.out.print(anInt + " ");			
		}

		System.out.println();
	}

}
