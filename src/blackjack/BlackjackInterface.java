package blackjack;

import java.util.*;

public class BlackjackInterface 
{
    private static Scanner input = new Scanner(System.in);
    private static Blackjack blackjack = Blackjack.assignBlackjack();
    private static int intPlayers = 0;
    
    public static void main(String[] args)
    {
        playBlackjack();
    }
    
    public static void playBlackjack()
    {
        System.out.println("\nPlaying Blackjack\n");
        
            setPlayers();

            dealCards();

            playerTurns();

            dealerTurn();

            declareWinner();
    }
    
    public static void setPlayers()
    {
        
        boolean isValid = false;
        
        while (!isValid)
        {
            System.out.print("Please enter number of players: ");
            try
            {
                String strPlayers = input.nextLine();
                intPlayers = Integer.parseInt(strPlayers);
                isValid = true;
                if (intPlayers < 1 || intPlayers > 5)
                {
                    System.out.println(
                        "Error, please enter between 1 and 5 players.");
                    isValid = false;
                }
            }
            catch (Exception exception)
            {
                System.out.println("Error, please enter integers.");
            }
        }
        
        for (int i = 0; i < intPlayers; i++)
        {
            System.out.printf("Please enter the name of player #%d: ", i + 1);
            String strName = input.nextLine();
            blackjack.makeBlackjackPlayer(strName);
        }
        
        //Remove after testing
        for (int i = 0; i < blackjack.getPlayers().size(); i++)
        {
            System.out.println(blackjack.getPlayers().get(i).getStrName());
        }
    }
    
    public static void dealCards()
    {
        blackjack.dealCards();
        
        //Remove after testing
        
        for (int i = 0; i < blackjack.getPlayers().size(); i++)
        {
            for (Card hand : blackjack.getPlayers().get(i).getHand()) 
            {
                System.out.println(hand);
            }
            System.out.println();
        }
    }
    
    public static void playerTurns()
    {
        System.out.println("\nPlayer Turn\n");
        
        System.out.printf("\nDealer face: %s\n\n", 
            blackjack.getDealerFace().toString());
        
        for (int i = 1; i < intPlayers + 1; i++)
        {
            BlackjackPlayer currentPlayer = 
                (BlackjackPlayer) blackjack.getPlayer(i);
            
            while (! (currentPlayer.getIsStand() 
                || currentPlayer.getIsBlackjack() 
                || currentPlayer.getIsBust()))
            {
            System.out.printf("Player: %s Score: %d\n", 
                currentPlayer.getStrName(), currentPlayer.getScore());

                for (Card hand : currentPlayer.getHand()) 
                {
                    System.out.println(hand.toString());
                }

                if (currentPlayer.getScore() < 21)
                {
                    boolean isValid = false;
                    while (! isValid)
                    {
                        System.out.println("1. Hit\n2. Stand\n3. Surrender.");
                        try
                        {
                            String strTurn = input.nextLine();
                            int intTurn = Integer.parseInt(strTurn);
                            if (intTurn > 0 && intTurn < 4)
                            {
                                isValid = true;
                                blackjack.play(currentPlayer, intTurn);
                            }
                            else
                            {
                                System.out.println
                                    ("Error, please enter a valid choice.");
                            }
                        }
                        catch (Exception exception)
                        {
                            System.out.println
                                ("Error, please enter an integer.");
                        }
                    }
                }
                else if (currentPlayer.getScore() == 21)
                {
                    System.out.println("Your score is 21. Blackjack!");
                    blackjack.play(currentPlayer, 4);
                }
                else 
                {
                    System.out.println("You have gone bust.");
                    blackjack.play(currentPlayer, 3);
                }
            }
            System.out.println("\nNext player.\n");
        }
    }
    
    public static void dealerTurn()
    {
        
        BlackjackDealer dealer = blackjack.getDealer();
        
        while (! (dealer.getIsStand() || dealer.getIsBust() || 
            dealer.getIsBlackjack()))
        {
            System.out.printf("Dealer score: %d\n", dealer.getScore());
            
            for (Card hand : dealer.getHand())
            {
                System.out.println(hand.toString());
            }
            
            if (dealer.getScore() < 17)
            {
                System.out.println("Dealer hits.");
                blackjack.play(dealer, 1);
            }
            else if (dealer.getScore() > 21)
            {
                System.out.println("Dealer has gone bust.");
                blackjack.play(dealer, 3);
            }
            else if (dealer.getScore() == 21)
            {
                System.out.println("Dealer has blackjack.");
                blackjack.play(dealer, 4);
            }
            else if (dealer.getScore() >= 17)
            {
                System.out.println("Dealer stands");
                blackjack.play(dealer, 2);
            }
        }
    }
    
    public static void declareWinner()
    {
        System.out.println("\nDeclaring Winners\n");
        
        for (int i = 1; i < intPlayers + 1; i++)
        {
            BlackjackPlayer currentPlayer = 
                (BlackjackPlayer) blackjack.getPlayers().get(i);
            if (currentPlayer.getIsBust())
            {
                System.out.printf("%s went bust.\n\n", 
                     currentPlayer.getStrName());
            }
            else if (currentPlayer.getScore() > blackjack.getDealer().getScore()
                || blackjack.getDealer().getIsBust())
            {
                System.out.printf("%s won.\n\n", 
                    currentPlayer.getStrName());
            }
            else if (currentPlayer.getScore() == 
                blackjack.getDealer().getScore())
            {
                System.out.printf("%s broke even.\n\n", 
                    currentPlayer.getStrName());
            }
            else if (currentPlayer.getScore() < blackjack.getDealer().getScore()
                && ! blackjack.getDealer().getIsBust())
            {
                System.out.printf("%s lost.\n\n", currentPlayer.getStrName());
            }
        }
    }
}
