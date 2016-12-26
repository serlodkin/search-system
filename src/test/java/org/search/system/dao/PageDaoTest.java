package org.search.system.dao;

import junit.framework.TestCase;
import org.junit.Test;
import org.search.system.models.Page;

import java.util.ArrayList;
import java.util.List;

public class PageDaoTest extends TestCase {
    @Override
    public void setUp() throws Exception {
        super.setUp();
        PageDao pageDao = new PageDao();
        ArrayList<String> test = new ArrayList<>();
        test.add("test");
        test.add("tests");
        test.add("testing");
        pageDao.insert(new Page("Test", "test test", test, "http://example.com", 0));
    }
    @Test
    public void testInsert() throws Exception {
        PageDao pageDao = new PageDao();
        ArrayList<String> test = new ArrayList<>();
        test.add("data");
        test.add("Data");
        Page excepted = new Page("Data", "data", test, "http://example.com", 0);
        pageDao.insert(excepted);
        Page result = pageDao.getPages("data").get(0);
        assertEquals(excepted.getDescription(), result.getDescription());
        assertEquals(excepted.getLink(), result.getLink());
        assertEquals(excepted.getTags(), result.getTags());
        assertEquals(excepted.getRang(), result.getRang());
        assertEquals(excepted.getTitle(), result.getTitle());
    }
    @Test
    public void testGetPages() throws Exception {
        PageDao pageDao = new PageDao();
        ArrayList<String> excepted = new ArrayList<>();
        excepted.add("test");
        excepted.add("tests");
        excepted.add("testing");

        List<Page> result = pageDao.getPages("test");
        assertEquals(excepted, result.get(0).getTags());
    }

}