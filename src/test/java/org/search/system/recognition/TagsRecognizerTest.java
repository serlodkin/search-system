package org.search.system.recognition;

import junit.framework.TestCase;

public class TagsRecognizerTest extends TestCase {
    public void testRecognize() throws Exception {

        TagsRecognizer t = new TagsRecognizer();
        System.out.print(t.recognize("data"));
    }

}