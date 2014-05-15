
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LinkedListTest {
	
	LinkedList<Worker> aList;
	
	Worker a;
	Worker b;
	Worker c;
	Worker d;

	@Before
	public void setUp() throws Exception {
		aList = new LinkedList<Worker>();
		
		a = new Worker("a", "a");
		b = new Worker("b", "b");
		c = new Worker("c", "c");
		d = new Worker("d", "d");
	}
	
	@Test
	public void emptyList() {
		LinkedList<Worker> aList = new LinkedList<>();
		
		aList.mirror();
		assertTrue(aList.size() == 0);
	}
	
	@Test
	public void oneList() {
		LinkedList<Worker> aList = new LinkedList<>();
		
		aList.add(a);
		
		aList.mirror();
		assertTrue(aList.size() == 2);
		
		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == a);
	}
	
	@Test
	public void twoList() {
		LinkedList<Worker> aList = new LinkedList<>();
		
		aList.add(b);
		aList.add(a);
		
		aList.mirror();
		assertTrue(aList.size() == 4);
		
		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == b);
		assertTrue(aList.get(3) == a);
	}
	
	@Test
	public void threeList() {
		LinkedList<Worker> aList = new LinkedList<>();
		
		aList.add(c);
		aList.add(b);
		aList.add(a);
		
		aList.mirror();
		assertTrue(aList.size() == 6);
		
		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == c);
		assertTrue(aList.get(3) == c);
		assertTrue(aList.get(4) == b);
		assertTrue(aList.get(5) == a);
	}
	
	@Test
	public void fourList() {
		LinkedList<Worker> aList = new LinkedList<>();
		
		aList.add(d);
		aList.add(c);
		aList.add(b);
		aList.add(a);
		
		aList.mirror();
		assertTrue(aList.size() == 8);
		
		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == c);
		assertTrue(aList.get(3) == d);
		assertTrue(aList.get(4) == d);
		assertTrue(aList.get(5) == c);
		assertTrue(aList.get(6) == b);
		assertTrue(aList.get(7) == a);
	}
}
