
public class QueueArray<E> implements QueueInterface<E> {
	private E []  items;
	private int nextEmptyPosition;
	private int firstFullPosition;
	private int itemCount;
	
	public QueueArray() {
		items = (E []) new Object[10];
		nextEmptyPosition = 0;
		firstFullPosition = 0;
		itemCount = 0;
	}

	@Override
	public void enqueue(E item) {

		items[nextEmptyPosition] = item;
		nextEmptyPosition = wrapAround(nextEmptyPosition);
		
		itemCount++;
		
	}
	
	private int wrapAround(int position) {
		position++;
		if(position >= items.length) {
			position = 0;
		}
		
		return position;
	}
	@Override
	public E dequeue() {
		E returnValue = items[firstFullPosition];
		
		firstFullPosition = wrapAround(firstFullPosition);
		itemCount--;
		
		return returnValue;
	}

	@Override
	public int size() {
		return itemCount;
	}

	@Override
	public E peekFirst() {
		return items[firstFullPosition];
	}

	@Override
	public E peekLast() {
		return items[nextEmptyPosition - 1];
	}

}
