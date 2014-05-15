
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TreeTest {
	
	Worker aWorker;
	Worker bWorker;
	Worker cWorker;
	Worker dWorker;
	Worker eWorker;
	Worker fWorker;
	Worker gWorker;
	Worker hWorker;


	@Before
	public void setUp() throws Exception {
		aWorker = new Worker("a", "a");
		bWorker = new Worker("b", "b");
		cWorker = new Worker("c", "c");
		dWorker = new Worker("d", "d");
		dWorker = new Worker("e", "e");
		dWorker = new Worker("e", "f");
		dWorker = new Worker("g", "g");
		dWorker = new Worker("h", "h");
	}

	@Test
	public void intialized() {
	}
}
