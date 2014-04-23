package stack;

public interface StackInterface<E> {
	public void push(E thing);
	public E pop();
	
	public E peek();
	
	public int size();
}
