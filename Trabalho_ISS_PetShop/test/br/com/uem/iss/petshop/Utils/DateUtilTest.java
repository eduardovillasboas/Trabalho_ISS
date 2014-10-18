/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Utils;

import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EDUARDO
 */
public class DateUtilTest {
    
    public DateUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class DateUtil.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        Date date;
        DateUtil instance = new DateUtil();
        
        date = instance.toDate("11/08/2014");
        String expResult = "11/08/2014";
        String result = instance.toString(date);
        assertEquals(expResult, result);

        expResult = "24/09/2013";
        date = instance.toDate("24/09/2013");
        result = instance.toString(date);
        assertEquals(expResult, result);
        
        expResult = "01/09/2011";
        date = instance.toDate("01/09/2011");
        result = instance.toString(date);
        assertEquals(expResult, result);
    
        expResult = "04/09/2014";
        date = instance.toDate("04/09/2014");
        result = instance.toString(date);
        assertEquals(expResult, result);
        
    }
    
    
    /**
     * Test of toDate method, of class DateUtil.
     */
    @Test
    public void testToDate() {
        System.out.println("toDate");
        String string;
        Date expResult;
        Date result;
        DateUtil instance = new DateUtil();
        
        
        expResult = instance.toDate("01/08/2014");
        string = "01/08/2014";
        result = instance.toDate(string);
        assertEquals(expResult, result);
        
        expResult = instance.toDate("09/11/2011");
        string = "09/11/2011";
        result = instance.toDate(string);
        assertEquals(expResult, result);

        expResult = instance.toDate("25/01/2010");;
        string = "25/01/2010";
        result = instance.toDate(string);
        assertEquals(expResult, result);
        

    }
    
}
