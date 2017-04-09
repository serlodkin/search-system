package org.search.system.utils;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Daniil on 11.01.2017.
 */
public class LogUtilTest extends TestCase {

    public void testLog() throws Exception {
        LogUtil.log("some info");
        String temp = "";
        try (BufferedReader br = new BufferedReader(new FileReader("search_system_log.log"))) {
            String line = br.readLine();
            if (line != null) {
                temp = line;
            }
            while (line != null) {
                line = br.readLine();
                if (line != null) {
                    temp = line;
                }
            }
        }
        assertEquals(true, temp.contains("some info"));
    }

    public void testLog1() throws Exception {
        LogUtil.log("Какая-то информация");
        String temp = "";
        try (BufferedReader br = new BufferedReader(new FileReader("search_system_log.log"))) {
            String line = br.readLine();
            if (line != null) {
                temp = line;
            }
            while (line != null) {
                line = br.readLine();
                if (line != null) {
                    temp = line;
                }
            }
        }
        assertEquals(true, temp.contains("Какая-то информация"));
    }

    public void testLog2() throws Exception {
        LogUtil.log("¬æѰ%");
        String temp = "";
        try (BufferedReader br = new BufferedReader(new FileReader("search_system_log.log"))) {
            String line = br.readLine();
            if (line != null) {
                temp = line;
            }
            while (line != null) {
                line = br.readLine();
                if (line != null) {
                    temp = line;
                }
            }
        }
        assertEquals(true, temp.contains("¬æѰ%"));
    }

    public void testLog3() throws Exception {
        LogUtil.log("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        String temp = "";
        try (BufferedReader br = new BufferedReader(new FileReader("search_system_log.log"))) {
            String line = br.readLine();
            if (line != null) {
                temp = line;
            }
            while (line != null) {
                line = br.readLine();
                if (line != null) {
                    temp = line;
                }
            }
        }
        assertEquals(true, temp.contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
    }

    public void testLog4() throws Exception {
        LogUtil.log("a69f73cca23a9ac5c8b567dc185a756e97c982164fe25859e0d1dcc1475c80a615b2123af1f5f94c11e3e9402c3ac558f500199d95b6d3e301758586281dcd26");
        String temp = "";
        try (BufferedReader br = new BufferedReader(new FileReader("search_system_log.log"))) {
            String line = br.readLine();
            if (line != null) {
                temp = line;
            }
            while (line != null) {
                line = br.readLine();
                if (line != null) {
                    temp = line;
                }
            }
        }
        assertEquals(true, temp.contains("a69f73cca23a9ac5c8b567dc185a756e97c982164fe25859e0d1dcc1475c80a615b2123af1f5f94c11e3e9402c3ac558f500199d95b6d3e301758586281dcd26"));
    }

    public void testLog5() throws Exception {
        LogUtil.log("cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e");
        String temp = "";
        try (BufferedReader br = new BufferedReader(new FileReader("search_system_log.log"))) {
            String line = br.readLine();
            if (line != null) {
                temp = line;
            }
            while (line != null) {
                line = br.readLine();
                if (line != null) {
                    temp = line;
                }
            }
        }
        assertEquals(true, temp.contains("cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e"));
    }
}