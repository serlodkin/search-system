package org.search.system.cached;

import junit.framework.TestCase;
import org.search.system.dao.PageDao;
import org.search.system.models.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


/**
 * Created by Daniil on 26.12.2016.
 */
public class PageCacheTest extends TestCase {
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

    public void test() throws ExecutionException {
        List<String> excepted = new ArrayList<>();
        excepted.add("test");
        excepted.add("tests");
        excepted.add("testing");
        List<Page> actual = PageCache.pageCache.get("test");
        assertEquals(excepted, actual.get(0).getTags());

    }
}