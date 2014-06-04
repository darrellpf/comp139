package hashmap;

import java.lang.reflect.Array;

public class HashTable<K, V> {

	Node[] table;

	public HashTable() {
		table = (Node[]) Array.newInstance(Node.class, 10);
	}

	private int getTableSlot(K key) {
		int magic = Math.abs(key.hashCode());
		int tableSlot = magic % table.length;
		
		return tableSlot;
	}
	
	public void add(K key, V value) {
		remove(key);
		
		Pair aPair = new Pair(key, value);
		Node aNode = new Node(aPair);

		int tableSlot = getTableSlot(key);

		aNode.next = table[tableSlot];
		table[tableSlot] = aNode;
	}

	public V find(K key) {
		int tableSlot = getTableSlot(key);

		Node current = table[tableSlot];

		if (current == null) {
			return null;
		}

		while (current != null) {

			Pair aPair = current.storedItem;
			K pairKey = aPair.key;
			if (key.equals(pairKey)) {
				return aPair.value;
			}
			current = current.next;
		}
		
		return null;
	}
	
	public void remove(K key) {
		int tableSlot = getTableSlot(key);
		
		if(table[tableSlot] == null) {
			return;
		}
		
		if(key.equals(table[tableSlot].storedItem.key)) {
			table[tableSlot] = table[tableSlot].next;
			return;
		}
		
		Node previous =  table[tableSlot];
		Node current = previous.next;

		while (current != null) {

			Pair aPair = current.storedItem;
			K pairKey = aPair.key;
			if (key.equals(pairKey)) {
				Node oneAfter = current.next;
				previous.next = oneAfter;
				return;
			}
			
			current = current.next;
			previous = previous.next;
		}
		
		return;
	}
	
	public boolean containsValue(V value) {
		
		for(Node aNode : table) {
			if(aNode == null) {
				continue;
			}
			
			if(chainContainsValue(aNode, value) == true) {
				return true;
			}		
		}
		
		return false;
	}

	private boolean chainContainsValue(Node aNode, V value) {
		Node current = aNode;
		while(current != null) {
			Pair aPair = current.storedItem;
			if(value.equals(aPair.value)) {
				return true;
			}
			
			current = current.next;
		}
		
		return false;

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
