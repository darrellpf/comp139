package hashmap;

public class HashTable<K, V> {
	
	Node [] table;
	
	public HashTable() {
		table = (Node []) new Object[100];
	}
	
	public void add(K key, V value) {
		Pair aPair = new Pair(key, value);
		Node aNode = new Node(aPair);
		
		int magic = key.hashCode();
		int tableSlot = magic % table.length;
		
		table[tableSlot] = aNode;
	}
	
	public V find(K key) {
		int magic = key.hashCode();
		int tableSlot = magic % table.length;
		
		Node aNode = table[tableSlot];
		Pair aPair = aNode.storedItem;
		
		V value = aPair.value;
		
		return value;

	}
	
	private class Pair {
		K key;
		V value;
		
		public Pair(K aKey, V aValue) {
			key = aKey;
			value = aValue;
		}
	}
	
	private class Node {
		private Pair storedItem;
		private Node next;

		public Node(Pair item) {
			storedItem = item;
			next = null;
		}
	}

}
