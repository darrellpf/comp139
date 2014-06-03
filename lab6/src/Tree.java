import java.util.Iterator;

public class Tree<E extends Comparable<E>> implements Iterable<E> {

	private TreeNode root;

	public Tree() {
		root = null;
	}

	public void add(E item) {
		TreeNode aNode = new TreeNode(item);

		if (root == null) {
			root = aNode;
			return;
		}

		addNodeInternal(root, aNode);

	}
	
	private void addNodeInternal(TreeNode anyRoot, TreeNode addNode) {

		int comparison = addNode.compareTo(anyRoot);
		
		if(comparison == 0) {
			return;
		}

		if (comparison < 0) {
			if(anyRoot.leftSide != null) {
				addNodeInternal(anyRoot.leftSide, addNode);
				return;
			}
			
			anyRoot.leftSide = addNode;
			
		} else { // > 0
			if(anyRoot.rightSide != null) {
				addNodeInternal(anyRoot.rightSide, addNode);
				return;
			}
			
			anyRoot.rightSide = addNode;
		}
	}
	
	public E search(E looksLike) {
		if(root == null) {
			return null;
		}
		
		E foundThing = searchInternal(root, new TreeNode(looksLike));
		return foundThing;
	}
	
	private E searchInternal(TreeNode root, TreeNode looksLike) {
		if(root == null) {
			return null;
		}
		
		int comparison = looksLike.compareTo(root);
		if(comparison == 0) {
			return root.item;
		}
		
		if(comparison < 0) {
			return searchInternal(root.leftSide, looksLike);
		} else {
			return searchInternal(root.rightSide, looksLike);
		}	
	}

	private class TreeNode {
		E item;
		TreeNode leftSide;
		TreeNode rightSide;

		public TreeNode(E inItem) {
			item = inItem;
			leftSide = null;
			rightSide = null;
		}

		public int compareTo(TreeNode other) {
			return item.compareTo(other.item);
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new TreeIterator();
	}
	
	private class TreeIterator implements Iterator<E> {
		private IteratorNode head;
		
		public TreeIterator() {
			head = new IteratorNode(null); // add dummy
			IteratorNode tail = head;
			
			makeIteratorList(root, tail);
			
			head = head.next; // remove dummy
		}

		@Override
		public boolean hasNext() {
			return head != null;
		}

		@Override
		public E next() {
			E item = head.item;
			
			head = head.next;
			
			return item;
		}
	}
	
	private IteratorNode makeIteratorList(TreeNode root, IteratorNode tail) {
		if(root == null) {
			return tail;
		}
		
		tail = makeIteratorList(root.leftSide, tail);
		
		tail.next = new IteratorNode(root.item);
		tail = tail.next;
		
		tail = makeIteratorList(root.rightSide, tail);
		
		return tail;
	}
	
	private class IteratorNode {
		E item;
		IteratorNode next;
		
		public IteratorNode(E inItem) {
			item = inItem;
			next = null;
		}
	}
}
