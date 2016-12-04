package org.search.system.recognition.synonims;

import junit.framework.TestCase;

import java.util.ArrayList;

public class SynonymProviderTest extends TestCase {
    public void testGetSynonymsFromDB() throws Exception {
        SynonymProvider synonymProvider = new SynonymProvider();
        ArrayList<String> synonims = new ArrayList<>();
        synonims.add("statistics");
        synonims.add("documents");
        assertEquals(synonims, synonymProvider.getSynonymsFromDB("data"));
    }

}