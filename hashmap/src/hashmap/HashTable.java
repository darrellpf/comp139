package hashmap;

import java.lang.reflect.Array;

public class HashTable<K, V> {

	Node[] table;

	public HashTable() {
		table = (Node[]) Array.newInstance(Node.class, 10);
	}

	public void add(K key, V value) {
		Pair aPair = new Pair(key, value);
		Node aNode = new Node(aPair);

		int magic = Math.abs(key.hashCode());
		int tableSlot = magic % table.length;

		aNode.next = table[tableSlot];
		table[tableSlot] = aNode;
	}

	public V find(K key) {
		int magic = Math.abs(key.hashCode());
		int tableSlot = magic % table.length;

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
