package org.search.system.models;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Daniil on 12.01.2017.
 */
public class UserTest extends TestCase {
    public void testGetAddress() throws Exception {
        User user = new User("some address", "Russia", "Russian");
        assertEquals("some address", user.getAddress());
    }


    public void testGetLanguage() throws Exception {
        User user = new User("some address", "Russia", "Russian");
        assertEquals("Russian", user.getLanguage());
    }

    public void testGetHistory() throws Exception {
        User user = new User("some address", "Russia", "Russian");
        assertEquals(new ArrayList<String>(), user.getHistory());
    }

    public void testAddToHistory() throws Exception {
        User user = new User("some address", "Russia", "Russian");
        user.addToHistory("test");
        ArrayList<String> excepted = new ArrayList<>();
        excepted.add("test");
        assertEquals(excepted, user.getHistory());
    }

    public void testClearHistory() throws Exception {
        User user = new User("some address", "Russia", "Russian");
        user.addToHistory("test");
        user.clearHistory();
        assertEquals(new ArrayList<String>(), user.getHistory());
    }

    public void testDeleteHistory() throws Exception {
        User user = new User("some address", "Russia", "Russian");
        user.addToHistory("test");
        user.addToHistory("data");
        user.deleteHistory(0);
        ArrayList<String> excepted = new ArrayList<>();
        excepted.add("data");
        assertEquals(excepted, user.getHistory());
    }

    public void testDeleteHistory1() throws Exception {
        User user = new User("some address", "Russia", "Russian");
        user.addToHistory("test");
        user.addToHistory("data");
        user.deleteHistory("data");
        ArrayList<String> excepted = new ArrayList<>();
        excepted.add("test");
        assertEquals(excepted, user.getHistory());
    }

    public void testGetCountry() throws Exception {
        User user = new User("some address", "Russia", "Russian");
        assertEquals("Russia", user.getCountry());
    }

    public void testSetCountry() throws Exception {
        User user = new User("some address", "Russia", "Russian");
        user.setCountry("some country");
        assertEquals("some country", user.getCountry());
    }

    public void testGetId() throws Exception {
        User user = new User("some address", "Russia", "Russian");
        user.setId("da39a3ee5e6b4b0d3255bfef95601890afd80709");
        assertEquals("da39a3ee5e6b4b0d3255bfef95601890afd80709", user.getId());
    }

    public void testSetId() throws Exception {
        User user = new User("some address", "Russia", "Russian");
        user.setId("da39a3ee5e6b4b0d3255bfef95601890afd80709");
        assertEquals("da39a3ee5e6b4b0d3255bfef95601890afd80709", user.getId());
        user.setId("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855");
        assertEquals("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", user.getId());
    }

}