package org.search.system.cached;

import junit.framework.TestCase;
import org.search.system.dao.WordDao;
import org.search.system.models.Word;

import java.util.ArrayList;

/**
 * Created by Daniil on 26.12.2016.
 */
public class TagsRecognizerCacheTest extends TestCase {
    @Override
    public void setUp() throws Exception {
        super.setUp();
        WordDao wordDao = new WordDao();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        wordDao.insert(new Word("data", synonyms));
    }

    public void testRecognize() throws Exception {
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        assertEquals("data", TagsRecognizerCache.tagsCache.get("data").get(0).getWord());
        assertEquals(synonyms, TagsRecognizerCache.tagsCache.get("data").get(0).getSynonyms());
    }

}