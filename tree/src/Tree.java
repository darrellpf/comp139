public class Tree<E extends Comparable<E>> {

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
}
