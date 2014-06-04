package deckdeal;

import java.util.*;

public class Deal {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: Deal hands cards");
			return;
		}

		int hands = Integer.parseInt(args[0]);
		int cardsPerHand = Integer.parseInt(args[1]);

		List<String> deck = new ArrayList<>();

		buildDeck(deck);
		Collections.shuffle(deck);

		int cardsNeeded = hands * cardsPerHand;

		if (cardsNeeded > deck.size()) {
			System.out.println("Not enough cards.");
			return;
		}

		for (int i = 0; i < hands; i++) {
			List<String> hand = dealHand(deck, cardsPerHand);
			System.out.println(hand);
		}
	}

	public static void buildDeck(List<String> deck) {
		String[] suit = new String[] { "spades", "hearts", "diamonds", "clubs" };
		String[] rank = new String[] { "ace", "2", "3", "4", "5", "6", "7",
				"8", "9", "10", "jack", "queen", "king" };

		for (int suitIndex = 0; suitIndex < suit.length; suitIndex++) {
			for (int rankIndex = 0; rankIndex < rank.length; rankIndex++) {
				deck.add(rank[rankIndex] + " of " + suit[suitIndex]);
			}
		}
	}

	public static <E> List<E> dealHand(List<E> deck, int cardsInHand) {
		List<E> handView = deck.subList(0, cardsInHand);
		List<E> hand = new ArrayList<E>(handView);
		handView.clear();
		return hand;
	}
}