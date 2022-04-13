/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package blackjack;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author William
 */
public class BlackjackTest {
    
    public BlackjackTest() {
    }
    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }


    /**
     * Test of hasBlackJack method, of class Blackjack.
     */
    @Test
    public void testHasBlackJack() {
        System.out.println("hasBlackJack");
        int handValue = 0;
        boolean expResult = false;
        boolean result = Blackjack.hasBlackJack(handValue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of hasBlackJack method, of class Blackjack.
     */
    @Test
    public void testHasBlackJack1() {
        System.out.println("hasBlackJack");
        int handValue = 21;
        boolean expResult = true;
        boolean result = Blackjack.hasBlackJack(handValue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of hasBlackJack method, of class Blackjack.
     */
    @Test
    public void testHasBlackJack2() {
        System.out.println("hasBlackJack");
        int handValue = 25;
        boolean expResult = false;
        boolean result = Blackjack.hasBlackJack(handValue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isHitorStand method, of class Blackjack.
     */
    @Test
    public void testIsHitorStand() {
        System.out.println("isHitorStand");
        String hitter = "";
        boolean expResult = false;
        boolean result = Blackjack.isHitorStand(hitter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

     /**
     * Test of isHitorStand method, of class Blackjack.
     */
    @Test
    public void testIsHitorStand1() {
        System.out.println("isHitorStand");
        String hitter = "hit";
        boolean expResult = true;
        boolean result = Blackjack.isHitorStand(hitter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
     /**
     * Test of isHitorStand method, of class Blackjack.
     */
    @Test
    public void testIsHitorStand2() {
        System.out.println("isHitorStand");
        String hitter = "stand";
        boolean expResult = true;
        boolean result = Blackjack.isHitorStand(hitter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checkBust method, of class Blackjack.
     */
    @Test
    public void testCheckBust() {
        System.out.println("checkBust");
        int handvalue = 0;
        boolean expResult = false;
        boolean result = Blackjack.checkBust(handvalue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkBust method, of class Blackjack.
     */
    @Test
    public void testCheckBust1() {
        System.out.println("checkBust");
        int handvalue = 21;
        boolean expResult = false;
        boolean result = Blackjack.checkBust(handvalue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checkBust method, of class Blackjack.
     */
    @Test
    public void testCheckBust2() {
        System.out.println("checkBust");
        int handvalue = 22;
        boolean expResult = true;
        boolean result = Blackjack.checkBust(handvalue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
