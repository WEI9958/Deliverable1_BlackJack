package blackjack;
import java.util.ArrayList;
import java.util.Random;
/**
 *This class +++Insert Description Here+++
 *
 * @author William Chen
 */
public class Deck {
private final ArrayList<Card> deck;
public Deck() {
        deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
    }
public void shuffle()
{
    Random random = new Random();
    Card temp;
    for(int i=0; i<200; i++)
    {
        int index1 = random.nextInt(deck.size()-1);
        int index2 = random.nextInt(deck.size()-1);
        temp = deck.get(index2);
        deck.set(index2, deck.get(index1));
        deck.set(index1, temp);
    }
}
public Card drawCard()
{
    return deck.remove(0);
}
}
