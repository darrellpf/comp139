package chainedlist;

public interface GenericList<E> {

	public void add(E who);

	public E get(int position);

	public int size();

	public void remove(int oneToRemove);

}