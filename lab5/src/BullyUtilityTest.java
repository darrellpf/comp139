
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;


public class BullyUtilityTest {
	Bully runt;
	Bully kong;

	Bully small;
	Bully medium;
	Bully large;

	Deque<Bully> unbeatenBullies;


	@Before
	public void setUp() throws Exception {
		runt = new Bully("Runt", 99, 10);
		kong = new Bully("Kong", 350, 1);
		
		small = new Bully("Small", 100, 5);
		medium = new Bully("Medium", 150, 10);
		large = new Bully("Large", 200, 15);
		
		unbeatenBullies = new LinkedList<Bully>();
	}
	
	@Test
	public void challenge() {
		
		unbeatenBullies.push(large);
		unbeatenBullies.push(medium);
		unbeatenBullies.push(small);
		
		BullyUtility.challenge(unbeatenBullies, runt);
		
		assertTrue(unbeatenBullies.pop() == runt);
		assertTrue(unbeatenBullies.pop() == small);
		assertTrue(unbeatenBullies.pop() == medium);
		assertTrue(unbeatenBullies.pop() == large);
	}
	
	@Test
	public void challengePartway() {
		
		unbeatenBullies.push(kong);
		unbeatenBullies.push(runt);
		unbeatenBullies.push(small);
		
		BullyUtility.challenge(unbeatenBullies, medium);
		
		assertTrue(unbeatenBullies.size() == 2);
		assertTrue(unbeatenBullies.pop() == medium);
		assertTrue(unbeatenBullies.pop() == kong);
	}
	
	@Test
	public void challengeEndToTheTop() {
		
		unbeatenBullies.push(large);
		unbeatenBullies.push(medium);
		unbeatenBullies.push(small);
		
		BullyUtility.challenge(unbeatenBullies, kong);
		
		assertTrue(unbeatenBullies.size() == 1);
		assertTrue(unbeatenBullies.pop() == kong);
	}

	@Test
	public void findWinners() {
		List<Bully> initialBullies = new ArrayList<>();
		
		initialBullies.add(small);
		initialBullies.add(medium);
		initialBullies.add(large);
		initialBullies.add(kong);
		
		List<Bully> result = BullyUtility.findWinners(initialBullies);
		
		assertTrue(result.size() == 1);
		Bully onlyOne = result.get(0);
		assertTrue(onlyOne == kong);
		int pummelCount = kong.getPeoplePummeled();
		assertTrue(pummelCount == 4);
		assertTrue(kong.getLunchMoney() == 31);
	}
	
	@Test
	public void findWinnersTwo() {
		List<Bully> initialBullies = new ArrayList<>();

		initialBullies.add(large);
		initialBullies.add(kong);
		initialBullies.add(small);
		initialBullies.add(medium);

		List<Bully> result = BullyUtility.findWinners(initialBullies);

		assertTrue(result.size() == 2);
		assertTrue(result.get(0) == kong);
		assertTrue(result.get(1) == medium);
	}

	@Test
	public void findWinnersThree() {
		List<Bully> initialBullies = new ArrayList<>();

		initialBullies.add(large);
		initialBullies.add(small);
		initialBullies.add(kong);
		initialBullies.add(medium);

		List<Bully> result = BullyUtility.findWinners(initialBullies);

		assertTrue(result.size() == 2);
		assertTrue(result.get(0) == kong);
		assertTrue(result.get(1) == medium);
	}
	
	@Test
	public void findWinnersFour() {
		List<Bully> initialBullies = new ArrayList<>();

		initialBullies.add(kong);
		initialBullies.add(small);
		initialBullies.add(medium);
		initialBullies.add(large);

		List<Bully> result = BullyUtility.findWinners(initialBullies);

		assertTrue(result.size() == 2);
		assertTrue(result.get(0) == kong);
		assertTrue(result.get(1) == large);
	}

}




