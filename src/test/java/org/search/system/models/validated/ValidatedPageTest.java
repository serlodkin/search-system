package org.search.system.models.validated;

import junit.framework.TestCase;
import org.search.system.interfaces.Page;

import java.util.ArrayList;

/**
 * Created by Daniil on 22.01.2017.
 */
public class ValidatedPageTest extends TestCase {

    public void testGetTitle() throws Exception {
        Page page = new ValidatedPage("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals("some title", page.getTitle());
    }

    public void testGetDescription() throws Exception {
        Page page = new ValidatedPage("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals("some description", page.getDescription());
    }

    public void testGetLink() throws Exception {
        Page page = new ValidatedPage("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals("http://example.com", page.getLink());
    }

    public void testGetRang() throws Exception {
        Page page = new ValidatedPage("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals(0, page.getRang());
    }

    public void testGetTags() throws Exception {
        Page page = new ValidatedPage("some title", "some description", new ArrayList<>(), "http://example.com", 0);
        assertEquals(new ArrayList<String>(), page.getTags());
    }

    public void testGetTitleNull() throws Exception {
        try {
            Page page = new ValidatedPage(null, "some description", new ArrayList<>(), "http://example.com", 0);
        } catch (Exception exception) {
            assertEquals(new IllegalArgumentException().toString(), exception.toString());
        }
    }

    public void testGetDescriptionNull() throws Exception {
        try {
            Page page = new ValidatedPage("some title", null, new ArrayList<>(), "http://example.com", 0);
        } catch (Exception exception) {
            assertEquals(new IllegalArgumentException().toString(), exception.toString());
        }
    }

    public void testGetLinkNull() throws Exception {
        try {
            Page page = new ValidatedPage("some title", "some description", new ArrayList<>(), null, 0);
        } catch (Exception exception) {
            assertEquals(new IllegalArgumentException().toString(), exception.toString());
        }
    }

    public void testGetTagsNull() throws Exception {
        try {
            Page page = new ValidatedPage("some title", "some description", null, "http://example.com", 0);
        } catch (Exception exception) {
            assertEquals(new IllegalArgumentException().toString(), exception.toString());
        }
    }


}