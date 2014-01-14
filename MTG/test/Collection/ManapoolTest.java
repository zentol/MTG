/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shiren
 */
public class ManapoolTest {
    private Manapool manapool;

    public ManapoolTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        manapool = new Manapool();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class Manapool.
     */
    @Test
    public void testManapool() {
        String addition = "2RW";
        manapool.add(addition);
        Assert.assertEquals("2RW", manapool.check());
        manapool.use("1W");
        Assert.assertEquals("1R", manapool.check());
    }
}
