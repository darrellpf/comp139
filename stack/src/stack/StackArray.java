package stack;

public class StackArray<E> implements StackInterface<E>{
	
	private E [] allItems;
	private int nextFreeToFill;
	
	public StackArray() {
		allItems = (E []) new Object[10];
		nextFreeToFill = 0;
	}

	@Override
	public void push(E thing) {
		allItems[nextFreeToFill] = thing;
		nextFreeToFill++;
	}

	@Override
	public E pop() {
		int lastFilledSlot = nextFreeToFill - 1;
		E itemToReturn = allItems[lastFilledSlot];
		nextFreeToFill--;
		allItems[nextFreeToFill] = null;
		
		return itemToReturn;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
