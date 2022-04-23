/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package blackjack;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class BlackjackTest 
{
    
    //Note: 
    //Because the state of the Player objects is determined by a singular value 
    //which is passed into their methods, there is in many tests only one 
    //possible value which results in both a true good and boundary test.

    @Before
    public void setUp() 
    {
        Blackjack testBlackjack = Blackjack.assignBlackjack();
        testBlackjack.makeBlackjackPlayer("testPlayer");
    }
    
    
    public BlackjackTest() 
    {
    }

    @Test
    public void goodMakeBlackjackPlayer() 
    {
        System.out.println("good BlackjackPlayer test");
        String strName = "Player";
        Blackjack testBlackjack = Blackjack.assignBlackjack();
        Blackjack instance = testBlackjack;
        instance.makeBlackjackPlayer(strName);
        assertEquals(strName, 
            instance.getPlayer(instance.getPlayers().size() - 1).getStrName());
    }
    
    @Test
    public void boundMakeBlackjackPlayer() 
    {
        System.out.println("bound BlackjackPlayer test");
        String strName = "TEST";
        Blackjack testBlackjack = Blackjack.assignBlackjack();
        Blackjack instance = testBlackjack;
        instance.makeBlackjackPlayer(strName);
        assertEquals("TEST", 
            instance.getPlayer(instance.getPlayers().size() - 1).getStrName());
    }
    
    @Test
    public void badMakeBlackjackPlayer() 
    {
        System.out.println("bad BlackjackPlayer test");
        String strName = "";
        Blackjack testBlackjack = Blackjack.assignBlackjack();
        Blackjack instance = testBlackjack;
        instance.makeBlackjackPlayer(strName);  
        assertEquals("", 
            instance.getPlayer(instance.getPlayers().size() - 1).getStrName());
    }
    
    @Test
    public void goodBlackjackPlayerStand() 
    {
        System.out.println("good BlackjackPlayer Stand Test");
        int intTurn = 2;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(1), intTurn);
        assertEquals(true, instance.getPlayer(1).getIsStand());
        instance.getPlayer(1).setIsStand(false);
    }
    
    @Test
    public void badBlackjackPlayerStand() 
    {
        System.out.println("bad BlackjackPlayer Stand Test");
        int intTurn = 10;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(1), intTurn);
        assertEquals(false, instance.getPlayer(1).getIsStand());
        instance.getPlayer(1).setIsStand(false);
    }
    
    @Test
    public void boundBlackjackPlayerStand() 
    {
        System.out.println("bound BlackjackPlayer Stand Test");
        int intTurn = 2;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(1), intTurn);
        assertEquals(true, instance.getPlayer(1).getIsStand());
        instance.getPlayer(1).setIsStand(false);
    }
    
    @Test
    public void goodBlackjackPlayerSurrender() 
    {
        System.out.println("good BlackjackPlayer Surrender Test");
        int intTurn = 3;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(1), intTurn);
        assertEquals(true, instance.getPlayer(1).getIsBust());
        instance.getPlayer(1).setIsBust(false);
    }
    
    @Test
    public void badBlackjackPlayerSurrender() 
    {
        System.out.println("bad BlackjackPlayer Surender Test");
        int intTurn = 10;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(1), intTurn);
        assertEquals(false, instance.getPlayer(1).getIsBust());
        instance.getPlayer(1).setIsBust(false);
    }
    
    @Test
    public void boundBlackjackPlayerSurrender() 
    {
        System.out.println("bound BlackjackPlayer SurrenderTest");
        int intTurn = 3;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(1), intTurn);
        assertEquals(true, instance.getPlayer(1).getIsBust());
        instance.getPlayer(1).setIsBust(false);
    }
    
    @Test
    public void goodBlackjackPlayerBust() 
    {
        System.out.println("good BlackjackPlayer Bust Test");
        int intTurn = 3;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(1), intTurn);
        assertEquals(true, instance.getPlayer(1).getIsBust());
        instance.getPlayer(1).setIsBust(false);
    }
    
    @Test
    public void badBlackjackPlayerBust() 
    {
        System.out.println("bad BlackjackPlayer Bust Test");
        int intTurn = 10;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(1), intTurn);
        assertEquals(false, instance.getPlayer(1).getIsBust());
        instance.getPlayer(1).setIsBust(false);
    }
    
    @Test
    public void boundBlackjackPlayerBust() 
    {
        System.out.println("bound BlackjackPlayer Bust Test");
        int intTurn = 3;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(1), intTurn);
        assertEquals(true, instance.getPlayer(1).getIsBust());
        instance.getPlayer(1).setIsBust(false);
    }
    
    @Test
    public void goodBlackjackPlayerBlackjack() 
    {
        System.out.println("good BlackjackPlayer Blackjack Test");
        int intTurn = 4;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(1), intTurn);
        assertEquals(true, instance.getPlayer(1).getIsBlackjack());
        instance.getPlayer(1).setIsBlackjack(false);
    }
    
    @Test
    public void badBlackjackPlayerBlackjack() 
    {
        System.out.println("bad BlackjackPlayer Blackjack Test");
        int intTurn = 10;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(1), intTurn);
        assertEquals(false, instance.getPlayer(1).getIsBlackjack());
        instance.getPlayer(1).setIsBlackjack(false);
    }
    
    @Test
    public void boundBlackjackPlayerBlackjack() 
    {
        System.out.println("bound BlackjackPlayer Blackjack Test");
        int intTurn = 4;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(1), intTurn);
        assertEquals(true, instance.getPlayer(1).getIsBlackjack());
        instance.getPlayer(1).setIsBlackjack(false);
    }
    
    @Test
    public void goodDealerStand() 
    {
        System.out.println("good Dealer Stand Test");
        int intTurn = 2;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(0), intTurn);
        assertEquals(true, instance.getPlayer(0).getIsStand());
        instance.getPlayer(0).setIsStand(false);
    }
    
    @Test
    public void badDealerStand() 
    {
        System.out.println("bad Dealer Stand Test");
        int intTurn = 10;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(0), intTurn);
        assertEquals(false, instance.getPlayer(0).getIsStand());
        instance.getPlayer(0).setIsStand(false);
    }
    
    @Test
    public void boundDealerStand() 
    {
        System.out.println("bound Dealer Stand Test");
        int intTurn = 2;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(0), intTurn);
        assertEquals(true, instance.getPlayer(0).getIsStand());
        instance.getPlayer(0).setIsStand(false);
    }
    
    @Test
    public void goodDealerBust() 
    {
        System.out.println("good Dealer Bust Test");
        int intTurn = 3;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(0), intTurn);
        assertEquals(true, instance.getPlayer(0).getIsBust());
        instance.getPlayer(0).setIsBust(false);
    }
    
    @Test
    public void badDealerBust() 
    {
        System.out.println("bad Dealer Bust Test");
        int intTurn = 10;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(0), intTurn);
        assertEquals(false, instance.getPlayer(0).getIsBust());
        instance.getPlayer(0).setIsBust(false);
    }
    
    @Test
    public void boundDealerBust() 
    {
        System.out.println("bound Dealer Bust Test");
        int intTurn = 3;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(0), intTurn);
        assertEquals(true, instance.getPlayer(0).getIsBust());
        instance.getPlayer(0).setIsBust(false);
    }
    
    @Test
    public void goodDealerBlackjack() 
    {
        System.out.println("good Dealer Blackjack Test");
        int intTurn = 4;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(0), intTurn);
        assertEquals(true, instance.getPlayer(0).getIsBlackjack());
        instance.getPlayer(0).setIsBlackjack(false);
    }
    
    @Test
    public void badDealerBlackjack() 
    {
        System.out.println("bad Dealer Blackjack Test");
        int intTurn = 10;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(0), intTurn);
        assertEquals(false, instance.getPlayer(0).getIsBlackjack());
        instance.getPlayer(0).setIsBlackjack(false);
    }
    
    @Test
    public void boundDealerBlackjack() 
    {
        System.out.println("bound Dealer Blackjack Test");
        int intTurn = 4;
        Blackjack instance = Blackjack.assignBlackjack();
        instance.play(instance.getPlayer(0), intTurn);
        assertEquals(true, instance.getPlayer(0).getIsBlackjack());
        instance.getPlayer(0).setIsBlackjack(false);
    }
    
}
