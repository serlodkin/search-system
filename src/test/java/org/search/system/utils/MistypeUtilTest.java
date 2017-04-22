package org.search.system.utils;

import junit.framework.TestCase;

/**
 * Created by exam on 22.04.2017.
 */
public class MistypeUtilTest extends TestCase {

    private static final int ONE = 1;

    private static final int THREE = 3;

    private static final int SIX = 6;

    private static final int SEVEN = 7;

    private static final int FOUR = 4;

    private static final int FIVE = 5;

    private static final int ZERO = 0;


    public void testLevensteinDistance() throws Exception {
        assertEquals(ONE,MistypeUtil.levensteinDistance("fog","frog"));
    }

    public void testLevensteinDistance1() throws Exception {
        assertEquals(THREE,MistypeUtil.levensteinDistance("AGCAT","GAC"));
    }

    public void testLevensteinDistance2() throws Exception {
        assertEquals(THREE,MistypeUtil.levensteinDistance("example","samples"));
    }

    public void testLevensteinDistance3() throws Exception {
        assertEquals(SIX,MistypeUtil.levensteinDistance("levenshtein","frankenstein"));
    }

    public void testLevensteinDistance4() throws Exception {
        assertEquals(FIVE,MistypeUtil.levensteinDistance("distance","difference"));
    }

    public void testLevensteinDistance5() throws Exception {
        assertEquals(FOUR,MistypeUtil.levensteinDistance("scala is great","scala is not great"));
    }

    public void testLevensteinDistance6() throws Exception {
        assertEquals(ZERO,MistypeUtil.levensteinDistance("",""));
    }

    public void testLevensteinDistance7() throws Exception {
        assertEquals(ZERO,MistypeUtil.levensteinDistance("abc","abc"));
    }

    public void testLevensteinDistance8() throws Exception {
        assertEquals(ZERO,MistypeUtil.levensteinDistance("some long string","some long string"));
    }

    public void testLevensteinDistance9() throws Exception {
        assertEquals(SIX,MistypeUtil.levensteinDistance("levenshtein","frankenstein"));
    }

    public void testLevensteinDistance10() throws Exception {
        assertEquals(ONE,MistypeUtil.levensteinDistance("","a"));
    }

    public void testLevensteinDistance11() throws Exception {
        assertEquals(ONE,MistypeUtil.levensteinDistance("a","ab"));
    }

    public void testLevensteinDistance12() throws Exception {
        assertEquals(ONE,MistypeUtil.levensteinDistance("ab","a"));
    }

    public void testLevensteinDistance13() throws Exception {
        assertEquals(SEVEN,MistypeUtil.levensteinDistance("some long string","some long string string"));
    }

    public void testLevensteinDistance14() throws Exception {
        assertEquals(ONE,MistypeUtil.levensteinDistance("abc","abx"));
    }

    public void testLevensteinDistance15() throws Exception {
        assertEquals(ONE,MistypeUtil.levensteinDistance("ac","bc"));
    }

    public void testLevensteinDistance16() throws Exception {
        assertEquals(SIX,MistypeUtil.levensteinDistance("xabxcdxxefxgx","1ab2cd34ef5g6"));
    }
}