package org.search.system.models;

import junit.framework.TestCase;
import org.search.system.interfaces.Page;

import java.util.ArrayList;

/**
 * Created by Daniil on 11.01.2017.
 */
public class NullablePageTest extends TestCase {
    public void testGetTitle() throws Exception {
        Page page = new NullablePage("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals("some title", page.getTitle());

    }

    public void testGetDescription() throws Exception {
        Page page = new NullablePage("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals("some description", page.getDescription());
    }

    public void testGetLink() throws Exception {
        Page page = new NullablePage("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals("http://example.com", page.getLink());
    }

    public void testGetRang() throws Exception {
        Page page = new NullablePage("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals(0, page.getRang());
    }

    public void testGetTags() throws Exception {
        Page page = new NullablePage("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals(new ArrayList<String>(), page.getTags());
    }

    public void testGetTitleNull() throws Exception {
        Page page = new NullablePage(null, "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals(null, page.getTitle());
    }

    public void testGetDescriptionNull() throws Exception {
        Page page = new NullablePage("some title", null, new ArrayList<>(), "http://example.com", 0);
        assertEquals(null, page.getDescription());
    }

    public void testGetLinkNull() throws Exception {
        Page page = new NullablePage("some title", "some description", new ArrayList<>(), null, 0);
        assertEquals(null, page.getLink());
    }

    public void testGetTagsNull() throws Exception {
        Page page = new NullablePage("some title", "some description", null, "http://example.com", 0);
        assertEquals(null, page.getTags());
    }


}