package org.search.system.dao;

import junit.framework.TestCase;
import org.search.system.models.Word;

import java.util.ArrayList;

/**
 * Created by Daniil Matkov on 04.11.16.
 */
public class WordDaoTest extends TestCase {

    public void testInsert() throws Exception {
        WordDao wordDao = new WordDao();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("testing");
        synonyms.add("tests");
        Word excepted = new Word("test", synonyms);
        wordDao.insertPage(excepted);
        Word result = wordDao.getWord("test");
        assertEquals(excepted.getWord(), result.getWord());
        assertEquals(excepted.getSynonyms(), result.getSynonyms());

    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        WordDao wordDao = new WordDao();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        wordDao.insertPage(new Word("data", synonyms));
    }

    public void testGetWord() throws Exception {
        WordDao wordDao = new WordDao();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        Word excepted = new Word("data", synonyms);
        Word result = wordDao.getWord("data");
        assertEquals(excepted.getWord(), result.getWord());
        assertEquals(excepted.getSynonyms(), result.getSynonyms());
    }

}