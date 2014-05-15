public class LinkedList<E> {
	private Node startOfChain;
	private int itemCount;

	public LinkedList() {
		startOfChain = null;
		itemCount = 0;
	}

	public void add(E what) {
		Node aNode = new Node(what);

		aNode.next = startOfChain;
		startOfChain = aNode;

		itemCount++;
	}

	public void mirror() {
		if (itemCount == 0) {
			return;
		}

		Node copyStart = null;

		Node toDupe = startOfChain;

		while (toDupe != null) {
			Node copyNode = new Node(toDupe.payLoad);

			copyNode.next = copyStart;
			copyStart = copyNode;

			toDupe = toDupe.next;
		}

		Node end = startOfChain;
		while (end.next != null) {
			end = end.next;
		}

		end.next = copyStart;
		itemCount *= 2;
	}

	public void mirror2() {
		if (itemCount == 0) {
			return;
		}

		Node copyStart = null;

		Node toDupe = startOfChain;

	
		while (toDupe.next != null) {
			Node copyNode = new Node(toDupe.payLoad);
			
			copyNode.next = copyStart;
			copyStart = copyNode;

			toDupe = toDupe.next;
		}

		Node last = new Node(toDupe.payLoad);
		last.next = copyStart;
		copyStart = last;
	
		toDupe.next = copyStart;

		itemCount *= 2;
	}

	/*
	 * The size and get methods weren't on the exam. They are there for unit
	 * testing.
	 */

	public int size() {
		return itemCount;
	}

	public E get(int position) {
		E itemToReturn = null;

		Node current = startOfChain;
		for (int i = 0; i < position; i++) {
			current = current.next;
		}

		itemToReturn = current.payLoad;
		return itemToReturn;
	}

	class Node {
		E payLoad;
		Node next;

		Node(E inPayLoad) {
			payLoad = inPayLoad;
			next = null;
		}
	}
}
