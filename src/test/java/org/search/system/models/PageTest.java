package org.search.system.models;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Daniil on 11.01.2017.
 */
public class PageTest extends TestCase {
    public void testGetTitle() throws Exception {
        Page page = new Page("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals("some title", page.getTitle());
    }

    public void testGetDescription() throws Exception {
        Page page = new Page("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals("some description", page.getDescription());
    }

    public void testGetLink() throws Exception {
        Page page = new Page("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals("http://example.com", page.getLink());
    }

    public void testGetRang() throws Exception {
        Page page = new Page("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals(0, page.getRang());
    }

    public void testGetTags() throws Exception {
        Page page = new Page("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals(new ArrayList<String>(), page.getTags());
    }

}