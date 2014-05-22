package hashmap;

import java.lang.reflect.Array;

public class HashTable<K, V> {
	
	Node [] table;
	
	public HashTable() {
		table = (Node[]) Array.newInstance(Node.class, 10);
	}
	
	public void add(K key, V value) {
		Pair aPair = new Pair(key, value);
		Node aNode = new Node(aPair);
		
		int magic = key.hashCode();
		int tableSlot = magic % table.length;
		
		aNode.next = table[tableSlot];
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
