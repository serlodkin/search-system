package org.search.system.recognition.synonims;

import junit.framework.TestCase;

import java.util.ArrayList;

public class SynonymProviderTest extends TestCase {
    public void testGetSynonymsFromDB() throws Exception {
        SynonymProvider synonymProvider = new SynonymProvider();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        assertEquals(synonyms, synonymProvider.getSynonymsFromDB("data"));
    }

}