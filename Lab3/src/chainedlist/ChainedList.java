package chainedlist;

public class ChainedList<E> implements GenericList<E> {

	private Node startOfChain;
	private int itemCount;

	public ChainedList() {
		startOfChain = null;
		itemCount = 0;
	}

	@Override
	public void add(E who) {
		Node newNode = new Node(who);

		if (itemCount == 0) {
			startOfChain = newNode;
			itemCount++;
			return;
		}

		Node current = startOfChain;

		while (current.next != null) {
			current = current.next;
		}

		current.next = newNode;
		itemCount++;
	}

	@Override
	public E get(int position) {
		Node current = startOfChain;

		for (int i = 0; i < position; i++) {
			current = current.next;
		}

		return current.storedItem;
	}

	@Override
	public int size() {
		return itemCount;
	}

	@Override
	public void remove(int oneToRemovePosition) {
		if (oneToRemovePosition == 0) {
			startOfChain = startOfChain.next;
			itemCount--;
			return;
		}

		Node current = startOfChain;

		for (int i = 0; i < oneToRemovePosition - 1; i++) {
			current = current.next;
		}

		Node oneBefore = current;
		Node oneToRemove = oneBefore.next;
		Node oneAfter = oneToRemove.next;

		oneBefore.next = oneAfter;
		itemCount--;
	}

	public void addAll(ChainedList<E> other) {
		if (other.itemCount == 0) {
			return;
		}

		Node dummy = null;

		Node currentOther = other.startOfChain;
		Node tail = startOfChain;

		if (startOfChain == null) {
			dummy = new Node(null);
			tail = dummy;
		}

		while (tail.next != null) {
			tail = tail.next;
		}

		while (currentOther != null) {
			tail.next = new Node(currentOther.storedItem);
			tail = tail.next;

			currentOther = currentOther.next;
		}

		if (dummy != null) {
			startOfChain = dummy.next;
		}

		itemCount += other.itemCount;
	}

	public void addAllNoDummy(ChainedList<E> other) {
		if (other.itemCount == 0) {
			return;
		}

		Node copyHead = new Node(other.startOfChain.storedItem);
		Node copyTail = copyHead;
		Node copyThis = other.startOfChain.next;

		while (copyThis != null) {
			copyTail.next = new Node(copyThis.storedItem);

			copyTail = copyTail.next;
			copyThis = copyThis.next;
		}

		itemCount += other.itemCount;

		if (startOfChain == null) {
			startOfChain = copyHead;
			return;
		}

		Node end = startOfChain;

		while (end.next != null) {
			end = end.next;
		}

		end.next = copyHead;
	}

	public ChainedList<E> addMarker(E match, E marker) {
		ChainedList<E> result = new ChainedList<E>();

		result.startOfChain = new Node(null); // add dummy node
		Node tail = result.startOfChain;

		Node nextMatch = startOfChain;

		while (nextMatch != null) {
			Node newNode = new Node(nextMatch.storedItem);

			if (nextMatch.storedItem.equals(match)) {
				Node markerNode = new Node(marker);

				tail.next = markerNode;
				tail = tail.next;

				result.itemCount++;
			}

			tail.next = newNode;
			tail = tail.next;

			result.itemCount++;

			nextMatch = nextMatch.next;
		}

		result.startOfChain = result.startOfChain.next; // remove dummy node

		return result;
	}

	private class Node {
		private E storedItem;
		private Node next;

		public Node(E item) {
			storedItem = item;
			next = null;
		}
	}

}
