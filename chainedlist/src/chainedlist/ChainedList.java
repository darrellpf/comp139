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
		
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = newNode;
		itemCount++;
	}

	@Override
	public E get(int position) {
		Node current = startOfChain;

		for(int i = 0; i < position; i++) {
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
		Node current = startOfChain;
		
		if(oneToRemovePosition == 0) {
			startOfChain = startOfChain.next;
			itemCount--;
			return;
		}

		for(int i = 0; i < oneToRemovePosition - 1; i++) {
			current = current.next;		
		}
		
		Node oneBefore = current;
		Node oneToRemove = oneBefore.next;
		Node oneAfter = oneToRemove.next;
		
		oneBefore.next = oneAfter;
		itemCount--;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		for(Node current = startOfChain; current != null; current = current.next){
				result += current + " ";
		}
		
		return result;
	}
	
	/*@Override
	public String toString() {
		String result = "";
		
		Node current = startOfChain;
		
		while(current != null) {
			result += current + " ";
			current = current.next;
		}
		
		return result;
	}*/
	
/*	@Override
	public String toString() {
		String result = "";
		
		Node current = startOfChain;
		
		for(int i = 0; i < itemCount; i++) {
			result += current + " ";
			current = current.next;
		}
		
		
		return result;
	}*/

	private class Node {
		private E storedItem;
		private Node next;

		public Node(E item) {
			storedItem = item;
			next = null;
		}
		
		@Override
		public String toString() {
			return storedItem.toString();
		}
	}
	
	public Cursor getCursor() {
		return new Cursor();
	}
	
	public class Cursor<E> {
		private Node current;
		
		public Cursor() {
			current = startOfChain;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public E next() {
			E itemToReturn = (E)current.storedItem;
			current = current.next;
			return itemToReturn;
		}
	}
}
