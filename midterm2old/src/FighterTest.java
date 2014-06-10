import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class FighterTest {
	
	Fighter [] originalFighters = {
			new Fighter("Liddell",	"Iceman",		20,	8 ),	// 0
			new Fighter("Bonnar",	"Psycho",		18,	5 ),	// 1
			new Fighter("Guida",	"Carpenter",	6,	9 ),	// 2
			new Fighter("Bader",	"Darth",		6,	12),	// 3
			new Fighter("Pulver",	"Evil",			7,	18),	// 4
		};

	@Test
	public void partA() {

		System.out.println("Part A");
		
		List<Fighter> aList = new ArrayList<Fighter>(Arrays.asList(originalFighters));
		
		aList.remove(new Fighter("Bonnar", "Darth", 7, 5));
		
		for(Fighter who : aList) {
			System.out.println(who.getAlias());
		}
	}
	
	@Test
	public void partB() {
		
		System.out.println("Part B");
		
		List<Fighter> sorter = new ArrayList<Fighter>(Arrays.asList(originalFighters));
		
		sorter.remove(Collections.max(sorter));
		
		for(Fighter who : sorter) {
			System.out.println(who.getName() + " " + who.getWins());
		}
	}
	
	@Test
	public void partC() {
		
		System.out.println("Part C");

		List<Fighter> bouts = new LinkedList<Fighter>();
		
		Iterator<Fighter> boutIter = bouts.iterator();
		while(boutIter.hasNext()) {
			Fighter aPug = boutIter.next();
			if(aPug.getLosses() < 10) {
				continue;
			}
			
			boutIter.remove();
		}
		
		for(Fighter who : bouts) {
			System.out.println(who.getName() + who.getWins());
		}
	}
	
	@Test
	public void partD() {
		
		System.out.println("Part D");
		
		Set<Fighter> aSet = new TreeSet<Fighter>(new Comparator<Fighter>() {
			public int compare(Fighter a, Fighter b) {
				String aName = a.getName();
				String bName = b.getName();
				return aName.compareTo(bName);
			}
		});
		
		for(Fighter who : originalFighters) {
			aSet.add(who);
		}
		
		// *** See Question 2
		
		aSet.remove(new Fighter("Pulver", "Psycho", 4, 10));		
		aSet.add(new Fighter("Bader", "Hippo", 10, 16));
		
		for(Fighter who : aSet) {
			System.out.println(who);
		}
	}
	
	@Test
	public void partE() {
		
		System.out.println("Part E");
		
		Map<String, Fighter> aMap = new HashMap<String, Fighter>();
		
		aMap.put("Fighter", originalFighters[2]);
		aMap.put("Fighter", originalFighters[3]);
		aMap.put("Dad", new Fighter("Bader", "Darth", 4, 6));
		
		for(Fighter who : aMap.values()) {
			System.out.println(who);
		}
	}
	
	@Test
	public void partF() {
		
		System.out.println("Part F");
		
		Map<Fighter, Fighter> aMap = new HashMap<Fighter, Fighter>();
		
		for(Fighter who : originalFighters) {
			aMap.put(who, who);
		}
		
		Fighter reTwit = new Fighter("Guida", "Evil", 30, 10);
		aMap.put(reTwit, reTwit);
		
		for(Entry<Fighter, Fighter> who : aMap.entrySet()) {
			System.out.println(who.getKey().getName() + " " +
					who.getValue().getWins());
		}
	}
	
	@Test
	public void partG() {
		
		System.out.println("Part G");
		
		Set<Fighter> people = new TreeSet<Fighter>();
		people.addAll(Arrays.asList(originalFighters));
		
		people.add(new Fighter("Guida", "Psycho", 6, 4));
		people.add(new Fighter("Carwin", "Engineer", 345, 5));
		people.add(new Fighter("Bader", "Carpenter", 4, 6));
		
		for(Fighter who : people) {
			System.out.println(who);
		}
	}
}
