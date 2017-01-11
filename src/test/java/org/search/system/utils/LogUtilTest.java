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
        assertEquals(temp.contains("some info"), true);
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
        assertEquals(temp.contains("Какая-то информация"), true);
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
        assertEquals(temp.contains("¬æѰ%"), true);
    }

}