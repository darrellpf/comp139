package forest;

import java.util.Stack;

public class ForestMain {
	
	static Clearing [] allClearings = {
			new Clearing(0, new int [] {1, 2, 3}),
			new Clearing(1, new int [] {4, 5, 6}),
			new Clearing(2, new int [] {7}),
			new Clearing(3, new int [] {8, 9}),
			new Clearing(4, new int [] {}),
			new Clearing(5, new int [] {10}),
			new Clearing(6, new int [] {11}),
			new Clearing(7, new int [] {}),
			new Clearing(8, new int [] {}),
			new Clearing(9, new int [] {}),
			new Clearing(10, new int [] {}),
			new Clearing(11, new int [] {}),
	};

	public static void main(String[] args) {
		
		allClearings[11].setHasBeer(true);
		
		Stack<Clearing> toDo = new Stack<>();
		toDo.push(allClearings[0]);

	}

}
