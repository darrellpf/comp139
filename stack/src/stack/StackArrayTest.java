package stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackArrayTest {
	
	Worker aWorker;
	Worker bWorker;

	@Before
	public void setUp() throws Exception {
		aWorker = new Worker("a", "a");
		bWorker = new Worker("b", "b");
	}

	@Test
	public void intialized() {
		StackInterface<Worker> aStack = new StackArray<Worker>();

		assertTrue(aStack.size() == 0);
	}
	
	@Test
	public void pushPopOne() {
		StackInterface<Worker> aStack = new StackArray<Worker>();
		
		aStack.push(aWorker);
		assertTrue(aStack.size() == 1);
		
		assertTrue(aStack.peek() == aWorker);
		
		Worker first = aStack.pop();
		assertTrue(first == aWorker);		
	}
	
	@Test
	public void pushPopTwo() {
		StackInterface<Worker> aStack = new StackArray<Worker>();
		
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

}
