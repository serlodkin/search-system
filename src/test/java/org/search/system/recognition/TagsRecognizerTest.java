package org.search.system.recognition;

import junit.framework.TestCase;
import org.search.system.dao.WordDao;
import org.search.system.models.Word;

import java.util.ArrayList;

public class TagsRecognizerTest extends TestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        WordDao wordDao = new WordDao();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        wordDao.insertPage(new Word("data", synonyms));
    }

    public void testRecognize() throws Exception {
        TagsRecognizer tagsRecognizer = new TagsRecognizer();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        assertEquals("data", tagsRecognizer.recognize("data").get(0).getWord());
        assertEquals(synonyms, tagsRecognizer.recognize("data").get(0).getSynonyms());
    }

}