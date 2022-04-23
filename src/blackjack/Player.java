package blackjack;

import java.util.*;

public abstract class Player 
{
    public String strName;
    
    public abstract int getScore();
    public abstract boolean getIsBust();
    public abstract void setIsBust(boolean isBust);
    public abstract boolean getIsStand();
    public abstract void setIsStand(boolean isStand);
    public abstract boolean getIsBlackjack();
    public abstract void setIsBlackjack(boolean isBlackjack);
    protected abstract void calculateScore();
    public abstract void addCard(Card card);
    public abstract ArrayList<Card> getHand();
    
    public Player(String strName)
    {
        this.strName = strName;
    }
    
    public String getStrName()
    {
        return strName;
    }
    

}
