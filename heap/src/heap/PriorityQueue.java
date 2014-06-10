package heap;

public interface PriorityQueue<E extends Comparable<E>> extends Iterable<E> {
	public void add(E item);

	public E remove();

	public int size();
}
