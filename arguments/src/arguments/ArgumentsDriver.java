package arguments;

import java.util.HashMap;
import java.util.Map;

public class ArgumentsDriver {

	static String[][] defaults = { 
		{ "height", "20" },
		{ "size", "10" },
		{ "weight", "50" },
		{ "name", "" },
		};
	
	public static void main(String[] args) {
		new ArgumentsDriver();
	}
	
	public ArgumentsDriver() {
		String arguments = "siz=100 height=25 name=Joe";
		
		Map<String, String> nameTable = new HashMap<>();
		
		for(String [] row : defaults) {
			String value = row[1];
			String key = row[0];
			
			nameTable.put(key, value);
		}

		nameTable.put("name", "Joe");
		
		nameTable.put("siz", "2000");

		for(Map.Entry<String, String> anEntry : nameTable.entrySet()) {
			System.out.println(anEntry);
		}
		
	}

	
}
