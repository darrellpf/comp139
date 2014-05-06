

public class QueueLinked<E> implements QueueInterface<E> {
	
	private Node head;
	private Node tail;
	private int size;
	
	public QueueLinked() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public void enqueue(E item) {
		Node nextNode = new Node(item);
		
		if(size == 0) {
			head = nextNode;
			tail = nextNode;
			size = 1;
			return;
		}
		
		tail.next = nextNode;
		tail = tail.next;
		
		size++;
	}

	@Override
	public E dequeue() {
		E item = head.storedItem;
		
		head = head.next;
		size--;
		
		return item;
	}

	@Override
	public E peekFirst() {
		E item = head.storedItem;
		return item;
	}

	@Override
	public E peekLast() {
		E item = tail.storedItem;
		return item;
	}

	@Override
	public int size() {
		return size;
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
