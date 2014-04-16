import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DogDriverEquals {
	
	private static final int MAX_ITEMS = 500000;

	public static void main(String[] args) {
		
		List<Dog> allDogs = new ArrayList<>();
		
		System.out.println("Starting");
		
		for(int i = 0; i < MAX_ITEMS; i++) {
			Dog aDog = new Dog("Sam" + i, 10);
			allDogs.add(aDog);
		}
		
		Collections.shuffle(allDogs);
		
		System.out.println("Done adding");
		
		int position = allDogs.indexOf(new Dog("Sam" + 57, 0));
		Dog foundDog = allDogs.get(position);
		
		System.out.println("Found dog is " + foundDog.getName() + " " + foundDog.getBarks());
		System.out.println("Maxitems is " + MAX_ITEMS + " " + " Counter is " + Dog.getEqualsCalled());
		
		System.out.println("Ending");
	}

}
