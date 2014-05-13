
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
	public void dupEmpty() {
		aList.duoDuplicate();
		
		assertTrue(aList.size() == 0);
	}
	
	@Test
	public void dupOne() {
		aList.add(d);
		aList.duoDuplicate();
		
		assertTrue(aList.size() == 2);
		assertTrue(aList.get(0) == d);
		assertTrue(aList.get(1) == d);
	}
	
	@Test
	public void dupTwo() {
		aList.add(d);
		aList.add(c);
		aList.duoDuplicate();
		
		assertTrue(aList.size() == 4);
		assertTrue(aList.get(0) == c);
		assertTrue(aList.get(1) == c);
		assertTrue(aList.get(2) == d);
		assertTrue(aList.get(3) == d);
	}
	
	@Test
	public void dupThree() {
		aList.add(d);
		aList.add(c);
		aList.add(b);
		aList.duoDuplicate();
		
		assertTrue(aList.size() == 6);
		assertTrue(aList.get(0) == b);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == c);
		assertTrue(aList.get(3) == c);
		assertTrue(aList.get(4) == d);
		assertTrue(aList.get(5) == d);
	}
	
	@Test
	public void dupFour() {
		aList.add(d);
		aList.add(c);
		aList.add(b);
		aList.add(a);

		aList.duoDuplicate();
		
		assertTrue(aList.size() == 8);
		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == a);
		assertTrue(aList.get(2) == b);
		assertTrue(aList.get(3) == b);
		assertTrue(aList.get(4) == c);
		assertTrue(aList.get(5) == c);
		assertTrue(aList.get(6) == d);
		assertTrue(aList.get(7) == d);
	}
}
