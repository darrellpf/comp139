package hashmap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HashTableTest {
	
	Worker a;
	Worker b;
	Worker c;
	
	Worker lastDigitA;
	
	HashTable<Worker, Worker> table;

	@Before
	public void setUp() throws Exception {
		a = new Worker("aaa", 123);
		b = new Worker("bbb", 345);
		c = new Worker("ccc", 567);
		
		lastDigitA = new Worker("notaaa", 103);
		
		table = new HashTable<>();
	}

	@Test
	public void addFind() {
		table.add(a, a);
		
		Worker who = table.find(new Worker("", 123));
		
		assertTrue(who == a);
		
		who = table.find(b);
		assertTrue(who == null);
	}
	
	@Test
	public void findSameSlot() {
		Worker firstPlaced = new Worker("a", 555);
		table.add(firstPlaced, firstPlaced);
		
		Worker secondPlaced = new Worker("b", 995);
		table.add(secondPlaced, secondPlaced);
		
		Worker found995 = table.find(new Worker("", 995));
		
		assertTrue(found995 == secondPlaced);
		
		Worker found555 = table.find(new Worker("", 555));
		
		assertTrue(found555 == firstPlaced);	
	}
	
	@Test
	public void replaceDuplicate() {
		Worker firstPlaced = new Worker("a", 555);
		table.add(firstPlaced, firstPlaced);
		
		Worker secondPlaced = new Worker("b", 555);
		table.add(secondPlaced, secondPlaced);	
		
		Worker foundSecond = table.find(new Worker("", 555));
		
		assertTrue(foundSecond == secondPlaced);
		
		table.remove(new Worker("", 555));
		assertTrue(table.find(new Worker("", 555)) == null);
	}
	
	public void remove() {
		Worker firstPlaced = new Worker("a", 555);
		table.add(firstPlaced, firstPlaced);
		
		Worker secondPlaced = new Worker("b", 666);
		table.add(secondPlaced, secondPlaced);	
		
		table.remove(new Worker("", 555));
		
		Worker foundSecond = table.find(new Worker("", 555));
		
		assertTrue(foundSecond == null);
		
		assertTrue(table.find(new Worker("", 666)) == secondPlaced);
	}
	
	@Test
	public void worksOnStrings() {
		HashTable<String, String> table = new HashTable<>();
		
		table.add("robin", "worm eating bird");
		table.add("sparrow", "seed eating bird");
		table.add("roc", "man eating creature");
		
		String phrase = table.find("sparrow");
		
		assertTrue(phrase.equals("seed eating bird"));
		
		phrase = table.find("nothing");
		assertTrue(phrase == null);		
	}
	
	@Test
	public void containsValue() {
		HashTable<String, String> table = new HashTable<>();
		
		table.add("robin", "worm eating bird");
		table.add("sparrow", "seed eating bird");
		table.add("roc", "man eating creature");
		
		assertTrue(table.containsValue("worm eating bird") == true);
		assertTrue(table.containsValue("seed eating bird") == true);
		assertTrue(table.containsValue("man eating creature") == true);
		
		assertTrue(table.containsValue("stuff not here") == false);
		
	}

}
