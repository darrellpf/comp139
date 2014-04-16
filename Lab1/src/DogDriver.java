import java.util.ArrayList;
import java.util.List;


public class DogDriver {
	private static final int MAX_ITEMS = 500000;
	
	public static void main(String[] args) {
		Dog aDog = new Dog("Sam", 10);
		
		List<Dog> allDogs = new ArrayList<>();
		
		System.out.println("Starting");
		
		for(int i = 0; i < MAX_ITEMS; i++) {
			allDogs.add(aDog);
		}
		
		System.out.println("Done adding");
		
/*		for(int i = 0; i < allDogs.size(); i++) {
			allDogs.remove(0);
		}*/
		
		removeFromEnd(allDogs);
		
		System.out.println("Ending with size: " + allDogs.size());
	}
	
	private static void removeFromEnd(List<Dog> allItems) {
		int endPosition = allItems.size() - 1;
		
		for(int i = 0; i < allItems.size(); i++) {
			allItems.remove(endPosition);
			endPosition--;
		}
	}

}
