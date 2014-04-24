package stack;

import java.util.ArrayList;

public class StackArrayList<E> implements StackInterface<E> {

	private ArrayList<E> allItems;
	
	public StackArrayList() {
		allItems = new ArrayList<E>();
	}
	
	@Override
	public void push(E thing) {
		allItems.add(thing);
	}

	@Override
	public E pop() {
		int endItemPosition = allItems.size() - 1;
		E item = allItems.get(endItemPosition);
		allItems.remove(endItemPosition);
		return item;
	}

	@Override
	public E peek() {
		int endItemPosition = allItems.size() - 1;
		E item = allItems.get(endItemPosition);
		return item;
	}

	@Override
	public int size() {
		return allItems.size();
	}

}
