import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Driver {
	public static final String FILENAME = "bullies";

	public static void main(String[] args) {
		new Driver();
	}

	public Driver() {
		List<Bully> players = new ArrayList<>();

		Scanner input = null;

		try {
			input = new Scanner(new File(FILENAME));
		} catch (FileNotFoundException e) {
			System.out.println("Can't file " + FILENAME);
			System.exit(0);
		}

		while (input.hasNext()) {
			String name = input.next();
			int weight = input.nextInt();
			int money = input.nextInt();

			players.add(new Bully(name, weight, money));
		}

		List<Bully> result = BullyUtility.findWinners(players);
		System.out.println("Bullies who haven't been beaten");
		System.out.println();
		System.out.println("Name:\tWeight\tMoney\tOthers Beaten Up");
		for (Bully who : result) {
			System.out.println(	who.getName() + "\t" +
								who.getWeight() + "\t" +
								who.getLunchMoney() + "\t" +
								who.getPeoplePummeled()
								);
		}
		
		System.out.println();
		System.out.println("All participants");
		System.out.println();
		
		System.out.println("Name:\tWeight\tMoney\tOthers Beat Up");
		for (Bully who : players) {
			System.out.println(	who.getName() + "\t" +
								who.getWeight() + "\t" +
								who.getLunchMoney() + "\t" +
								who.getPeoplePummeled()
								);
		}
	}
}

