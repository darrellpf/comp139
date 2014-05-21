import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

public class BullyUtility {
	public static List<Bully> findWinners(List<Bully> players) {
		Deque<Bully> unbeatenBullies = new LinkedList<Bully>();

		for (Bully nextChallenger : players) {
			challenge(unbeatenBullies, nextChallenger);
		}

		List<Bully> rightOrder = new ArrayList<>(unbeatenBullies);
		Collections.reverse(rightOrder);
		return rightOrder;
	}

	public static void challenge(Deque<Bully> unbeatenBullies, Bully me) {

		me.addToPeoplePummeled(1);

		int originalSize = unbeatenBullies.size();

		for (int i = 0; i < originalSize; i++) {

			Bully nextUnbeatenBully = unbeatenBullies.peek();
			
			if (nextUnbeatenBully.compareTo(me) > 0) {
				unbeatenBullies.push(me);
				return;
			}

			int extraMoney = nextUnbeatenBully.getLunchMoney();
			me.addToLunchMoney(extraMoney);

			int canBeatThoseHeBeat = nextUnbeatenBully.getPeoplePummeled();
			me.addToPeoplePummeled(canBeatThoseHeBeat);

			nextUnbeatenBully.loseLunchMoney();

			unbeatenBullies.pop();
		}

		unbeatenBullies.push(me);
	}
}
