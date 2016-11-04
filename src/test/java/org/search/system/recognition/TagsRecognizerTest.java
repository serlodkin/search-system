package org.search.system.recognition;

import junit.framework.TestCase;

import java.util.ArrayList;

public class TagsRecognizerTest extends TestCase {
    public void testRecognize() throws Exception {

        TagsRecognizer t = new TagsRecognizer();
        ArrayList<String> synonims = new ArrayList<>();
        synonims.add("statistics");
        synonims.add("documents");
        assertEquals(t.recognize("data").get(0).getWord(), "data");
        assertEquals(t.recognize("data").get(0).getSynonims(), synonims);
    }

}