package union;

public class MemberList {
	private Worker[] allWorkers;
	private int nextFreeToFill;

	public MemberList() {
		allWorkers = new Worker[10];
		nextFreeToFill = 0;
	}

	public void add(Worker who) {
		allWorkers[nextFreeToFill] = who;
		nextFreeToFill++;
	}

	public Worker get(int position) {
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
	}
}
