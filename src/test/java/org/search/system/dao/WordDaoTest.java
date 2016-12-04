package org.search.system.dao;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.search.system.models.Word;

import java.util.ArrayList;

/**
 * Created by Daniil Matkov on 04.11.16.
 */
public class WordDaoTest extends TestCase {
    @Test
    public void testInsert() throws Exception {
        WordDao wordDao = new WordDao();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("testing");
        synonyms.add("tests");
        wordDao.insert(new Word("test", synonyms));
    }

    @BeforeClass
    @Override
    public void setUp() {
        WordDao wordDao = new WordDao();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        wordDao.insert(new Word("data", synonyms));
    }

    @Test
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