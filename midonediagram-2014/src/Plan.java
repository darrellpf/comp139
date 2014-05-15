
public class Plan<E> {
	
	private Node head;

	public Plan() {
		head = null;
	}
	
	public void add(E what) {
		Node box = new Node(what);
		
		if(head == null) {
			head = box;
			return;
		}
		
		head.next = box;
	}
	
	public void draw(E what) {
		Node box = new Node(what);
		Node git = head;
		
		while(git.next != null) {
			git = git.next;
		}
		
		git.next = box;
	}
	
	public void stuff(E what) {
		head.item = what;
	}
	
	private class Node {
		E item;
		Node next;
		
		Node(E what) {
			item = what;
			next = null;
		}
	}
}
