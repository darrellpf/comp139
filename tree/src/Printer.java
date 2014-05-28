
public class Printer<E> implements Instruction<E> {
	int itemCount = 0;
	
	@Override
	public void execute(E what) {
		Worker who = (Worker) what;
		System.out.println(who.getFirstName());
		itemCount++;
	}

}
