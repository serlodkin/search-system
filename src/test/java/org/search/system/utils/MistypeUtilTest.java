package org.search.system.utils;

import junit.framework.TestCase;

/**
 * Created by exam on 22.04.2017.
 */
public class MistypeUtilTest extends TestCase {

    public void testLevensteinDistance() throws Exception {
        assertEquals(1,MistypeUtil.LevensteinDistance("fog","frog"));
    }

    public void testLevensteinDistance1() throws Exception {
        assertEquals(3,MistypeUtil.LevensteinDistance("AGCAT","GAC"));
    }

    public void testLevensteinDistance2() throws Exception {
        assertEquals(3,MistypeUtil.LevensteinDistance("example","samples"));
    }

    public void testLevensteinDistance3() throws Exception {
        assertEquals(6,MistypeUtil.LevensteinDistance("levenshtein","frankenstein"));
    }

    public void testLevensteinDistance4() throws Exception {
        assertEquals(5,MistypeUtil.LevensteinDistance("distance","difference"));
    }

    public void testLevensteinDistance5() throws Exception {
        assertEquals(4,MistypeUtil.LevensteinDistance("scala is great","scala is not great"));
    }

    public void testLevensteinDistance6() throws Exception {
        assertEquals(0,MistypeUtil.LevensteinDistance("",""));
    }

    public void testLevensteinDistance7() throws Exception {
        assertEquals(0,MistypeUtil.LevensteinDistance("abc","abc"));
    }

    public void testLevensteinDistance8() throws Exception {
        assertEquals(0,MistypeUtil.LevensteinDistance("some long string","some long string"));
    }

    public void testLevensteinDistance9() throws Exception {
        assertEquals(6,MistypeUtil.LevensteinDistance("levenshtein","frankenstein"));
    }

    public void testLevensteinDistance10() throws Exception {
        assertEquals(1,MistypeUtil.LevensteinDistance("","a"));
    }

    public void testLevensteinDistance11() throws Exception {
        assertEquals(1,MistypeUtil.LevensteinDistance("a","ab"));
    }

    public void testLevensteinDistance12() throws Exception {
        assertEquals(1,MistypeUtil.LevensteinDistance("ab","a"));
    }

    public void testLevensteinDistance13() throws Exception {
        assertEquals(7,MistypeUtil.LevensteinDistance("some long string","some long string string"));
    }

    public void testLevensteinDistance14() throws Exception {
        assertEquals(1,MistypeUtil.LevensteinDistance("abc","abx"));
    }

    public void testLevensteinDistance15() throws Exception {
        assertEquals(1,MistypeUtil.LevensteinDistance("ac","bc"));
    }

    public void testLevensteinDistance16() throws Exception {
        assertEquals(6,MistypeUtil.LevensteinDistance("xabxcdxxefxgx","1ab2cd34ef5g6"));
    }
}