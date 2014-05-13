public class LinkedList<E> {
	private Node startOfChain;
	private int itemCount;

	LinkedList() {
		startOfChain = null;
		itemCount = 0;
	}

	public void add(E what) {
		Node aNode = new Node(what);
		
		aNode.next = startOfChain;
		startOfChain = aNode;

		itemCount++;
	}
	
	public void duoDuplicate() {
		Node copyFrom = startOfChain;
		
		for(int i = 0; i < itemCount; i++) {
			Node duplicate = new Node(copyFrom.payLoad);
			duplicate.next = copyFrom.next;
			copyFrom.next = duplicate;
			
			copyFrom = copyFrom.next; // advance past original
			copyFrom = copyFrom.next; // advance past inserted duplicate
			
			/* or
			 *  copyFrom = duplicate.next;
			 */
		}
		
		itemCount = 2 * itemCount;
		
	}
	
	/* The size and get methods weren't on the exam.
	 * They are there for unit testing.
	 */
	
	public int size() {
		return itemCount;
	}
	
	public E get(int position) {
		E itemToReturn = null;
		
		Node current = startOfChain;
		for(int i = 0; i < position; i++) {
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
