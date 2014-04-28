package webhistory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WebHistoryTest {
	
	WebHistory history;
	
	WebAddress aAdr;
	WebAddress bAdr;
	WebAddress cAdr;
	WebAddress dAdr;

	@Before
	public void setUp() throws Exception {
		history = new WebHistory();
		
		aAdr = new WebAddress("a");
		bAdr = new WebAddress("b");
		cAdr = new WebAddress("c");
		dAdr = new WebAddress("d");
	}

	@Test
	public void test() {
		WebAddress currentURL = history.getCurrentURL();
		assertTrue(currentURL.getUrl().equals(""));
	}
	
	@Test
	public void hitsEnter() {
		history.hitsEnter(aAdr);
		
		WebAddress currentURL = history.getCurrentURL();
		assertTrue(currentURL == aAdr);
		assertTrue(history.getForwardSize() == 0);
		assertTrue(history.getBackwardSize() == 0);
		
	}

}
