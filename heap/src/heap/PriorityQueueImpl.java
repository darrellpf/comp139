package heap;

import java.util.Iterator;

public class PriorityQueueImpl<E extends Object & Comparable<E>> implements
		PriorityQueue<E> {
	private E[] allItems;
	private int nextEmptySlot;

	public PriorityQueueImpl() {
		allItems = (E[]) new Object[64];
		nextEmptySlot = 0;
	}

	@Override
	public void add(E item) {
		allItems[nextEmptySlot] = item;
		nextEmptySlot++;

		workYourWayUp(nextEmptySlot - 1);

	}

	private void workYourWayUp(int currentPosition) {
		while (currentPosition != 0) {
			int parentPosition = getParentPosition(currentPosition);

			E me = allItems[currentPosition];
			E parent = allItems[parentPosition];

			if (parent.compareTo(me) < 0) {
				return;
			}

			swap(allItems, currentPosition, parentPosition);

			currentPosition = parentPosition;
		}
	}

	private void swap(E[] allItems, int positionA, int positionB) {
		E temp = allItems[positionA];
		allItems[positionA] = allItems[positionB];
		allItems[positionB] = temp;
	}

	int getParentPosition(int currentPosition) {
		return (currentPosition - 1) / 2;
	}

	@Override
	public E remove() {
		E itemToReturn = allItems[0];

		allItems[0] = allItems[nextEmptySlot - 1];
		allItems[nextEmptySlot - 1] = null;
		nextEmptySlot--;

		workYourWayDown(0);

		return itemToReturn;
	}

	private void workYourWayDown(int currentPosition) {
		while (currentPosition < (nextEmptySlot / 2)) {
			int positionToExchange = getSmallestChildPosition(currentPosition);

			E me = allItems[currentPosition];
			E smallerChild = allItems[positionToExchange];

			if (me.compareTo(smallerChild) < 0) {
				return;
			}

			swap(allItems, currentPosition, positionToExchange);
			currentPosition = positionToExchange;
		}
	}

	private int getSmallestChildPosition(int currentPosition) {
		int leftChildPosition = getLeftChildPosition(currentPosition);
		int rightChildPosition = getRightChildPosition(currentPosition);

		E leftChild = allItems[leftChildPosition];
		E rightChild = allItems[rightChildPosition];

		if (rightChild == null) {
			return leftChildPosition;
		}

		int smallestPosition = leftChildPosition;
		if (rightChild.compareTo(leftChild) < 0) {
			smallestPosition = rightChildPosition;
		}

		return smallestPosition;
	}

	public int getLeftChildPosition(int currentPosition) {
		return (currentPosition * 2) + 1;
	}

	public int getRightChildPosition(int currentPosition) {
		return (currentPosition * 2) + 2;
	}

	@Override
	public int size() {

		return nextEmptySlot;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int nextItemPosition = 0;

			@Override
			public boolean hasNext() {
				return nextItemPosition < nextEmptySlot;
			}

			@Override
			public E next() {
				E item = allItems[nextItemPosition];
				nextItemPosition++;
				return item;
			}

		};
	}

}
