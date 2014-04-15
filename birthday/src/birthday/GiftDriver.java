package birthday;

public class GiftDriver {

	public static void main(String[] args) {
		GiftLocation startOfChain;

		GiftLocation parents = new GiftLocation("Socks");

		startOfChain = parents;

		GiftLocation uncle = new GiftLocation("Peanuts");

		parents.setNextLocation(uncle);

		GiftLocation aunt = new GiftLocation("Chocolate bar");

		uncle.setNextLocation(aunt);

		GiftLocation current = startOfChain;

		while (current != null) {

			System.out.println(current.getGift());
			current = current.getNext();
		}

		current = startOfChain;

		GiftLocation granny = new GiftLocation("Harley");

		while (current.getNext() != null) {

			// System.out.println(current.getGift());
			current = current.getNext();
		}

		current.setNextLocation(granny);

		current = startOfChain;

		while (current != null) {

			System.out.println(current.getGift());
			current = current.getNext();
		}

	}

}
