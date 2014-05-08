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

	
		int position = huntForBeerInForest(0);
		System.out.println("Found beer at " + position );	
		}
	

	public static int huntForBeerInForest(int position) {
		
		
		if(allClearings[position].getHasBeer() == true) {
			System.out.println("Found beer at " + position );
			return position;
		}
		
		for(int aClearing : allClearings[position].getConnections()){
			System.out.println("checking at " + aClearing);

			int foundPosition = huntForBeerInForest(aClearing);
			if(foundPosition >= 0) {
				return foundPosition;
			}
			
			System.out.println("going back to " + position);			
		}
		
		return -1;
	}
	}
