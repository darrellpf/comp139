package stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackArrayTest {
	
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
		StackInterface<Worker> aStack = new StackLinked<Worker>();

		assertTrue(aStack.size() == 0);
	}
	
	@Test
	public void pushPopOne() {
		StackInterface<Worker> aStack = new StackLinked<Worker>();
		
		aStack.push(aWorker);
		assertTrue(aStack.size() == 1);
		
		assertTrue(aStack.peek() == aWorker);
		
		Worker first = aStack.pop();
		assertTrue(first == aWorker);		
	}
	
	@Test
	public void pushPopTwo() {
		StackInterface<Worker> aStack = new StackLinked<Worker>();
		
		aStack.push(aWorker);
		assertTrue(aStack.size() == 1);
		aStack.push(bWorker);
		assertTrue(aStack.size() == 2);
		
		assertTrue(aStack.peek() == bWorker);
		
		Worker first = aStack.pop();
		assertTrue(first == bWorker);		
		
		first = aStack.pop();
		assertTrue(first == aWorker);		
	}
	
	@Test
	public void pushPopMany() {
		StackInterface<Worker> aStack = new StackLinked<Worker>();
		
		aStack.push(aWorker);
		assertTrue(aStack.size() == 1);
		aStack.push(bWorker);
		assertTrue(aStack.size() == 2);
		aStack.push(cWorker);
		assertTrue(aStack.size() == 3);
		
		assertTrue(aStack.peek() == cWorker);
		
		Worker first = aStack.pop();
		assertTrue(first == cWorker);		
		assertTrue(aStack.peek() == bWorker);
		assertTrue(aStack.size() == 2);

		aStack.push(dWorker);
		assertTrue(aStack.size() == 3);
		assertTrue(aStack.peek() == dWorker);
		
		first = aStack.pop();
		assertTrue(first == dWorker);		
		assertTrue(aStack.size() == 2);
		assertTrue(aStack.peek() == bWorker);
		
		first = aStack.pop();
		assertTrue(first == bWorker);		
		assertTrue(aStack.size() == 1);
		assertTrue(aStack.peek() == aWorker);
		
		first = aStack.pop();
		assertTrue(first == aWorker);		
		assertTrue(aStack.size() == 0);
	}

}
