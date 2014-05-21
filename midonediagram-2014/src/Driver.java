
public class Driver {
	public static void main(String[] args) {
		Yup<Dog> stat = new Yup<>(4); // address 100, array 200
		
		Dog x = new Dog(12, 9);		// address 300
		Dog y = new Dog(16, 4);		// address 400
		
		stat.add(x);
		stat.add(new Dog(3, 4));		// address 500
		stat.add(y);
		
		Dog result = stat.move(2, new Dog(1, 1)); // address 1600
		
		Plan<Dog> uber = new Plan<>(); // address 600
		
		uber.add(x);						// node address 700
		uber.add(new Dog(21, 44));			// address 800, node address 900
		
		uber.draw(y);						// node address 1000
		uber.draw(new Dog(33, 22));			// address 1100, node address 1200
		
		uber.stuff(new Dog(5, 7));			// address 1300
	}
}
