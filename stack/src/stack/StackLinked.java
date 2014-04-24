package stack;


public class StackLinked<E> implements StackInterface<E> {
	
	private Node startOfChain;
	private int itemCount;
	
	public StackLinked() {
		startOfChain = null;
		itemCount = 0;
	}

	@Override
	public void push(E thing) {
		Node newNode = new Node(thing);
		newNode.next = startOfChain;
		startOfChain = newNode;
		itemCount++;
	}

	@Override
	public E pop() {
		E item = startOfChain.storedItem;		
		startOfChain = startOfChain.next;
		
		itemCount--;
		
		return item;
	}

	@Override
	public E peek() {
		E item = startOfChain.storedItem;				
		return item;
	}

	@Override
	public int size() {

		return itemCount;
	}
	
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

}
