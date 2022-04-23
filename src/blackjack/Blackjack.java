package blackjack;

import java.util.*;


public class Blackjack 
{
    private ArrayList<Player> players = new ArrayList();
    private static Blackjack blackjack = new Blackjack();
    
    private Blackjack()
    {
        players.add(BlackjackDealer.assignBlackjackDealer());
    }
    
    public static Blackjack assignBlackjack()
    {
        return blackjack;
    }

    public ArrayList<Player> getPlayers() 
    {
        return players;
    }

    public void makeBlackjackPlayer(String strName)
    {
        players.add(BlackjackPlayer.makeBlackjackPlayer(strName));
    }
    
    public void dealCards()
    {
        DeckOfCards.shuffle();
        for (int i = 0; i < players.size(); i++)
        {
            players.get(i).addCard(DeckOfCards.getTopCard());
            players.get(i).addCard(DeckOfCards.getTopCard());
        }
    }
    
    public Player getPlayer(int index)
    {
        return players.get(index);
    }
    
    public void hitCard(Player currentPlayer)
    {
        currentPlayer.addCard(DeckOfCards.getTopCard());
    }
    
    public Card getDealerFace()
    {
        return players.get(0).getHand().get(0);
    }
    
    public BlackjackDealer getDealer()
    {
        return (BlackjackDealer) players.get(0);
    }
    
    public void play(Player player, int intTurn)
    {
        if (intTurn == 1)
        {
            player.addCard(DeckOfCards.getTopCard());
            player.calculateScore();
        }
        else if (intTurn == 2)
        {
            player.setIsStand(true);
        }
        else if (intTurn == 3)
        {
            player.setIsBust(true);
        }
        else if (intTurn == 4)
        {
            player.setIsBlackjack(true);
        }
    }

}
