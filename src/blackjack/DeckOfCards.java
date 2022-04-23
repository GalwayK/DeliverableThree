package blackjack;

import java.util.*;

public class DeckOfCards {

    private static ArrayList<Card> deckList = new ArrayList<>();
    private static DeckOfCards deck = new DeckOfCards();
    private static int topIndex = deckList.size();
    
    private DeckOfCards()
    {
        makeDeck();
    }
    
    public static ArrayList<Card> getDeck()
    {
        return deckList;
    }
    
    public static void shuffle()
    {
        System.out.println("Shuffling.");
        int lastIndex = deckList.size() - 1;
        int randomIndex;
        Card tempCard;
        
        while (lastIndex > 0)
        {
            randomIndex = (int)(Math.random() * lastIndex);
            tempCard = deckList.get(lastIndex);

            deckList.set(lastIndex, deckList.get(randomIndex));
            deckList.set(randomIndex, tempCard);
            
            lastIndex--;
        }
    }        
    

    private static void makeDeck() 
    {
        //Counter variable to populate arraylist
        int cardCounter = 0;

        //String and int variables to define card rank and value per loop
        String strRank = "";
        int intValue = 0;

        //For loop to create 4 versions of each Card rank
        for (int s = 0; s < 13; s++) 
        {
            //Switch statement determining Card rank per loop
            switch (s) {
                case 0:
                    strRank = "2";
                    intValue = 2;
                    break;
                case 1:
                    strRank = "3";
                    intValue = 3;
                    break;
                case 2:
                    strRank = "4";
                    intValue = 4;
                    break;
                case 3:
                    strRank = "5";
                    intValue = 5;
                    break;
                case 4:
                    strRank = "6";
                    intValue = 6;
                    break;
                case 5:
                    strRank = "7";
                    intValue = 7;
                    break;
                case 6:
                    strRank = "8";
                    intValue = 8;
                    break;
                case 7:
                    strRank = "9";
                    intValue = 9;
                    break;
                case 8:
                    strRank = "10";
                    intValue = 10;
                    break;
                case 9:
                    strRank = "Jack";
                    intValue = 10;
                    break;
                case 10:
                    strRank = "Queen";
                    intValue = 10;
                    break;
                case 11:
                    strRank = "King";
                    intValue = 10;
                    break;
                case 12:
                    strRank = "Ace";
                    intValue = 11;
                    break;
            }

            //Creates 4 Cards of each rank, one per suit
            deckList.add(new Card("Hearts", strRank, intValue));
            cardCounter++;
            deckList.add(new Card("Diamonds", strRank, intValue));
            cardCounter++;
            deckList.add(new Card("Spades", strRank, intValue));
            cardCounter++;
            deckList.add(new Card("Clubs", strRank, intValue));
            cardCounter++;
        }
    }
    
    public static Card getTopCard()
    {
        return deckList.get(deckList.size() - topIndex--);
    }
    
}
