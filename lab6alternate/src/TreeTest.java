import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;


public class TreeTest {

	Worker aWorker;
	Worker bWorker;
	Worker cWorker;
	Worker dWorker;
	Worker eWorker;
	Worker fWorker;


	@Before
	public void setUp() throws Exception {
		aWorker = new Worker("a", "a");
		bWorker = new Worker("b", "b");
		cWorker = new Worker("c", "c");
		dWorker = new Worker("d", "d");
		eWorker = new Worker("e", "e");
		fWorker = new Worker("f", "f");
	}

	@Test
	public void iteratorNoItems() {
		Tree<Worker> aTree = new Tree<>();
		
		Iterator<Worker> iter = aTree.iterator();
		assertTrue(iter.hasNext() == false);
	}
	
	@Test
	public void iteratorOneItem() {
		Tree<Worker> aTree = new Tree<>();
		aTree.add(aWorker);
		
		Iterator<Worker> iter = aTree.iterator();
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == aWorker);
		
		assertTrue(iter.hasNext() == false);
	}
	
	@Test
	public void iteratorTwoItems() {
		Tree<Worker> aTree = new Tree<>();
		aTree.add(cWorker);
		aTree.add(dWorker);
		
		Iterator<Worker> iter = aTree.iterator();
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == cWorker);
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == dWorker);
		
		assertTrue(iter.hasNext() == false);
	}
	
	@Test
	public void iteratorTwoItemsReverse() {
		Tree<Worker> aTree = new Tree<>();
		aTree.add(dWorker);
		aTree.add(cWorker);
		
		Iterator<Worker> iter = aTree.iterator();
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == cWorker);
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == dWorker);
		
		assertTrue(iter.hasNext() == false);
	}
	
	@Test
	public void iteratorThreeItems() {
		Tree<Worker> aTree = new Tree<>();
		aTree.add(cWorker);
		aTree.add(aWorker);
		aTree.add(dWorker);
		
		Iterator<Worker> iter = aTree.iterator();
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == aWorker);
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == cWorker);
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == dWorker);

		assertTrue(iter.hasNext() == false);
	}
	
	@Test
	public void iteratorItemsAddedReverse() {
		Tree<Worker> aTree = new Tree<>();
		aTree.add(fWorker);
		aTree.add(eWorker);
		aTree.add(dWorker);
		aTree.add(cWorker);
		aTree.add(bWorker);
		aTree.add(aWorker);
		
		Iterator<Worker> iter = aTree.iterator();
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == aWorker);
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == bWorker);
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == cWorker);
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == dWorker);

		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == eWorker);
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == fWorker);

		assertTrue(iter.hasNext() == false);
	}
	
	@Test
	public void iteratorItemsAddedBalanced() {
		Tree<Worker> aTree = new Tree<>();
		aTree.add(cWorker);
		aTree.add(bWorker);
		aTree.add(aWorker);
		aTree.add(dWorker);
		aTree.add(fWorker);
		aTree.add(eWorker);
		
		Iterator<Worker> iter = aTree.iterator();
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == aWorker);
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == bWorker);
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == cWorker);
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == dWorker);

		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == eWorker);
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == fWorker);

		assertTrue(iter.hasNext() == false);
	}
}
