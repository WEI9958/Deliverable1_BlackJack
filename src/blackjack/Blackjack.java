package blackjack;
import java.util.*;
/**
 *This class +++Insert Description Here+++
 *
 * @author William Chen
 */
public class Blackjack {
private static int cash;
private static int bet;
//private static int AceCounter;
public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    String name;
    String input;
    
    System.out.println("Hi! What is your name?");
    input = scanner.nextLine();
    name = input;
    System.out.println("Hello, "+name+", lets play some BlackJack!");
    System.out.println("How much cash do you want to start with?");
    Scanner money = new Scanner(System.in);
    cash = money.nextInt();
    System.out.println("You start with cash: "+cash);
    while(cash>0){
        
        User player = new User(name);
        User dealer = new User("Dealer");
        Deck deck = new Deck();
        deck.shuffle();
        
        System.out.println("How much would you like to bet?");
        bet=Bet(cash);
        System.out.println("Cash:"+(cash-bet));
        System.out.println("Money on the table:"+bet);
        
        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        System.out.println("Here is your hand: ");
        System.out.println(player.showHandCards());
        
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        System.out.println("The dealer is showing: ");
        System.out.println(dealer.showFirstCard());
       
        if(hasBlackJack(player.getHandValue()) && hasBlackJack(dealer.getHandValue()))
        {
            Push();
        }
        else if(hasBlackJack(player.getHandValue()))
        {
            System.out.println("You have BlackJack!");
            System.out.println("You win 2x your money back!");
            cash=cash+bet;
            Win();
        }
        else if(hasBlackJack(dealer.getHandValue()))
        {
            System.out.println("Here is the dealer's hand:");
            System.out.println(dealer.showHandCards());
            Lose();
        }
        else
        {
            if(2*bet<cash)
            {
                System.out.println("Would you like to double down?(yes/no)");
                Scanner doubledown = new Scanner(System.in);
                String doubled = doubledown.nextLine();
                while(!isyesorno(doubled))
                {
                    System.out.println("Please enter yes or no.");
                    doubled = doubledown.nextLine();
                }
                if(doubled.equals("yes"))
                {
                    System.out.println("You have opted to double down!");
                    bet=2*bet;
                    System.out.println("Cash:"+(cash-bet));
                    System.out.println("Money on the table:"+bet);
                }
            }
            System.out.println("Would you like to hit or stand?(hit/stand)");
            Scanner hitorstand = new Scanner(System.in);
            String hitter = hitorstand.nextLine();
            while(!isHitorStand(hitter))
            {
                System.out.println("Please enter 'hit' or 'stand'.");
                hitter = hitorstand.nextLine();
            }
            while(hitter.equals("hit"))
            {
                player.addCard(deck.drawCard());
                System.out.println("Your hand is now:");
                System.out.println(player.showHandCards());
                if(checkBust(player.getHandValue()))
                {
                    Lose();
                    break;
                }
                System.out.println("Would you like to hit or stand?");
                hitter = hitorstand.nextLine();
            }
            if(hitter.equals("stand"))
            {
                
                System.out.println("It's dealer's turn");
                System.out.println("Here is the dealer's hand:");
                System.out.println(dealer.showHandCards());
                if(dealer.getHandValue() <= 16){
                    System.out.println("Dealer hits:");
                    System.out.println("Dealer's hand is now:");
                    dealer.addCard(deck.drawCard());
                    System.out.println(dealer.showHandCards());
                    if(hasBlackJack(dealer.getHandValue())){
                        Lose();
                    }
                    if(checkBust(dealer.getHandValue())){
                        Win();
                    }
                }
                else if(checkBust(dealer.getHandValue()))
                {
                    Win();
                }
                else
                {
                    int you = 21-player.getHandValue();
                    int deal = 21-dealer.getHandValue();
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
    System.out.println("Would you like to play again?(yes/no)");
    Scanner yesorno = new Scanner(System.in);
    String answer = yesorno.nextLine();
    while(!isyesorno(answer))
            {
                System.out.println("Please answer yes or no.");
                answer = yesorno.nextLine();
            }
    if(answer.equals("no"))
    {
        break;
    }
}
    System.out.println("Your cash is: "+cash);
    if(cash==0)
    {
        System.out.println("You ran out of cash!");
    }
    else
    {
        System.out.println("Enjoy your day, "+name+"!");
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


public static int Bet(int cash)
{
    Scanner sc=new Scanner(System.in);
    bet=sc.nextInt();
    while(bet>cash)
    {
        System.out.println("You cannot bet more cash than you have!");
        System.out.println("How much would you like to bet?");
        bet=sc.nextInt();
    }
    return bet;
}

public static void Win()
{
    System.out.println("Congratulations, you win!");
    cash=cash+bet;
    System.out.println("Cash: "+cash);
}

public static void Lose()
{
    System.out.println("Sorry, you lose!");
    cash=cash-bet;
    System.out.println("Cash: "+cash);
}

public static void Push()
{
    System.out.println("It's a push!");
    System.out.println("You get your money back.");
    System.out.println("Cash: "+cash);
}



public static boolean isHitorStand(String hitter)
{
    if(hitter.equals("hit") || hitter.equals("stand"))
    {
        return true;
    }
    return false;
}

public static boolean checkBust(int handvalue)
{
    if(handvalue>21)
    {
        System.out.println("Busted!");
        return true;
    }
    return false;
}

public static boolean isyesorno(String answer)
{
    if(answer.equals("yes") || answer.equals("no"))
    {
        return true;
    }
    return false;
}
}
