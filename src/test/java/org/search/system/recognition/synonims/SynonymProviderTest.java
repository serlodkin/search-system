package org.search.system.recognition.synonims;

import junit.framework.TestCase;
import org.search.system.dao.WordDao;
import org.search.system.models.Word;

import java.util.ArrayList;

public class SynonymProviderTest extends TestCase {
    @Override
    public void setUp() throws Exception {
        super.setUp();
        WordDao wordDao = new WordDao();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        wordDao.insertPage(new Word("data", synonyms));
    }

    public void testGetSynonymsFromDB() throws Exception {
        SynonymProvider synonymProvider = new SynonymProvider();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        assertEquals(synonyms, synonymProvider.getSynonymsFromDB("data"));
    }

}