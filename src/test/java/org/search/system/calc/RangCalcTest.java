package org.search.system.calc;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Daniil on 20.11.2016.
 */
public class RangCalcTest  extends TestCase {
    @Test
    public void testCalc() throws Exception {
        RangCalc calc=new RangCalc();
       assertEquals(2,calc.calc("test test","test"));
    }
}
