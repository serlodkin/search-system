package org.search.system.cached;

import junit.framework.TestCase;
import org.search.system.dao.WordDao;
import org.search.system.models.Word;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Daniil on 26.12.2016.
 */
public class WordCacheTest extends TestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        WordDao wordDao = new WordDao();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        wordDao.insert(new Word("data", synonyms));
    }
    public void test() throws ExecutionException {
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        Word excepted = new Word("data", synonyms);
        Word result = WordCache.wordCache.get("data");
        assertEquals(excepted.getWord(), result.getWord());
        assertEquals(excepted.getSynonyms(), result.getSynonyms());
    }
}