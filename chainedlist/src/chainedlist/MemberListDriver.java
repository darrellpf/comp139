package chainedlist;

import java.util.Iterator;

public class MemberListDriver {

	public static void main(String[] args) {
		ChainedList<Worker> union = new ChainedList<Worker>();
		
		Worker fred = new Worker("Fred", "President");		
		union.add(fred);
		
		Worker joe = new Worker("Joe", "Vice");		
		union.add(joe);
		
		Worker sam = new Worker("Sam", "Cleaner");		
		union.add(sam);
		
		for(int i = 0; i < union.size(); i++) {
			Worker who = union.get(i);
			System.out.println(who.getFirstName());
		}
		
		fred = null;
		
		System.out.println();
		System.out.println("Removing joe");
		System.out.println();
		
		union.remove(1);
		for(int i = 0; i < union.size(); i++) {
			Worker who = union.get(i);
			System.out.println(who.getFirstName());
		}
		
		Iterator<Worker> current = union.iterator();
		while(current.hasNext()) {
			Worker who = current.next();
			System.out.println(who.getFirstName());
		}
		
		for(Worker who : union) {
			System.out.println(who.getFirstName());
		}
		
		GenericList<Frog> frogList = new MemberList<Frog>();
		
		frogList.add(new Frog("Kermit"));
//		frogList.add(sam);
		
		Frog aFrog = frogList.get(1);

	}

}
