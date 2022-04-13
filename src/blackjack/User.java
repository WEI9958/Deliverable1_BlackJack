package blackjack;

import java.util.ArrayList;

/**
 *This class +++Insert Description Here+++
 *
 * @author William Chen
 */
public class User {
    
    private final String name;
    
    private final ArrayList<Card> hand;
    
    public User(String name){
        this.name = name;
        this.hand = new ArrayList<>();
    }
    
    public String getName(){
        return name;
    }
    
    public void addCard(Card card){
        hand.add(card);
    }
    
    public int getHandValue(){
        int handValue = 0;
        int aceNum = 0;
        for (Card card : hand) {
            handValue += card.getRank().getValue();
            if(card.getRank().getValue() == 11){
                aceNum ++;
            }
            while(handValue > 21 && aceNum > 0){
                handValue -= 10;
                aceNum--;
            }
        }
        return handValue;
    }
    
    public String showHandCards(){
        String handCards = "";
        for(int i = 0; i<hand.size(); i++){
            handCards = handCards + hand.get(i) + ", ";
        }
        return handCards;
    }
    
    public String showFirstCard(){
        String firstCard = "Hidden card, ";
        firstCard += hand.get(0);
        return firstCard;
    }
}
