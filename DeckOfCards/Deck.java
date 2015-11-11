import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private List<Card> cardsInDeck;
	private List<Card> cardsDealt;

	//Create the Deck which includes all the cards from 2->A
	public Deck() {
		cardsInDeck = new ArrayList<Card>();
		cardsDealt = new ArrayList<Card>();

		for (int i = 2; i <= 10; i++) {
			String faceCard = Integer.toString(i);
			cardsInDeck.add(new Card(faceCard, 'S'));
			cardsInDeck.add(new Card(faceCard, 'C'));
			cardsInDeck.add(new Card(faceCard, 'D'));
			cardsInDeck.add(new Card(faceCard, 'H'));
		}
		cardsInDeck.add(new Card("J", 'S'));
		cardsInDeck.add(new Card("J", 'C'));
		cardsInDeck.add(new Card("J", 'D'));
		cardsInDeck.add(new Card("J", 'H'));
		cardsInDeck.add(new Card("Q", 'S'));
		cardsInDeck.add(new Card("Q", 'C'));
		cardsInDeck.add(new Card("Q", 'D'));
		cardsInDeck.add(new Card("Q", 'H'));
		cardsInDeck.add(new Card("K", 'S'));
		cardsInDeck.add(new Card("K", 'C'));
		cardsInDeck.add(new Card("K", 'D'));
		cardsInDeck.add(new Card("K", 'H'));
		cardsInDeck.add(new Card("A", 'S'));
		cardsInDeck.add(new Card("A", 'C'));
		cardsInDeck.add(new Card("A", 'D'));
		cardsInDeck.add(new Card("A", 'H'));
	}

	//Shuffle the cards by retrieving all the cards dealt back into the deck
	//then calling shuffle on all the cards in the deck
	public void shuffle() {
		cardsInDeck.addAll(cardsDealt);
		cardsDealt.clear();

		Collections.shuffle(cardsInDeck);
	}

	//Get next card by getting the 0th indexed one and if there are no cards
	//throw an error showing that there are no more cards.
	public Card getNextCard() {
		if (cardsInDeck.size() != 0) {
			Card tempCard = cardsInDeck.remove(0);
			cardsDealt.add(tempCard);
			return tempCard;
		}

		throw new RuntimeException("There are no cards in the deck.");
	}

	public static void main(String[] args) {
		Deck deck = new Deck();

		System.out.println("Deck in order");
		for (int i = 0; i < 52; i++) {
			Card tempCard = deck.getNextCard();
			System.out.println(tempCard.getFaceCard() + tempCard.getSuit());
		}

		System.out.println("\n\n");
		deck.shuffle();
		System.out.println("Shuffled the deck");

		for (int i = 0; i < 52; i++) {
			Card tempCard = deck.getNextCard();
			System.out.println(tempCard.getFaceCard() + tempCard.getSuit());
		}

	}

}

