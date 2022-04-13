package blackjack;

/**
 *This class +++Insert Description Here+++
 *
 * @author William Chen
 */
public class Card {

    private final Rank rank;

    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

}