
public class Contain<E> {
	
	private Node head;
	private int count;

	public Contain() {
		head = null;
		count = 0;
	}
	
	public void add(E what) {
		Node box = new Node(what);
		
		box.next = head;
		head = box;
		count++;
	}
	
	public void redo(E what) {
		Node box = new Node(what);
		Node cur = head;
		for(int i = 0; i < count - 1; i++) {
			cur = cur.next;
		}
		cur.next = box;
		count++;
	}
	
	class Node {
		E item;
		Node next;
		
		Node(E what) {
			item = what;
		}
	}
}
