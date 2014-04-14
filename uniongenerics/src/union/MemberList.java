package union;

public class MemberList<E> {
	private static final int STARTING_CAPACITY = 10;
	
	private E[] allWorkers;
	private int nextFreeToFill;

	public MemberList() {
		allWorkers = (E []) new Object[STARTING_CAPACITY];
		nextFreeToFill = 0;
	}

	public void add(E who) {
		if(nextFreeToFill == allWorkers.length) {
			expand();
		}
		
		allWorkers[nextFreeToFill] = who;
		nextFreeToFill++;
	}
	
	private void expand() {
		E[] newSpace = (E []) new Object[2 * allWorkers.length];
		
		for(int i = 0; i < allWorkers.length; i++) {
			newSpace[i] = allWorkers[i];
		}
		
		allWorkers = newSpace;
	}

	public E get(int position) {
		return allWorkers[position];
	}

	public int size() {
		return nextFreeToFill;
	}

	/*
	 * // This is the 1970's C programmer version. Ugh
	 * 
	 * public void remove(int p) {
	 * 
	 * for ( ; p <= nextFreeToFill - 2 ; p++) {
	 *  allWorkers[p] = allWorkers[p +1];
	 *  }
	 * 
	 * nextFreeToFill--;
	 *  }
	 */

	public void remove(int oneToRemove) {
		int oneToMove = oneToRemove + 1;
		int howMany = nextFreeToFill - oneToMove;

		for (int i = 0; i < howMany; i++) {
			allWorkers[oneToMove - 1] = allWorkers[oneToMove];
			oneToMove++;
		}

		nextFreeToFill--;
		allWorkers[nextFreeToFill] = null;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		for(int i = 0; i < nextFreeToFill; i++) {
			result += "";
			result += allWorkers[i].toString();
			result += " ]";
		}
		
		return result;
		
	}
}
