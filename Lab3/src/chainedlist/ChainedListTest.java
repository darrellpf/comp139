package chainedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChainedListTest {

	Worker a;
	Worker b;
	Worker c;
	Worker d;
	Worker e;

	GenericList<Worker> union;

	GenericList<Worker> unionFive;

	Worker marker;
	ChainedList<Worker> original;

	@Before
	public void setUp() throws Exception {
		a = new Worker("a", "a");
		b = new Worker("b", "b");
		c = new Worker("c", "c");
		d = new Worker("d", "d");
		e = new Worker("e", "e");

		union = new ChainedList<Worker>();
		unionFive = new ChainedList<Worker>();

		unionFive.add(a);
		unionFive.add(b);
		unionFive.add(c);
		unionFive.add(d);
		unionFive.add(e);

		original = new ChainedList<>();
		original.add(a);
		original.add(b);
		original.add(c);
		original.add(c);
		original.add(d);

		marker = new Worker("x", "x");

	}

	@Test
	public void intialized() {
		assertTrue(union.size() == 0);
	}

	@Test
	public void addOne() {
		union.add(a);

		assertTrue(union.size() == 1);
		assertTrue(union.get(0) == a);
	}

	@Test
	public void addTwo() {
		union.add(a);
		union.add(b);

		assertTrue(union.size() == 2);
		assertTrue(union.get(0) == a);
		assertTrue(union.get(1) == b);
	}

	@Test
	public void removeSingle() {
		union.add(a);

		union.remove(0);
		assertTrue(union.size() == 0);
	}

	@Test
	public void removeDoubleFirst() {
		union.add(a);
		union.add(b);

		union.remove(0);
		assertTrue(union.size() == 1);
		assertTrue(union.get(0) == b);
	}

	@Test
	public void removeDoubleLast() {
		union.add(a);
		union.add(b);

		union.remove(1);
		assertTrue(union.size() == 1);
		assertTrue(union.get(0) == a);
	}

	@Test
	public void removeFirst() {
		assertTrue(unionFive.size() == 5);
		unionFive.remove(0);

		assertTrue(unionFive.size() == 4);

		assertTrue(unionFive.get(0) == b);
		assertTrue(unionFive.get(1) == c);
		assertTrue(unionFive.get(2) == d);
		assertTrue(unionFive.get(3) == e);
	}

	@Test
	public void removeMiddle() {
		assertTrue(unionFive.size() == 5);
		unionFive.remove(2);

		assertTrue(unionFive.size() == 4);

		assertTrue(unionFive.get(0) == a);
		assertTrue(unionFive.get(1) == b);
		assertTrue(unionFive.get(2) == d);
		assertTrue(unionFive.get(3) == e);
	}

	@Test
	public void removeEnd() {
		assertTrue(unionFive.size() == 5);
		unionFive.remove(4);

		assertTrue(unionFive.size() == 4);

		assertTrue(unionFive.get(0) == a);
		assertTrue(unionFive.get(1) == b);
		assertTrue(unionFive.get(2) == c);
		assertTrue(unionFive.get(3) == d);
	}

	@Test
	public void addAllNoneToNone() {
		ChainedList<Worker> empty = new ChainedList<>();
		ChainedList<Worker> anotherEmpty = new ChainedList<>();

		empty.addAll(anotherEmpty);

		assertTrue(empty.size() == 0);
		assertTrue(anotherEmpty.size() == 0);
	}

	@Test
	public void addAllNoneOnIncoming() {
		ChainedList<Worker> empty = new ChainedList<>();
		original.addAll(empty);

		assertTrue(empty.size() == 0);
		assertTrue(original.size() == 5);

		assertTrue(original.get(0) == a);
		assertTrue(original.get(1) == b);
		assertTrue(original.get(2) == c);
		assertTrue(original.get(3) == c);
		assertTrue(original.get(4) == d);
	}

	@Test
	public void addAllOneToEmpty() {
		ChainedList<Worker> empty = new ChainedList<>();
		ChainedList<Worker> oneItemList = new ChainedList<>();
		oneItemList.add(a);

		empty.addAll(oneItemList);

		assertTrue(empty.size() == 1);

		assertTrue(oneItemList.size() == 1);
		assertTrue(oneItemList.get(0) == a);
	}

	@Test
	public void addAllOneToOne() {
		ChainedList<Worker> addToThis = new ChainedList<>();
		addToThis.add(a);
		ChainedList<Worker> oneItemList = new ChainedList<>();
		oneItemList.add(b);

		addToThis.addAll(oneItemList);

		assertTrue(addToThis.size() == 2);
		assertTrue(addToThis.get(0) == a);
		assertTrue(addToThis.get(1) == b);

		assertTrue(oneItemList.size() == 1);
		assertTrue(oneItemList.get(0) == b);
	}

	@Test
	public void addAllTwoOntoOne() {
		ChainedList<Worker> addToThis = new ChainedList<>();
		addToThis.add(a);
		ChainedList<Worker> twoItemList = new ChainedList<>();
		twoItemList.add(b);
		twoItemList.add(c);

		addToThis.addAll(twoItemList);

		assertTrue(addToThis.size() == 3);
		assertTrue(addToThis.get(0) == a);
		assertTrue(addToThis.get(1) == b);
		assertTrue(addToThis.get(2) == c);

		assertTrue(twoItemList.size() == 2);
		assertTrue(twoItemList.get(0) == b);
		assertTrue(twoItemList.get(1) == c);
	}

	@Test
	public void addAllTwoOntoTwo() {
		ChainedList<Worker> addToThis = new ChainedList<>();
		addToThis.add(a);
		addToThis.add(b);
		ChainedList<Worker> twoItemList = new ChainedList<>();
		twoItemList.add(c);
		twoItemList.add(d);

		addToThis.addAll(twoItemList);

		assertTrue(addToThis.size() == 4);
		assertTrue(addToThis.get(0) == a);
		assertTrue(addToThis.get(1) == b);
		assertTrue(addToThis.get(2) == c);
		assertTrue(addToThis.get(3) == d);

		assertTrue(twoItemList.size() == 2);
		assertTrue(twoItemList.get(0) == c);
		assertTrue(twoItemList.get(1) == d);
	}

	@Test
	public void addAllEndCorrect() {
		ChainedList<Worker> addToThis = new ChainedList<>();
		addToThis.add(a);
		addToThis.add(b);

		ChainedList<Worker> twoItemList = new ChainedList<>();
		twoItemList.add(c);
		twoItemList.add(d);

		addToThis.addAll(twoItemList);

		addToThis.add(e);

		addToThis.remove(4);
		addToThis.add(a);

		assertTrue(addToThis.size() == 5);
		assertTrue(addToThis.get(0) == a);
		assertTrue(addToThis.get(1) == b);
		assertTrue(addToThis.get(2) == c);
		assertTrue(addToThis.get(3) == d);
		assertTrue(addToThis.get(4) == a);
	}

	@Test
	public void addAllIndependentLists() {
		ChainedList<Worker> addToThis = new ChainedList<>();
		addToThis.add(a);
		addToThis.add(b);

		ChainedList<Worker> twoItemList = new ChainedList<>();
		twoItemList.add(c);
		twoItemList.add(d);

		addToThis.addAll(twoItemList);

		addToThis.remove(0);
		twoItemList.remove(1);

		assertTrue(addToThis.size() == 3);
		assertTrue(addToThis.get(0) == b);
		assertTrue(addToThis.get(1) == c);
		assertTrue(addToThis.get(2) == d);

		assertTrue(twoItemList.size() == 1);
		assertTrue(twoItemList.get(0) == c);
	}

	@Test
	public void generalMatchCase() {
		ChainedList<Worker> result = original.addMarker(new Worker("c", "c"),
				marker);

		assertTrue(original.size() == 5);

		assertTrue(original.get(0) == a);
		assertTrue(original.get(1) == b);
		assertTrue(original.get(2) == c);
		assertTrue(original.get(3) == c);
		assertTrue(original.get(4) == d);

		assertTrue(result.size() == 7);

		assertTrue(result.get(0) == a);
		assertTrue(result.get(1) == b);
		assertTrue(result.get(2) == marker);
		assertTrue(result.get(3) == c);
		assertTrue(result.get(4) == marker);
		assertTrue(result.get(5) == c);
		assertTrue(result.get(6) == d);
	}

	@Test
	public void noMatches() {
		Worker noMatch = new Worker("zz", "zz");
		ChainedList<Worker> result = original.addMarker(noMatch, marker);

		assertTrue(original.size() == 5);

		assertTrue(original.get(0) == a);
		assertTrue(original.get(1) == b);
		assertTrue(original.get(2) == c);
		assertTrue(original.get(3) == c);
		assertTrue(original.get(4) == d);

		assertTrue(result.size() == 5);

		assertTrue(result.get(0) == a);
		assertTrue(result.get(1) == b);
		assertTrue(result.get(2) == c);
		assertTrue(result.get(3) == c);
		assertTrue(result.get(4) == d);
	}

	@Test
	public void noList() {
		original = new ChainedList<>();

		ChainedList<Worker> result = original.addMarker(new Worker("c", "c"),
				marker);

		assertTrue(original.size() == 0);

		assertTrue(result.size() == 0);
	}

	@Test
	public void sizeOneMatch() {
		original = new ChainedList<>();

		original.add(c);

		ChainedList<Worker> result = original.addMarker(new Worker("c", "c"),
				marker);

		assertTrue(original.size() == 1);

		assertTrue(original.get(0) == c);

		assertTrue(result.size() == 2);

		assertTrue(result.get(0) == marker);
		assertTrue(result.get(1) == c);
	}

	@Test
	public void sizeOneNoMatch() {
		Worker noMatch = new Worker("zz", "zz");

		original = new ChainedList<>();
		original.add(c);

		ChainedList<Worker> result = original.addMarker(noMatch, marker);

		assertTrue(original.size() == 1);

		assertTrue(original.get(0) == c);

		assertTrue(result.size() == 1);

		assertTrue(result.get(0) == c);
	}

	@Test
	public void tailOnCopy() {
		ChainedList<Worker> result = original.addMarker(new Worker("c", "c"),
				marker);

		assertTrue(original.size() == 5);

		assertTrue(original.get(0) == a);
		assertTrue(original.get(1) == b);
		assertTrue(original.get(2) == c);
		assertTrue(original.get(3) == c);
		assertTrue(original.get(4) == d);

		assertTrue(result.size() == 7);

		assertTrue(result.get(0) == a);
		assertTrue(result.get(1) == b);
		assertTrue(result.get(2) == marker);
		assertTrue(result.get(3) == c);
		assertTrue(result.get(4) == marker);
		assertTrue(result.get(5) == c);
		assertTrue(result.get(6) == d);

		Worker extra = new Worker("e", "e");

		result.add(extra);

		assertTrue(result.get(7) == extra);
	}

}
