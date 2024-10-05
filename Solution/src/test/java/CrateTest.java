/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Tim
 */
public class CrateTest {
    
    public CrateTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of hasNext method, of class Crate.
     */
    @Test
    public void testHasNext1() {
        System.out.println("hasNext");
        int[] array = new int[]{1, 2};
        Crate crate = new Crate(array);
        
        // Case 1
        boolean expResult = true;
        boolean result = crate.hasNext();
        crate.next();
        assertEquals(expResult, result);
        
        // Case 2
        expResult = true;
        result = crate.hasNext();
        crate.next();
        assertEquals(expResult, result);
        
        // Case 3
        expResult = false;
        result = crate.hasNext();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of hasNext method with no content
     */
    @Test
    public void testHasNext2() {
        System.out.println("hasNext - No Content");
        int[] array = new int[]{};
        Crate crate = new Crate(array);
        
        // Case 1
        boolean expResult = false;
        boolean result = crate.hasNext();
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class Crate.
     */
    @Test
    public void testNext1() {
        System.out.println("next");
        int[] array = new int[]{1, 2};
        Crate crate = new Crate(array);
        
        // Case 1
        Object expResult = array[0];
        Object result = crate.next();
        assertEquals(expResult, result);
        
        // Case 2
        expResult = array[1];
        result = crate.next();
        assertEquals(expResult, result);
        
        assertThrows(NoSuchElementException.class, () -> {
            crate.next();
        });
    }
    
    /**
     * Test of next method with no content
     */
    @Test
    public void testNext2() {
        System.out.println("next - No Content");
        int[] array = new int[]{};
        Crate crate = new Crate(array);
        
        // Case 1
        assertThrows(NoSuchElementException.class, () -> {
            crate.next();
        });
    }
}
