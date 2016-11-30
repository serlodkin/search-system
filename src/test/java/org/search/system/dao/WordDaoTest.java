package org.search.system.dao;

import junit.framework.TestCase;
import org.junit.Before;
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
        ArrayList<String> synonims = new ArrayList<>();
        synonims.add("testing");
        synonims.add("tests");
        wordDao.insert(new Word("test", synonims));
    }

    @Before
    public void init() {
        WordDao wordDao = new WordDao();
        ArrayList<String> synonims = new ArrayList<>();
        synonims.add("statistics");
        synonims.add("documents");
        wordDao.insert(new Word("data", synonims));
    }

    @Test
    public void testGetWord() throws Exception {
        WordDao wordDao = new WordDao();
        ArrayList<String> synonims = new ArrayList<>();
        synonims.add("statistics");
        synonims.add("documents");
        Word excepted = new Word("data", synonims);
        Word result = wordDao.getWord("data");
        assertEquals(excepted.getWord(), result.getWord());
        assertEquals(excepted.getSynonims(), result.getSynonims());
    }

}