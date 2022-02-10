package blackjack;
import java.util.*;
public class Blackjack {
private static int AceCounter;
private static ArrayList<Card> hand;
private static int handvalue;
public static void main(String[] args){

        Deck deck = new Deck();
        deck.shuffle();
        AceCounter=0;
        Dealer dealer = new Dealer(deck);
        List<Card> hand = new ArrayList<>();
        hand.add(deck.drawCard());
        hand.add(deck.drawCard());
        System.out.println("Here is your hand: ");
        System.out.println(hand);
        int handvalue = calcHandValue(hand);
        System.out.println("The dealer is showing: ");
        dealer.showFirstCard();
        if(hasBlackJack(handvalue) && dealer.hasBlackJack())
        {
            Push();
        }
        else if(hasBlackJack(handvalue))
        {
            System.out.println("You have BlackJack!");
            Win();
        }
        else if(dealer.hasBlackJack())
        {
            System.out.println("Here is the dealer's hand:");
            dealer.showHand();
            Lose();
        }
        System.out.println("Would you like to hit or stand?");
        Scanner hitorstand = new Scanner(System.in);
        String hitter = hitorstand.nextLine();
        while(!isHitorStand(hitter))
        {
            System.out.println("Please enter 'hit' or 'stand'.");
            hitter = hitorstand.nextLine();
        }
        while(hitter.equals("hit"))
        {
            Hit(deck, hand);
            System.out.println("Your hand is now:");
            System.out.println(hand);
            handvalue = calcHandValue(hand);
            if(checkBust(handvalue))
            {
                Lose();
                break;
            }
            System.out.println("Would you like to hit or stand?");
            hitter = hitorstand.nextLine();
            }
            if(hitter.equals("stand"))
            {
                int dealerhand = dealer.takeTurn(deck);
                System.out.println("");
                System.out.println("Here is the dealer's hand:");
                dealer.showHand();
                if(dealerhand>21)
                {
                    Win();
                }
                else
                {
                    int you = 21-handvalue;
                    int deal = 21-dealerhand;
                    if(you==deal)
                    {
                        Push();
                    }
                    if(you<deal)
                    {
                        Win();
                    }
                    if(deal<you)
                    {
                        Lose();
                    }
                }
            }
}

  
public static boolean hasBlackJack(int handValue)
{
    if(handValue==21)
    {
        return true;
    }
    return false;
}

public static int calcHandValue(List<Card> hand)
{
    Card[] aHand = new Card[]{};
    aHand = hand.toArray(aHand);
    int handvalue=0;
    for(int i=0; i<aHand.length; i++)
    {
        handvalue += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            AceCounter++;
        }
        while(AceCounter>0 && handvalue>21)
        {
            handvalue-=10;
            AceCounter--;
        }
    }
    return handvalue;
}


public static void Win()
{
    System.out.println("Congratulations, you win!");
}

public static void Lose()
{
    System.out.println("Sorry, you lose!");
}

public static void Push()
{
    System.out.println("It's a push!");
}

public static void Hit(Deck deck, List<Card> hand)
{
    hand.add(deck.drawCard());
    Card[] aHand = new Card[]{};
    aHand = hand.toArray(aHand);
    handvalue = 0;
    for(int i=0; i<aHand.length; i++)
    {
        handvalue += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            AceCounter++;
        }
        while(AceCounter>0 && handvalue>21)
        {
            handvalue-=10;
            AceCounter--;
        }
    }
}

public static boolean isHitorStand(String hitter)
{
    return hitter.equals("hit") || hitter.equals("stand");
}

public static boolean checkBust(int handvalue)
{
    if(handvalue>21)
    {
        System.out.println("You have busted!");
        return true;
    }
    return false;
}

}