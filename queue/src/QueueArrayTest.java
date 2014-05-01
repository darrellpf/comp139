
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueArrayTest {
	
	Worker aWorker;
	Worker bWorker;
	Worker cWorker;
	Worker dWorker;


	@Before
	public void setUp() throws Exception {
		aWorker = new Worker("a", "a");
		bWorker = new Worker("b", "b");
		cWorker = new Worker("c", "c");
		dWorker = new Worker("d", "d");
	}

	@Test
	public void intialized() {
		QueueInterface<Worker> aQueue = new QueueLinked<Worker>();

		assertTrue(aQueue.size() == 0);
	}
	
	@Test
	public void enqueuedequeueOne() {
		QueueInterface<Worker> aQueue = new QueueLinked<Worker>();
		
		aQueue.enqueue(aWorker);
		assertTrue(aQueue.size() == 1);
		
		assertTrue(aQueue.peekFirst() == aWorker);
		
		Worker first = aQueue.dequeue();
		assertTrue(first == aWorker);		
	}
	
	@Test
	public void enqueuedequeueTwo() {
		QueueInterface<Worker> aQueue = new QueueLinked<Worker>();
		
		aQueue.enqueue(aWorker);
		assertTrue(aQueue.size() == 1);
		aQueue.enqueue(bWorker);
		assertTrue(aQueue.size() == 2);
		
		assertTrue(aQueue.peekFirst() == aWorker);
		
		Worker first = aQueue.dequeue();
		assertTrue(first == aWorker);		
		
		first = aQueue.dequeue();
		assertTrue(first == bWorker);		
	}
	
	@Test
	public void enqueuedequeueMany() {
		QueueInterface<Worker> aQueue = new QueueLinked<Worker>();
		
		aQueue.enqueue(aWorker);
		assertTrue(aQueue.size() == 1);
		aQueue.enqueue(bWorker);
		assertTrue(aQueue.size() == 2);
		aQueue.enqueue(cWorker);
		assertTrue(aQueue.size() == 3);
		
		assertTrue(aQueue.peekFirst() == aWorker);
		
		Worker first = aQueue.dequeue();
		assertTrue(first == aWorker);		
		assertTrue(aQueue.peekFirst() == bWorker);
		assertTrue(aQueue.size() == 2);

		aQueue.enqueue(dWorker);
		assertTrue(aQueue.size() == 3);
		assertTrue(aQueue.peekFirst() == bWorker);
		
		first = aQueue.dequeue();
		assertTrue(first == bWorker);		
		assertTrue(aQueue.size() == 2);
		assertTrue(aQueue.peekFirst() == cWorker);
		
		first = aQueue.dequeue();
		assertTrue(first == cWorker);		
		assertTrue(aQueue.size() == 1);
		assertTrue(aQueue.peekFirst() == dWorker);
		
		first = aQueue.dequeue();
		assertTrue(first == dWorker);		
		assertTrue(aQueue.size() == 0);
	}

}
