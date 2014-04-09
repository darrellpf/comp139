package union;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MemberListTest {
	
	Worker a;
	Worker b;
	Worker c;
	Worker d;
	Worker e;
	
	MemberList union;
	
	MemberList unionFive;
	

	@Before
	public void setUp() throws Exception {
		a = new Worker("a", "a");
		b = new Worker("b", "b");
		c = new Worker("c", "c");
		d = new Worker("d", "d");
		e = new Worker("e", "e");
		
		union = new MemberList();
		unionFive = new MemberList();
		
		unionFive.add(a);
		unionFive.add(b);
		unionFive.add(c);
		unionFive.add(d);
		unionFive.add(e);
	}

	@Test
	public void intialized() {		
		assertTrue(union.size() == 0);
	}
	
	@Test
	public void addOne() {
		union.add(a);
		
		assertTrue(union.size() == 1);
		assertTrue(union.get(0) == a);
	}
	
	@Test
	public void addTwo() {
		union.add(a);
		union.add(b);
		
		assertTrue(union.size() == 2);
		assertTrue(union.get(0) == a);
		assertTrue(union.get(1) == b);
	}
	
	@Test
	public void removeSingle() {
		union.add(a);
		
		union.remove(0);
		assertTrue(union.size() == 0);
	}
	
	@Test
	public void removeDoubleFirst() {
		union.add(a);
		union.add(b);
		
		union.remove(0);
		assertTrue(union.size() == 1);
		assertTrue(union.get(0) == b);
	}
	
	@Test
	public void removeDoubleLast() {
		union.add(a);
		union.add(b);
		
		union.remove(1);
		assertTrue(union.size() == 1);
		assertTrue(union.get(0) == a);
	}
	
	@Test
	public void removeFirst() {
		assertTrue(unionFive.size() == 5);
		unionFive.remove(0);
		
		assertTrue(unionFive.size() == 4);
		
		assertTrue(unionFive.get(0) == b);
		assertTrue(unionFive.get(1) == c);
		assertTrue(unionFive.get(2) == d);
		assertTrue(unionFive.get(3) == e);		
	}
	
	@Test
	public void removeMiddle() {
		assertTrue(unionFive.size() == 5);
		unionFive.remove(2);
		
		assertTrue(unionFive.size() == 4);
		
		assertTrue(unionFive.get(0) == a);
		assertTrue(unionFive.get(1) == b);
		assertTrue(unionFive.get(2) == d);
		assertTrue(unionFive.get(3) == e);		
	}
	
	@Test
	public void removeEnd() {
		assertTrue(unionFive.size() == 5);
		unionFive.remove(4);
		
		assertTrue(unionFive.size() == 4);
		
		assertTrue(unionFive.get(0) == a);
		assertTrue(unionFive.get(1) == b);
		assertTrue(unionFive.get(2) == c);
		assertTrue(unionFive.get(3) == d);		
	}

}
