import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapListSample {

	public static void main(String[] args) {

		Worker[] workers = {
				new Worker("fred", 23),
				new Worker("sam", 17),
				new Worker("joe", 40),
				new Worker("pete", 29),
				new Worker("bob", 18),
				};

		Map<String, List<Worker>> result = new HashMap<>();
		List<Worker> young = new ArrayList<>();
		List<Worker> old = new ArrayList<>();

		result.put("young", young);
		result.put("old", old);

		for (Worker who : workers) {
			if (who.getAge() < 30) {
				List<Worker> theList = result.get("young");
				theList.add(who);
				continue;
			}

			List<Worker> theList = result.get("old");
			theList.add(who);
		}
		
		for(Worker who : young) {
			System.out.println(who.getFirstName());
		}
	}
}
