package org.search.system.recognition;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.search.system.dao.WordDao;
import org.search.system.models.Word;

import java.util.ArrayList;

public class TagsRecognizerTest extends TestCase {
    @BeforeClass
    public void init(){
        WordDao wordDao = new WordDao();
        ArrayList<String> synonims = new ArrayList<>();
        synonims.add("statistics");
        synonims.add("documents");
        wordDao.insert(new Word("data", synonims));
    }
    @Test
    public void testRecognize() throws Exception {
        TagsRecognizer t = new TagsRecognizer();
        ArrayList<String> synonims = new ArrayList<>();
        synonims.add("statistics");
        synonims.add("documents");
        assertEquals("data", t.recognize("data").get(0).getWord());
        assertEquals(synonims, t.recognize("data").get(0).getSynonims());
    }

}