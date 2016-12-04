package org.search.system.recognition;

import junit.framework.TestCase;
import org.junit.Test;
import org.search.system.dao.WordDao;
import org.search.system.models.Word;

import java.util.ArrayList;

public class TagsRecognizerTest extends TestCase {

    @Override
    public void setUp() throws Exception {
        WordDao wordDao = new WordDao();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        wordDao.insert(new Word("data", synonyms));
        super.setUp();
    }

    @Test
    public void testRecognize() throws Exception {
        TagsRecognizer tagsRecognizer = new TagsRecognizer();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        assertEquals("data", tagsRecognizer.recognize("data").get(0).getWord());
        assertEquals(synonyms, tagsRecognizer.recognize("data").get(0).getSynonyms());
    }

}