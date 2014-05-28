import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Tree<E extends Comparable<E>> implements Iterable<E> {

	private TreeNode root;
	private Comparator<E> comp;

	public Tree() {
		root = null;
		comp = new Comparator<E>() {
			public int compare(E a, E b) {
				return a.compareTo(b);
			}
		};
		
	}
	
	public Tree(Comparator<E> inComparator) {
		root = null;
		comp = inComparator;
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

		int comparison = comp.compare(addNode.item, anyRoot.item);
		
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
	
	public void forEach(Instruction<E> doStuff) {
		
		forEachInternal(doStuff, root);
	}
	
	private void forEachInternal(Instruction<E> doStuff, TreeNode aNode) {
		if(aNode == null) {
			return;
		}
		
		forEachInternal(doStuff, aNode.leftSide);
		doStuff.execute(aNode.item);
		forEachInternal(doStuff, aNode.rightSide);
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
		
		int comparison = comp.compare(root.item, looksLike.item);
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
		List<E> allItems = new ArrayList<>();
		
		makeList(root, allItems);
		
		return allItems.iterator();
	}
	
	private void makeList(TreeNode root, List<E> allItems) {
		if(root == null) {
			return;
		}
		
		makeList(root.leftSide, allItems);
		allItems.add(root.item);
		makeList(root.rightSide, allItems);
	}
}
