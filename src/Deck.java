import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Kevin Nilsson
 * @since 05/15/2019
 */
public class Deck {

    private ArrayList<Card> cards;

    private int numDecks;

    private Value value;

    boolean shuffled;

    public Deck() {
        this(1, true);
    }

    /**
     * @param numDecks Antalet kortlekar i spelet.
     * @param shuffled Om kortleken ska vara blandad eller inte.
     */

    public Deck(int numDecks, boolean shuffled) {

        this.numDecks = numDecks;
        this.cards = new ArrayList<Card>();
        this.shuffled = shuffled;

    }

    /**
     * En metod som går igenom alla 4 suits och sedan alla 13 values. (4*13= 52)
     */

    public void createFullDeck() {
        for (int i = 0; i < numDecks; i++) {
            for (Suit cardSuit : Suit.values()) {
                for (Value cardValue : Value.values()) {
                    this.cards.add(new Card(cardSuit, cardValue));
                }
            }
        }
        if (shuffled) {
            Collections.shuffle(cards);
        }
    }

    public String toString() {
        String cardListOutput = "";
        for (Card aCard : this.cards) {
            cardListOutput += "\n" + " " + aCard.toString();
        }
        return cardListOutput;

    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }

    public Card removeCard(int i) {
        return this.cards.remove(i);
    }

    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }

    public void draw(Deck comingFrom) {
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);

    }

    public int deckSize() {
        return this.cards.size();
    }

    public void moveAllToDeck(Deck moveTo) {
        int thisDeckSize = this.cards.size();

        for (int i = 0; i < thisDeckSize; i++) {
            moveTo.addCard(this.getCard(i));
        }

        for (int i = 0; i < thisDeckSize; i++) {
            this.removeCard(0);
        }

    }

    public int cardsValue() {
        int totalValue = 0;
        int aces = 0;

        for (Card playerCard : this.cards) {
            switch (playerCard.getValue()) {
                case TVÅ:
                    totalValue += 2;
                    break;
                case TRE:
                    totalValue += 3;
                    break;
                case FYRA:
                    totalValue += 4;
                    break;
                case FEM:
                    totalValue += 5;
                    break;
                case SEX:
                    totalValue += 6;
                    break;
                case SJU:
                    totalValue += 7;
                    break;
                case ÅTTA:
                    totalValue += 8;
                    break;
                case NIO:
                    totalValue += 9;
                    break;
                case TIO:
                    totalValue += 10;
                    break;
                case KNEKT:
                    totalValue += 10;
                    break;
                case DAM:
                    totalValue += 10;
                    break;
                case KUNG:
                    totalValue += 10;
                    break;
                case ESS:
                    aces += 1;
                    break;
            }
        }

        for (int i = 0; i < aces; i++) { //TODO: fixa så man kan välja soft/hard ACE.'

            if (totalValue > 10) {
                totalValue += 1;
            } else {
                totalValue += 11;
            }
        }

        return totalValue;
    }

}
