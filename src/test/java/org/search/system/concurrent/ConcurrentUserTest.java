package org.search.system.concurrent;

import junit.framework.TestCase;
import org.search.system.models.User;

import java.util.ArrayList;

/**
 * Created by Daniil on 17.01.2017.
 */
public class ConcurrentUserTest extends TestCase {

    public void testSetLanguage() throws Exception {
        ConcurrentUser user = new ConcurrentUser(new User("Some address", "Some country", "Some language"));
        user.setLanguage("another language");
        assertEquals("another language", user.getLanguage());
    }

    public void testGetAddress() throws Exception {
        ConcurrentUser user = new ConcurrentUser(new User("Some address", "Some country", "Some language"));
        assertEquals("Some address", user.getAddress());
    }

    public void testGetCountry() throws Exception {
        ConcurrentUser user = new ConcurrentUser(new User("Some address", "Some country", "Some language"));
        assertEquals("Some country", user.getCountry());
    }

    public void testSetCountry() throws Exception {
        ConcurrentUser user = new ConcurrentUser(new User("Some address", "Some country", "Some language"));
        user.setCountry("Another country");
        assertEquals("Another country", user.getCountry());
    }

    public void testGetLanguage() throws Exception {
        ConcurrentUser user = new ConcurrentUser(new User("Some address", "Some country", "Some language"));
        assertEquals("Some language", user.getLanguage());
    }

    public void testGetHistory() throws Exception {
        ConcurrentUser user = new ConcurrentUser(new User("Some address", "Some country", "Some language"));
        assertEquals(new ArrayList<String>(), user.getHistory());
    }

    public void testAddToHistory() throws Exception {
        ConcurrentUser user = new ConcurrentUser(new User("Some address", "Some country", "Some language"));
        user.addToHistory("test");
        ArrayList<String> excepted = new ArrayList<>();
        excepted.add("test");
        assertEquals(excepted, user.getHistory());
    }

    public void testClearHistory() throws Exception {
        ConcurrentUser user = new ConcurrentUser(new User("Some address", "Some country", "Some language"));
        user.addToHistory("test");
        user.clearHistory();
        assertEquals(new ArrayList<String>(), user.getHistory());
    }

    public void testDeleteHistory() throws Exception {
        ConcurrentUser user = new ConcurrentUser(new User("Some address", "Some country", "Some language"));
        user.addToHistory("test");
        user.addToHistory("data");
        user.deleteHistory(0);
        ArrayList<String> excepted = new ArrayList<>();
        excepted.add("data");
        assertEquals(excepted, user.getHistory());
    }

    public void testDeleteHistory1() throws Exception {
        ConcurrentUser user = new ConcurrentUser(new User("Some address", "Some country", "Some language"));
        user.addToHistory("test");
        user.addToHistory("data");
        user.deleteHistory("data");
        ArrayList<String> excepted = new ArrayList<>();
        excepted.add("test");
        assertEquals(excepted, user.getHistory());
    }

    public void testGetId() throws Exception {
        ConcurrentUser user = new ConcurrentUser(new User("Some address", "Some country", "Some language"));
        user.setId("da39a3ee5e6b4b0d3255bfef95601890afd80709");
        assertEquals("da39a3ee5e6b4b0d3255bfef95601890afd80709", user.getId());
    }

    public void testSetId() throws Exception {
        ConcurrentUser user = new ConcurrentUser(new User("Some address", "Some country", "Some language"));
        user.setId("da39a3ee5e6b4b0d3255bfef95601890afd80709");
        assertEquals("da39a3ee5e6b4b0d3255bfef95601890afd80709", user.getId());
        user.setId("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855");
        assertEquals("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", user.getId());
    }

}