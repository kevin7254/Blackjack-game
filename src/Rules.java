import java.util.Scanner;

public class Rules {

    private Deck playerDeck;
    private Deck playingDeck;
    private Deck dealerDeck;
    Deck tempDeck = new Deck();

    boolean endRound = false;

    public Rules(Deck playerDeck, Deck playingDeck, Deck dealerDeck) {
        this.playerDeck = playerDeck;
        this.playingDeck = playingDeck;
        this.dealerDeck = dealerDeck;
    }

    public void hand(Scanner scanner, Deck deck, String str) { //TODO: fixa så metoden inte behöver "kopiera" kod
        System.out.println("\nHand " + str + " : Would you like to (H) Hit or (S) Stand?");
        String response = scanner.nextLine();
        if (response.equals("H") || response.equals("h")) {
            deck.draw(playingDeck);
            System.out.println("\nYou drew: " + deck.getCard(deck.deckSize() - 1).toString());
            System.out.println("\nYour hand:");
            System.out.println(deck.toString());

            if (deck.cardsValue() > 21) {
                System.out.println("Bust. You got: " + deck.cardsValue());
                endRound = true;
            }
        }
        if (response.equals("S") || response.equals("s")) {
            System.out.println("You stand.");
        }

    }


    public void split(Scanner scanner) {
        System.out.println("Would you like to split? Y/N");
        String response = scanner.nextLine();
        if (response.equals("Y") || response.equals("y")) {
            tempDeck.draw(playingDeck);
            tempDeck.draw(playingDeck);

            /**
             * Pulls one card from the tempDeck into playerDeck, then the same for playerDeck.
             * Ex. ACE of Diamonds - ACE of Spades -> <- Three of Hearts - Five of Spades TO
             *     ACE of Diamonds - Three of Hearts ---- ACE of Spades - Five of Spades
             */

            playerDeck.draw(tempDeck);
            tempDeck.draw(playerDeck);


            System.out.println("\nHand one: " + tempDeck.toString() + "(Value: " + tempDeck.cardsValue() + ")");
            System.out.println("\nHand two: " + playerDeck.toString() + "(Value: " + playerDeck.cardsValue() + ")");

            hand(scanner, tempDeck, "one");
            hand(scanner, playerDeck, "two");

            System.out.println("\nDealer cards: " + dealerDeck.toString());

            if (dealerDeck.cardsValue() > tempDeck.cardsValue() && !endRound) {
                System.out.println("\nDealer wins against hand one.");
                endRound = true;

            }
            if (dealerDeck.cardsValue() > playerDeck.cardsValue() && !endRound) {
                System.out.println("\nDealer wins against hand two.");
                endRound = true;

            }
            /*
              Dealer draws at 16. Stands at 17.

             */
            while (dealerDeck.cardsValue() < 17 && !endRound) {
                dealerDeck.draw(playingDeck);
                System.out.println("\nDealer draws: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
            }

            System.out.println("\nDealers hand is valued at " + dealerDeck.cardsValue());

            if ((dealerDeck.cardsValue() > 21) && !endRound) {
                System.out.println("\nDealer busts! You win both hands!");
                endRound = true;
            }

            if ((tempDeck.cardsValue() == dealerDeck.cardsValue()) && !endRound) {
                System.out.println("\nHand one: Push");
                endRound = true;
            }
            if ((playerDeck.cardsValue() == dealerDeck.cardsValue()) && !endRound) {
                System.out.println("\nHand two: Push");
                endRound = true;
            }

            if ((tempDeck.cardsValue() > dealerDeck.cardsValue() && !endRound)) {
                System.out.println("\nYou win hand one!");
            } else if (!endRound) {
                System.out.println("\nYou lose hand one.");
            }
            if ((playerDeck.cardsValue() > dealerDeck.cardsValue() && !endRound)) {
                System.out.println("\nYou win hand two!");
            } else if (!endRound) {
                System.out.println("\nYou lose hand two.");
            }

        }
    }
}