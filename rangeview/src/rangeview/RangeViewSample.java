package rangeview;

import java.util.Arrays;
import java.util.List;

public class RangeViewSample {
	
	Person [] nameData = {
			new Person("a"),
			new Person("b"),
			new Person("c"),
			new Person("d"),
			new Person("e"),
			new Person("g"),
			};

	public static void main(String[] args) {
		new RangeViewSample();
	}
	
	public RangeViewSample() {
		List<Person> names = Arrays.asList(nameData);
		
		// Can't change a view
		// names.add(new Person("f"));
		
		names.set(5, new Person("f"));
		
		changeRange(names, 2, 4, "x");
		
		System.out.println(names);
		
		List<Person> nameRange = names.subList(2, 4);
		
		for(Person who : nameRange) {
			who.setName("y");
		}
		
		System.out.println(names);
	}
	
	private void changeRange(List<Person> names, int startPosition, int endPosition, String value) {
		for(int i = startPosition; i < endPosition; i++) {
			Person who = names.get(i);
			who.setName(value);
		}
	}

}
