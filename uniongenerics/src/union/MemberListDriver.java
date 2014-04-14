package union;

public class MemberListDriver {

	public static void main(String[] args) {
		MemberList<Worker> union = new MemberList<Worker>();
		
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
		
		MemberList<Frog> frogList = new MemberList<Frog>();
		
		frogList.add(new Frog("Kermit"));
//		frogList.add(sam);
		
		Frog aFrog = frogList.get(1);

	}

}
