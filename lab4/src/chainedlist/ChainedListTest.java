package chainedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChainedListTest {
	
	Worker a;
	Worker b;
	Worker c;
	Worker d;
	Worker e;
	
	Worker looksLikeA;
	
	Worker x;
	Worker y;
	Worker z;
	
	ChainedList<Worker> aList;
	ChainedList<Worker> secondList;
	
	ChainedList<Worker> dupes;

	@Before
	public void setUp() throws Exception {
		
		a = new Worker("a", "Maintenance");
		b = new Worker("b", "Electrician");
		c = new Worker("c", "Electrician");
		d = new Worker("d", "Electrician");
		e = new Worker("e", "Electrician");
		
		looksLikeA = new Worker("a", "NoMatch");
		
		x = new Worker("x", "Electrician");
		y = new Worker("y", "Electrician");
		z = new Worker("z", "Electrician");
		
		aList = new ChainedList<Worker>();
		
		aList.add(a);
		aList.add(b);
		aList.add(c);
	}
	
	@Test
	public void initialSizeEmpty() {
		aList = new ChainedList<>();
		assertTrue(aList.size() == 0);
	}
	
	@Test
	public void addOneThenRetrieve() {
		aList = new ChainedList<>();
		aList.add(a);
		
		Worker who = (Worker) aList.get(0);
		assertTrue(who == a);
		assertTrue(aList.size() == 1);
	}
	
	@Test
	public void addMany() {
		aList = new ChainedList<>();
		aList.add(a);
		aList.add(b);
		
		assertTrue(aList.size() == 2);
		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
	}
	
	@Test
	public void removeBeginning() {
		aList = new ChainedList<>();
		aList.add(a);
		aList.add(b);
		aList.add(c);
		aList.add(d);
		aList.add(e);
		assertTrue(aList.size() == 5);
		
		aList.remove(0);
		
		assertTrue(aList.get(0) == b);
		assertTrue(aList.get(1) == c);
		assertTrue(aList.get(2) == d);
		assertTrue(aList.get(3) == e);
	}
	
	@Test
	public void removeMiddle() {
		aList = new ChainedList<>();
		aList.add(a);
		aList.add(b);
		aList.add(c);
		aList.add(d);
		aList.add(e);
		assertTrue(aList.size() == 5);
		
		aList.remove(2);
		
		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == d);
		assertTrue(aList.get(3) == e);		
	}

	@Test
	public void removeEnd() {
		aList = new ChainedList<>();
		aList.add(a);
		aList.add(b);
		aList.add(c);
		aList.add(d);
		aList.add(e);
		assertTrue(aList.size() == 5);
		
		aList.remove(4);
		
		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == c);
		assertTrue(aList.get(3) == d);			
	}
	
	@Test
	public void removeNoDuplicates() {
		aList = new ChainedList<>();
		aList.add(a);
		aList.add(b);
		aList.add(c);
		aList.add(d);
		aList.add(e);
		
		dupes = aList.removeAdjacentDuplicates();
		
		assertTrue(aList.size() == 5);

		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == c);
		assertTrue(aList.get(3) == d);	
		assertTrue(aList.get(4) == e);	
		
		assertTrue(dupes.size() == 0);
	}
	
	@Test
	public void removeMiddleDuplicate() {
		aList = new ChainedList<>();
		aList.add(a);
		aList.add(b);
		aList.add(c);
		aList.add(c);
		aList.add(d);
		aList.add(e);
		
		dupes = aList.removeAdjacentDuplicates();
		
		assertTrue(aList.size() == 5);

		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == c);
		assertTrue(aList.get(3) == d);	
		assertTrue(aList.get(4) == e);	
		
		assertTrue(dupes.size() == 1);
		
		assertTrue(dupes.get(0) == c);
	}
	
	@Test
	public void removeBeginningDuplicate() {
		aList = new ChainedList<>();
		aList.add(a);
		aList.add(a);
		aList.add(b);
		aList.add(c);
		aList.add(d);
		aList.add(e);
		
		dupes = aList.removeAdjacentDuplicates();
		
		assertTrue(aList.size() == 5);

		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == c);
		assertTrue(aList.get(3) == d);	
		assertTrue(aList.get(4) == e);	
		
		assertTrue(dupes.size() == 1);
		
		assertTrue(dupes.get(0) == a);
	}
	
	@Test
	public void removeEndDuplicate() {
		aList = new ChainedList<>();
		aList.add(a);
		aList.add(b);
		aList.add(c);
		aList.add(d);
		aList.add(e);
		aList.add(e);
		
		dupes = aList.removeAdjacentDuplicates();
		
		assertTrue(aList.size() == 5);

		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == c);
		assertTrue(aList.get(3) == d);	
		assertTrue(aList.get(4) == e);	
		
		assertTrue(dupes.size() == 1);
		
		assertTrue(dupes.get(0) == e);
	}
	
	@Test
	public void removeMultipleMiddleDuplicate() {
		aList = new ChainedList<>();
		aList.add(a);
		aList.add(b);
		aList.add(c);
		aList.add(c);
		aList.add(c);
		aList.add(d);
		aList.add(e);
		
		dupes = aList.removeAdjacentDuplicates();
		
		assertTrue(aList.size() == 5);

		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == c);
		assertTrue(aList.get(3) == d);	
		assertTrue(aList.get(4) == e);	
		
		assertTrue(dupes.size() == 2);
		
		assertTrue(dupes.get(0) == c);
		assertTrue(dupes.get(1) == c);
	}
	
	@Test
	public void removeMultipleBeginningDuplicate() {
		aList = new ChainedList<>();
		aList.add(a);
		aList.add(a);
		aList.add(a);
		aList.add(b);
		aList.add(c);
		aList.add(d);
		aList.add(e);
		
		dupes = aList.removeAdjacentDuplicates();
		
		assertTrue(aList.size() == 5);

		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == c);
		assertTrue(aList.get(3) == d);	
		assertTrue(aList.get(4) == e);	
		
		assertTrue(dupes.size() == 2);
		
		assertTrue(dupes.get(0) == a);
		assertTrue(dupes.get(1) == a);
	}
	
	@Test
	public void removeMultipleEndDuplicate() {
		aList = new ChainedList<>();
		aList.add(a);
		aList.add(b);
		aList.add(c);
		aList.add(d);
		aList.add(e);
		aList.add(e);
		aList.add(e);
		
		dupes = aList.removeAdjacentDuplicates();
		
		assertTrue(aList.size() == 5);

		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == c);
		assertTrue(aList.get(3) == d);	
		assertTrue(aList.get(4) == e);	
		
		assertTrue(dupes.size() == 2);
		
		assertTrue(dupes.get(0) == e);
		assertTrue(dupes.get(1) == e);
	}
	
	@Test
	public void removeMultipleFromEmpty() {
		aList = new ChainedList<>();
		
		dupes = aList.removeAdjacentDuplicates();
		
		assertTrue(aList.size() == 0);
		assertTrue(dupes.size() == 0);
	}
	
	@Test
	public void removeMultipleFromOne() {
		aList = new ChainedList<>();
		aList.add(a);
		
		dupes = aList.removeAdjacentDuplicates();
		
		assertTrue(aList.size() == 1);
		assertTrue(aList.get(0) == a);
		
		assertTrue(dupes.size() == 0);
	}
	
	@Test
	public void removeDuplicatesUsesEquals() {
		aList = new ChainedList<>();
		
		aList.add(a);
		aList.add(looksLikeA);
		
		dupes = aList.removeAdjacentDuplicates();
		
		assertTrue(aList.size() == 1);
		assertTrue(aList.get(0) == a);
	
		assertTrue(dupes.size() == 1);
		assertTrue(dupes.get(0) == looksLikeA);
	}
	
	@Test
	public void removeMultipleIndepentListsOriginal() {
		removeMultipleMiddleDuplicate();
		
		aList.remove(2);
		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == d);	
		assertTrue(aList.get(3) == e);	
		
		assertTrue(aList.size() == 4);

		assertTrue(dupes.size() == 2);
		
		assertTrue(dupes.get(0) == c);
		assertTrue(dupes.get(1) == c);		
	}
	
	@Test
	public void removeMultipleIndepentListsDuplicate() {
		removeMultipleMiddleDuplicate();
		
		dupes.remove(0);
		
		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == c);	
		assertTrue(aList.get(3) == d);	
		assertTrue(aList.get(4) == e);	
		
		assertTrue(aList.size() == 5);

		assertTrue(dupes.size() == 1);
		
		assertTrue(dupes.get(0) == c);
		
		dupes.remove(0);
		
		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == c);	
		assertTrue(aList.get(3) == d);	
		assertTrue(aList.get(4) == e);	
		
		assertTrue(aList.size() == 5);

		assertTrue(dupes.size() == 0);
	}
	
	@Test
	public void endOfListsCorrect() {
		removeMultipleMiddleDuplicate();
		
		assertTrue(aList.size() == 5);
		
		aList.add(x);
		aList.remove(4);
		aList.add(y);
		
		assertTrue(aList.size() == 6);

		assertTrue(aList.get(0) == a);
		assertTrue(aList.get(1) == b);
		assertTrue(aList.get(2) == c);
		assertTrue(aList.get(3) == d);	
		assertTrue(aList.get(4) == x);	
		assertTrue(aList.get(5) == y);	
		
		assertTrue(dupes.size() == 2);
		
		dupes.add(x);
		dupes.remove(1);
		dupes.add(y);

		assertTrue(dupes.get(0) == c);
		assertTrue(dupes.get(1) == x);
		assertTrue(dupes.get(2) == y);
	}
}
