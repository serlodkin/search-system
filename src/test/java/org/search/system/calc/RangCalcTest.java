package org.search.system.calc;

import junit.framework.TestCase;

/**
 * Created by Daniil on 20.11.2016.
 */
public class RangCalcTest  extends TestCase {
    public void testCalc() throws Exception {
        RangCalc calc=new RangCalc();
       assertEquals(2,calc.calc("testtest","test"));
    }
}
