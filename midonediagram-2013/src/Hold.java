
public class Hold<E> {
	private E[] stuff;
	private int size;
	
	public Hold() {
		stuff = (E []) new Object[5];
		size = 4;
	}
	
	public void add(E what) {
		stuff[size] = what;
		size--;
	}
	
	public E get(int position) {
		return stuff[position];
	}
	
	public E move() {
		int start = stuff.length - 1;
		E item = stuff[start];
		for(int i = start; i > size; i--) {
			stuff[i] = stuff[i - 1];
		}
		
		size++;
		return item;
	}
}
