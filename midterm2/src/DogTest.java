import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class DogTest {
	
	Dog [] dogsA = {
			new Dog("Rex",	"Poodle",	20,	8 ),	// 0
			new Dog("Tail",	"Spaniel",	10,	5 ),	// 1
			new Dog("Fido",	"Boxer",	18,	9 ),	// 2
			};
	
	Dog [] dogsB = {
			new Dog("Sam",	"Spaniel",	6,	12),	// 0
			new Dog("Fido",	"Rottie",	7,	18),	// 1
			};

	@Test
	public void partA() {

		System.out.println("Part A");
		
		List<Dog> aList = new ArrayList<Dog>(Arrays.asList(dogsA));
		
		aList.add(new Dog("Tail", "Mixed", 7, 5));
		aList.remove(new Dog("", "Boxer", 0, 0));
		
		for(Dog who : aList) {
			System.out.println(who.getBreed());
		}
	}
	
	@Test
	public void partB() {
		
		System.out.println("Part B");
		
		Queue<Dog> dek = new ArrayDeque<Dog>(Arrays.asList(dogsA));
		dek.add(new Dog("Snoop", "Lion", 2, 1));
		
		while(dek.size() > 0 ){
			Dog who = dek.remove();
			System.out.println(who.getName() + " " + who.getWeight());
		}
	}
	
	@Test
	public void partC() {
		
		System.out.println("Part C");

		Set<Dog> bouts = new TreeSet<Dog>(Arrays.asList(dogsA));
		bouts.removeAll(Arrays.asList(dogsB));
		
		for(Dog who : bouts) {
			System.out.println(who.getName() + " " + who.getWeight());
		}
	}
	
	@Test
	public void partD() {
		
		System.out.println("Part D");
		
		Set<Dog> aSet = new LinkedHashSet<Dog>(Arrays.asList(dogsB));
		aSet.addAll(Arrays.asList(dogsA));
		
		for(Dog who : dogsA) {
			System.out.println(who);
		}
	}
	
	@Test
	public void partE() {
		
		System.out.println("Part E");
		
		Map<String, Dog> aMap = new HashMap<String, Dog>();
		
		for(Dog aDog : dogsA) {
			aMap.put(aDog.getName(), aDog);
		}
		
		for(Dog aDog : dogsB) {
			aMap.put(aDog.getName(), aDog);
		}
		
		for(Dog who : aMap.values()) {
			System.out.println(who);
		}
	}
	
	@Test
	public void partF() {
		
		System.out.println("Part F");
		
		Map<Dog, Dog> aMap = new HashMap<Dog, Dog>();
		
		for(Dog who : dogsA) {
			aMap.put(who, who);
		}
		
		Dog reDog = new Dog("Fido", "Boxer", 30, 10);
		aMap.put(reDog, reDog);
		
		for(Entry<Dog, Dog> who : aMap.entrySet()) {
			System.out.println(who.getKey().getName() + " " +
					who.getValue().getWeight());
		}
	}
	
	@Test
	public void partG() {
		
		System.out.println("Part G");
		
		PriorityQueue<Dog> kennel = new PriorityQueue<Dog>();
		kennel.addAll(Arrays.asList(dogsA));
		
		kennel.add(new Dog("Sam", "Poodle", 6, 4));
		kennel.add(new Dog("Tail", "Terrier", 345, 5));
		kennel.add(new Dog("Biter", "Spaniel", 4, 6));
		
		for(int i = 0; i < 3; i++) {
			Dog who = kennel.remove();
			System.out.println(who);
		}
	}
}
