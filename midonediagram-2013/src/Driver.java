
public class Driver {
	public static void main(String[] args) {
		Hold<Bag> flub = new Hold<Bag>(); // address 100, array 200
		
		Bag x = new Bag(-3, -5);		// address 300
		Bag y = new Bag(20, 10);		// address 400
		
		flub.add(x);
		flub.add(new Bag(3, 4));		// address 500
		flub.add(y);
		
		Bag result = flub.move();
		
		Contain<Bag> into = new Contain<Bag>(); // address 600
		
		into.add(x);						// node address 700
		into.add(new Bag(21, 44));			// address 800, node address 900
		into.redo(y);						// node address 1000
		into.redo(new Bag(33, 22));			// address 1100, node address 1200
		
		x.incOut();
	}
}
