/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Utils;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lucas
 */
public class NumberUtilTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of toFloat method, of class NumberUtil.
     */
    @Test
    public void testToFloat() {
        System.out.println("toFloat");
        String s = "1,50";
        Float expResult = new Float(1.50);
        Float result = NumberUtil.toFloat(s);
        assertEquals(expResult, result);
        
        s = "0,50";
        expResult = new Float(0.50);
        result = NumberUtil.toFloat(s);
        assertEquals(expResult, result);
        
        s = "0,00";
        expResult = new Float(0.00);
        result = NumberUtil.toFloat(s);
        assertEquals(expResult, result);
        
        s = "0.00";
        expResult = new Float(0.00);
        result = NumberUtil.toFloat(s);
        assertEquals(expResult, result);
        
        s = "0.55";
        expResult = new Float(0.55);
        result = NumberUtil.toFloat(s);
        assertEquals(expResult, result);
        
    }
    
}
