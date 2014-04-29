package forest;

import java.util.Stack;

public class ForestMain {

	static Clearing[] allClearings = { new Clearing(0, new int[] { 1, 2, 3 }),
			new Clearing(1, new int[] { 4, 5, 6 }),
			new Clearing(2, new int[] { 7 }),
			new Clearing(3, new int[] { 8, 9 }), new Clearing(4, new int[] {}),
			new Clearing(5, new int[] { 10 }),
			new Clearing(6, new int[] { 11 }), new Clearing(7, new int[] {}),
			new Clearing(8, new int[] {}), new Clearing(9, new int[] {}),
			new Clearing(10, new int[] {}), new Clearing(11, new int[] {}), };

	public static void main(String[] args) {

		allClearings[11].setHasBeer(true);

		Stack<Clearing> toDo = new Stack<>();
		toDo.push(allClearings[0]);

		while (toDo.size() > 0) {
			Clearing current = toDo.peek();
			if(current.isChecked() == true) {
				toDo.pop();
				printGoingBackTo(toDo);
				continue;
			}
			
			current.checked(true);
			
			System.out.println("Current: " + current);
			
			if (current.getHasBeer() == true) {
				System.out.println("Found beer at clearing " + current);
				break;
			}

			pushAllConnectingPaths(current, toDo, allClearings);
		}
		
		printPathToBeer(toDo);
	}
	
	private static void printPathToBeer(Stack<Clearing> toDo) {
		System.out.println("Path to beer ");
		
		for(Clearing aClearing : toDo) {
			if(aClearing.isChecked() == true) {
				System.out.println(aClearing + " ");
			}
		}
	}
	
	private static void printGoingBackTo(Stack<Clearing> toDo) {
		Stack<Clearing> saved = new Stack<>();
		
		Clearing current = null;
		
		while(toDo.size() > 0) {
			current = toDo.pop();
			saved.push(current);
			
			if(current.isChecked() == true) {
				System.out.println("Going back to " + current);
				break;
			}
		}
		
		while(saved.size() > 0) {
			Clearing temp = saved.pop();
			toDo.push(temp);
		}
	}

	private static void pushAllConnectingPaths(Clearing current, Stack<Clearing> toDo, Clearing[] allClearings) {
		int [] connections = current.getConnections();
		
		for(int aConnection : connections) {
			toDo.push(allClearings[aConnection]);
		}
	}

}
