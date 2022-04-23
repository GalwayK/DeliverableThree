package blackjack;

import java.util.*;


public class BlackjackDealer extends Player
{
    private static BlackjackDealer dealer = new BlackjackDealer();
    private boolean isBust = false;
    private boolean isBlackjack = false;
    private boolean isStand = false;
    private int score = 0;
    private ArrayList<Card> hand = new ArrayList();
    
    private BlackjackDealer()
    {
        super("Dealer");
    }

    public boolean getIsStand() 
    {
        return isStand;
    }

    public void setIsStand(boolean isStand) 
    {
        this.isStand = isStand;
    }
    
    public static BlackjackDealer assignBlackjackDealer()
    {
        return dealer;
    }

    public void setIsBust(boolean isBust) 
    {
        this.isBust = isBust;
    }

    public boolean getIsBlackjack() 
    {
        return isBlackjack;
    }

    public void setIsBlackjack(boolean isBlackjack) 
    {
        this.isBlackjack = isBlackjack;
    }
    
    public boolean getIsBust() 
    {
        return isBust;
    }

    public int getScore() 
    {
        calculateScore();
        return score;
    }

    public ArrayList<Card> getHand() 
    {
        return hand;
    }
    
    public void addCard(Card card)
    {
        hand.add(card);
    }
    
    protected void calculateScore()
    {
     int tempScore = 0;
        for (Card tempCard : hand) 
        {
            tempScore += tempCard.getIntValue();
        }
        this.score = tempScore;   
    }
}
