package heap;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getParentPosition() {
		PriorityQueueImpl<Patient> q = new PriorityQueueImpl<Patient>();

		assertTrue(q.getParentPosition(1) == 0);
		assertTrue(q.getParentPosition(2) == 0);

		assertTrue(q.getParentPosition(3) == 1);
		assertTrue(q.getParentPosition(4) == 1);

		assertTrue(q.getParentPosition(5) == 2);
		assertTrue(q.getParentPosition(6) == 2);

		assertTrue(q.getParentPosition(7) == 3);
		assertTrue(q.getParentPosition(8) == 3);
	}

	@Test
	public void leftChildPosition() {
		PriorityQueueImpl<Patient> q = new PriorityQueueImpl<Patient>();

		assertTrue(q.getLeftChildPosition(1) == 3);
		assertTrue(q.getLeftChildPosition(3) == 7);
	}

	@Test
	public void rightChildPosition() {
		PriorityQueueImpl<Patient> q = new PriorityQueueImpl<Patient>();

		assertTrue(q.getRightChildPosition(1) == 4);
		assertTrue(q.getRightChildPosition(3) == 8);
	}

	@Test
	public void queueWorks() {
		PriorityQueueImpl<Integer> q = new PriorityQueueImpl<Integer>();

		q.add(45);
		q.add(12);
		q.add(10);
		q.add(18);

		assertTrue(q.size() == 4);

		assertTrue(q.remove() == 10);
		assertTrue(q.size() == 3);

		assertTrue(q.remove() == 12);
		assertTrue(q.size() == 2);

		assertTrue(q.remove() == 18);
		assertTrue(q.size() == 1);

		assertTrue(q.remove() == 45);
		assertTrue(q.size() == 0);
	}

	@Test
	public void iteratorFirstHasBest() {
		PriorityQueueImpl<Integer> q = new PriorityQueueImpl<Integer>();

		q.add(45);
		q.add(12);
		q.add(10);
		q.add(18);

		Iterator<Integer> iter = q.iterator();

		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == 10);
	}

}
