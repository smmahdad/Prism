public class Card implements Comparable {
	private Character suit;
	private String faceCard;

	public Card(String faceCard, Character suit) {
		this.suit = suit;
		this.faceCard = faceCard;
	}

	void setSuit(Character suit) {
		this.suit = suit;
	}

	Character getSuit() {
		return suit;
	}

	void setFaceCard(String faceCard) {
		this.faceCard = faceCard;
	}

	String getFaceCard() {
		return faceCard;
	}

	//Way to compare cards against each other, first off of their face cards
	//then by their suits if they are equal faces
	@Override
	public int compareTo(Object o) {
		Card theirCard = (Card) o;
		int cardOneFace = getFaceValue(getFaceCard());
		int cardTwoFace = theirCard.getFaceValue(theirCard.getFaceCard());
		int difference = cardOneFace - cardTwoFace;

		if (difference != 0) {
			return difference;
		}
		int cardOneSuit = getSuitValue(getSuit());
		int cardTwoSuit = theirCard.getSuitValue(theirCard.getSuit());
		return cardOneSuit - cardTwoSuit;
	}

	//Our default assignment of values and hierarchy for the suits
	protected int getSuitValue(Character suit) {
		switch (suit) {
			case 'H':
				return 3;
			case 'D':
				return 2;
			case 'C':
				return 1;
			case 'S':
				return 0;
			default:
				return -1;
		}
	}

	//Our default assignment of values and hierarchy for the facecard
	protected int getFaceValue(String faceCard) {
		switch (faceCard) {
			case "2":
				return 2;
			case "3":
				return 3;
			case "4":
				return 4;
			case "5":
				return 5;
			case "6":
				return 6;
			case "7":
				return 7;
			case "8":
				return 8;
			case "9":
				return 9;
			case "10":
				return 10;
			case "J":
				return 11;
			case "Q":
				return 12;
			case "K":
				return 13;
			case "A":
				return 14;
			default:
				return -1;
			
		}
	}

}


