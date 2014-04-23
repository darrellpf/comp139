package union;

public class ObjectList<E> {
	private static final int STARTING_CAPACITY = 10;
	
	private E[] allItems;
	private int nextFreeToFill;

	public ObjectList() {
		allItems = (E []) new Object[STARTING_CAPACITY];
		nextFreeToFill = 0;
	}
	
	public ObjectList(ObjectList<E> otherList) {
		allItems = (E[]) new Object[otherList.allItems.length];

		for(int i = 0; i < otherList.nextFreeToFill; i++) {
			allItems[i] = otherList.allItems[i];
		}
		
		nextFreeToFill = otherList.nextFreeToFill;
	}

	public void add(E who) {
		if(nextFreeToFill == allItems.length) {
			expand();
		}
		
		allItems[nextFreeToFill] = who;
		nextFreeToFill++;
	}
	
	private void expand() {
		E[] newSpace = (E []) new Object[2 * allItems.length];
		
		for(int i = 0; i < allItems.length; i++) {
			newSpace[i] = allItems[i];
		}
		
		allItems = newSpace;
	}

	public E get(int position) {
		return allItems[position];
	}

	public int size() {
		return nextFreeToFill;
	}

	public void remove(int oneToRemove) {
		int oneToMove = oneToRemove + 1;
		int howMany = nextFreeToFill - oneToMove;

		for (int i = 0; i < howMany; i++) {
			allItems[oneToMove - 1] = allItems[oneToMove];
			oneToMove++;
		}

		nextFreeToFill--;
		allItems[nextFreeToFill] = null;
	}
	
	public void insertAtPosition(E what, int insertPosition) {
		if(nextFreeToFill == allItems.length) {
			expand();
		}
		
		int positionToMove = nextFreeToFill - 1;
		int itemsToMove = positionToMove - insertPosition + 1;
		
		for(int i = 0; i < itemsToMove; i++) {
			allItems[positionToMove + 1] = allItems[positionToMove];
			positionToMove--;
		}
		
		allItems[insertPosition] = what;
		nextFreeToFill++;
	}
	
	public boolean contains(E looksLike) {
		for(int i = 0; i < nextFreeToFill; i++) {
			if(looksLike.equals(allItems[i])) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		for(int i = 0; i < nextFreeToFill; i++) {
			result += "";
			result += allItems[i].toString();
			result += " ]";
		}
		
		return result;
		
	}
}
