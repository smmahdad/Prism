Design Decision:

I decided to split the Deck framework into two components. Deck and Card.

Since each Deck has multiple cards I chose to represent this as an ArrayList for the ability to have random access. Also, since we are going to deal out cards from our deck, I chose to have another deck of cards to keep track of the ones that have been dealt. This allows us to simply add back the dealt cards to the deck list when we want to shuffle the cards. For shuffling, I chose to use Java's standard's shuffle method as it will shuffle in a random order as was requested.

As for the Card class, I chose to have each card hold their suit represented as a character ('H' for heart, etc.) and hold their Card Value as a string ("2" is 2). This allowed me to create a new function that will take these two representations and assign to them a vlue when we compare cards. I went down this route so if we want to implement new card games, we only have to extend the Card class and override these two functions to the specific card value system. So instead of having Aces being the highiest card, we can make them the lowest by overriding the getFaceValue function.


Resolving Ambiguity:

As mentioned above, the ambiguity of what values to give the cards made me choose to assign the original values in a way I am familiar with (2's as lowest cards and Aces as highest), but then allowed for children's of the Card class to override the methods. If I had more time I would make an abstract card class which would further allow extensibility of these attributes. 


Framework Working?

I was a bit crunched on time so I couldn't do the full TDD process, so instead I wrote in main (which I deleted after) printing all cards in order I created them, then shuffling them to ensure they were shuffled properly. Then I checked to see if I chose a card, then shuffled, that the card I chose would be put back into the deck (which it did). I did an informal TDD instead of JUnits. 


How to Run:
Know that I couldn't get the makefile to work as well (didn't have time to download it and make a script for it). Instead, if you have java, all you have to do is go into this directory and type

	javac *.java
	java Deck

Then you will have the output of every card in order before the shuffle and then after.