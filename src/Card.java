/**
 * @author Kevin Nilsson
 * @since 05/15/2019
 */
public class Card {

    private Suit suit;

    private Value value;

    /**
     * @param suit  the suit of the card
     * @param value the number of the card
     */
    public Card(Suit suit, Value value) {

        this.suit = suit;
        this.value = value;

    }

    Value getValue() {
        return this.value;
    }

    Suit getSuit() {
        return this.suit;
    }

    /**
     * @return Ger oss suiten + value. Ex " Two of Hearts"
     */

    public String toString() {
        return this.suit.toString() + " " + this.value.toString();
    }
}
