
import static org.junit.Assert.*;
import org.junit.Test;

public class RecursiveBinarySearchTest {

	static final int[] orderedNumbers = { -55, -10, 23, 57, 91, 101, 132, 333, 444 };

	@Test
	public void leftMostFound() {
		int numberToFind = -55;

		int position = RecursiveBinarySearch.findNumber(orderedNumbers, numberToFind, 0,
				orderedNumbers.length - 1);	
		
		assertTrue(position == 0);
	}
	
	@Test
	public void leftMostNotFound() {
		int numberToFind = -999;

		int position = RecursiveBinarySearch.findNumber(orderedNumbers, numberToFind, 0,
				orderedNumbers.length - 1);	
		
		assertTrue(position == -1);
	}
	
	@Test
	public void rightMostFound() {
		int numberToFind = 444;

		int position = RecursiveBinarySearch.findNumber(orderedNumbers, numberToFind, 0,
				orderedNumbers.length - 1);	
		
		assertTrue(position == 8);
	}
	
	@Test
	public void rightMostNotFound() {
		int numberToFind = 999;

		int position = RecursiveBinarySearch.findNumber(orderedNumbers, numberToFind, 0,
				orderedNumbers.length - 1);	
		
		assertTrue(position == -1);
	}
	
	@Test
	public void middleFound() {
		int numberToFind = 91;

		int position = RecursiveBinarySearch.findNumber(orderedNumbers, numberToFind, 0,
				orderedNumbers.length - 1);	
		
		assertTrue(position == 4);
	}
}
