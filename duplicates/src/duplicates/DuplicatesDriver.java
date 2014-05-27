package duplicates;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DuplicatesDriver {
	
	Student [] allStudents = {
			new Student("Joe",		555123123),
			new Student("Pete",		123456789),
			new Student("Joseph",	555123123),
			new Student("Bob",		987654321),
			new Student("Jojo",		555123123),
			new Student("Bob",		111111111),
	};


	public static void main(String[] args) {
		
		new DuplicatesDriver();
	}
	
	public DuplicatesDriver() {
		Map<Student, Student> noDups = new HashMap<>();
		
		for(Student who : allStudents) {
			noDups.put(who, who);
		}
		
		for(Student who : noDups.values()) {
			System.out.println(who.getFirstName());
		}
		
		Map<Student, Integer> timesSeen = new LinkedHashMap<>();
		
		for(Student who : allStudents) {
			if(timesSeen.containsKey(who) == false) {
				timesSeen.put(who, 1);
				continue;
			}
			
			int count = timesSeen.get(who);
			count++;
			timesSeen.put(who, count);	
		}
		
		for(Map.Entry<Student, Integer> pair : timesSeen.entrySet()) {
			Student who = pair.getKey();
			int time = pair.getValue();
			
			System.out.println(who.getFirstName() + " " + time);
		}
	}
}