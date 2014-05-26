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
	
	static String[][] processedArguments = { 
		{ "siz", "10" },
		{ "height", "20" },
		{ "name", "Joe" },
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
		
		// The arguments string has somehow been processed.

		for(String [] row : processedArguments) {
			String value = row[1];
			String key = row[0];
			
			if(nameTable.containsKey(key) == false) {
				System.out.println("Invalid argument: " + key);
				continue;
			}
			
			nameTable.put(key, value);
			
		}

		for(Map.Entry<String, String> anEntry : nameTable.entrySet()) {
			System.out.println(anEntry);
		}
		
	}

	
}
