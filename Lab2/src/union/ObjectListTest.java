package union;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ObjectListTest {
	
	Worker a;
	Worker b;
	Worker c;
	Worker d;
	Worker e;
	
	Worker matchesA;
	
	ObjectList<Worker> startsEmptyList;
	ObjectList<Worker> startsWithFiveList;

	@Before
	public void setUp() throws Exception {
		
		a = new Worker("a", "Maintenance");
		b = new Worker("b", "Electrician");
		c = new Worker("c", "Electrician");
		d = new Worker("d", "Electrician");
		e = new Worker("e", "Electrician");
		
		matchesA = new Worker("a", "");
		
		startsEmptyList = new ObjectList<>();
		
		startsWithFiveList = new ObjectList<>();
		startsWithFiveList.add(a);
		startsWithFiveList.add(b);
		startsWithFiveList.add(c);
		startsWithFiveList.add(d);
		startsWithFiveList.add(e);
	}
	
	@Test
	public void initialSizeEmpty() {
		assertTrue(startsEmptyList.size() == 0);
	}
	
	@Test
	public void addOneThenRetrieve() {
		startsEmptyList.add(a);
		
		Worker who = (Worker) startsEmptyList.get(0);
		assertTrue(who == a);
		assertTrue(startsEmptyList.size() == 1);
	}
	
	@Test
	public void addMany() {
		startsEmptyList.add(a);
		startsEmptyList.add(b);
		
		assertTrue(startsEmptyList.size() == 2);
		assertTrue(startsEmptyList.get(0) == a);
		assertTrue(startsEmptyList.get(1) == b);
	}
	
	@Test
	public void removeBeginning() {
		assertTrue(startsWithFiveList.size() == 5);
		
		startsWithFiveList.remove(0);
		
		assertTrue(startsWithFiveList.get(0) == b);
		assertTrue(startsWithFiveList.get(1) == c);
		assertTrue(startsWithFiveList.get(2) == d);
		assertTrue(startsWithFiveList.get(3) == e);
	}
	
	@Test
	public void removeMiddle() {
		assertTrue(startsWithFiveList.size() == 5);
		
		startsWithFiveList.remove(2);
		
		assertTrue(startsWithFiveList.get(0) == a);
		assertTrue(startsWithFiveList.get(1) == b);
		assertTrue(startsWithFiveList.get(2) == d);
		assertTrue(startsWithFiveList.get(3) == e);		
	}

	@Test
	public void removeEnd() {
		assertTrue(startsWithFiveList.size() == 5);
		
		startsWithFiveList.remove(4);
		
		assertTrue(startsWithFiveList.get(0) == a);
		assertTrue(startsWithFiveList.get(1) == b);
		assertTrue(startsWithFiveList.get(2) == c);
		assertTrue(startsWithFiveList.get(3) == d);				
	}
	
	@Test
	public void constructorFromOtherEmpty() {
		ObjectList<Worker> emptyList = new ObjectList<>();
		ObjectList<Worker> fromEmpty = new ObjectList<>(emptyList);
		
		assertTrue(fromEmpty.size() == 0);
	}
	
	@Test
	public void constructorFromOneItemList() {
		ObjectList<Worker> oneList = new ObjectList<>();
		oneList.add(a);
		
		ObjectList<Worker> copyOneList = new ObjectList<>(oneList);
		
		assertTrue(isSameList(oneList, copyOneList) == true);
	}
	
	@Test
	public void constructorFromMany() {
		ObjectList<Worker> manyList = new ObjectList<>();
		manyList.add(a);
		manyList.add(b);
		manyList.add(c);
		manyList.add(d);
		manyList.add(e);
		
		ObjectList<Worker> copyOneList = new ObjectList<>(manyList);
		
		assertTrue(isSameList(manyList, copyOneList) == true);
	}
	
	@Test
	public void independentLists() {
		ObjectList<Worker> newList = new ObjectList<>(startsWithFiveList);
		
		newList.remove(2);
		
		assertTrue(startsWithFiveList.size() == 5);
		
		assertTrue(startsWithFiveList.get(0) == a);
		assertTrue(startsWithFiveList.get(1) == b);
		assertTrue(startsWithFiveList.get(2) == c);
		assertTrue(startsWithFiveList.get(3) == d);
		assertTrue(startsWithFiveList.get(4) == e);
		
		assertTrue(newList.size() == 4);
		
		assertTrue(newList.get(0) == a);
		assertTrue(newList.get(1) == b);
		assertTrue(newList.get(2) == d);
		assertTrue(newList.get(3) == e);
	}
	
	@Test
	public void insertAtBeginning() {
		Worker xxx = new Worker("xxx", "xxx");
		
		int sizeBefore = startsWithFiveList.size();
		
		startsWithFiveList.insertAtPosition(xxx, 0);

		assertTrue(startsWithFiveList.size() == sizeBefore + 1);
		
		assertTrue(startsWithFiveList.get(0) == xxx);
		assertTrue(startsWithFiveList.get(1) == a);
		assertTrue(startsWithFiveList.get(2) == b);
		assertTrue(startsWithFiveList.get(3) == c);
		assertTrue(startsWithFiveList.get(4) == d);
		assertTrue(startsWithFiveList.get(5) == e);
	}
	
	@Test
	public void insertAtMiddle() {
		Worker xxx = new Worker("xxx", "xxx");
		
		int sizeBefore = startsWithFiveList.size();
		
		startsWithFiveList.insertAtPosition(xxx, 3);

		assertTrue(startsWithFiveList.size() == sizeBefore + 1);
		
		assertTrue(startsWithFiveList.get(0) == a);
		assertTrue(startsWithFiveList.get(1) == b);
		assertTrue(startsWithFiveList.get(2) == c);
		assertTrue(startsWithFiveList.get(3) == xxx);
		assertTrue(startsWithFiveList.get(4) == d);
		assertTrue(startsWithFiveList.get(5) == e);	
	}
	
	@Test
	public void insertAtPastEnd() {
		Worker xxx = new Worker("xxx", "xxx");
		
		int sizeBefore = startsWithFiveList.size();
		
		startsWithFiveList.insertAtPosition(xxx, 5);

		assertTrue(startsWithFiveList.size() == sizeBefore + 1);
		
		assertTrue(startsWithFiveList.get(0) == a);
		assertTrue(startsWithFiveList.get(1) == b);
		assertTrue(startsWithFiveList.get(2) == c);
		assertTrue(startsWithFiveList.get(3) == d);
		assertTrue(startsWithFiveList.get(4) == e);	
		assertTrue(startsWithFiveList.get(5) == xxx);
	}
	
	@Test
	public void insertIntoEmpty() {
		ObjectList<Worker> aList = new ObjectList<>();
		
		aList.insertAtPosition(a, 0);
		
		assertTrue(aList.size() == 1);
		assertTrue(aList.get(0) == a);
	}
	
	@Test
	public void insertABunch() {
		ObjectList<Worker> aList = new ObjectList<>();

		for(int i = 0; i < 10000; i++) {
			aList.insertAtPosition(new Worker("Fred" + i, "Jobless"), 0);
		}
	}
	
	@Test
	public void containsOnEmpty() {
		assertTrue(startsEmptyList.contains(matchesA) == false);
	}
	
	@Test
	public void containsAtBegining() {
		Worker matchesFirst = new Worker("a", "x");
		assertTrue(startsWithFiveList.contains(matchesFirst) == true);
	}
	
	@Test
	public void containsAtMiddle() {
		Worker matchesMiddle = new Worker("c", "x");
		assertTrue(startsWithFiveList.contains(matchesMiddle) == true);
	}
	
	@Test
	public void containsAtEnd() {
		Worker matchesLast = new Worker("e", "x");
		assertTrue(startsWithFiveList.contains(matchesLast) == true);
		
	}
	
	@Test
	public void containsNotOnList() {
		Worker noMatch = new Worker("zzz", "x");
		assertTrue(startsWithFiveList.contains(noMatch) == false);
	}
	
	private <E> boolean isSameList(ObjectList<E> aList, ObjectList<E> bList) {
		if(aList.size() != bList.size()) {
			return false;
		}
		
		for(int i = 0; i < aList.size(); i++) {
			E itemA = aList.get(i);
			E itemB = bList.get(i);
			if(itemA != itemB) {
				return false;
			}
		}
		
		return true;
	}
}