package blackjack;


public class Card 
{
    
    private String strRank;
    private String strSuit;
    private int intValue;

    public Card(String strRank, String strSuit, int intValue) 
    {
        this.strRank = strRank;
        this.strSuit = strSuit;
        this.intValue = intValue;
    }

    public String getStrRank() 
    {
        return strRank;
    }

    public void setStrRank(String strRank) 
    {
        this.strRank = strRank;
    }

    public String getStrSuit() 
    {
        return strSuit;
    }

    public void setStrSuit(String strSuit) 
    {
        this.strSuit = strSuit;
    }

    public int getIntValue() 
    {
        return intValue;
    }

    public void setIntValue(int intValue) 
    {
        this.intValue = intValue;
    }
    
    public String toString()
    {
        return String.format("%s of %s", strSuit, strRank);
    }
}
