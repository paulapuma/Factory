package edu.upc.eetac.dsa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class FactoryTest {


    Command c;

    @After
    public void tearDown(){
        c = null;
    }


    @Test
    public void testFactory() {
        c = Factory.getInstance().getCommand("C1");
        Assert.assertEquals("C1", c.execute());

        c = Factory.getInstance().getCommand("C1");
        Assert.assertEquals("C1", c.execute());

        c = Factory.getInstance().getCommand("C2");
        Assert.assertEquals("C2", c.execute());

        c = Factory.getInstance().getCommand("C2");
        Assert.assertEquals("C2", c.execute());

    }

}
