package blackjack;

/**
 *This class +++Insert Description Here+++
 *
 * @author William Chen
 */
public class Card {
private int suit;
private int rank;
private int value;
private static final String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
private static final String[] ranks = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
Card(int suit, int values)
{
    this.rank=values;
    this.suit=suit;
}
//@Override
public String toString()
{
    return ranks[rank]+" of "+suits[suit];
}
public int getRank()
{
    return rank;
}
public int getSuit()
{
    return suit;
}
public int getValue()
{
    if(rank>10)
    {
        value=10;
    }
    else if(rank==1)
    {
        value=11;
    }
    else
    {
        value=rank;
    }
    return value;
}
public void setValue(int set)
{
    value = set;
}
}
