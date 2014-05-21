
public class Yup<E> {
	private E[] contents;
	private int size;
	private int max;
	
	public Yup(int inMax) {
		contents = (E []) new Object[inMax];
		size = 0;
		max = inMax;
	}
	
	public void add(E what) {
		contents[size] = what;
		size++;
	}
	
	public E get(int where) {
		return contents[where];
	}
	
	public E move(int where, E gone) {
		E item = contents[where];
		
		contents[where + 1] = contents[where];
		contents[where] = gone;

		return item;
	}
}
