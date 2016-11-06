package org.search.system.recognition.synonims;

import junit.framework.TestCase;

import java.util.ArrayList;

public class SynonimProviderTest extends TestCase {
    public void testGetSynonymsFromDB() throws Exception {
        SynonimProvider synonimProvider = new SynonimProvider();
        ArrayList<String> synonims = new ArrayList<>();
        synonims.add("statistics");
        synonims.add("documents");
        assertEquals(synonims, synonimProvider.getSynonymsFromDB("data"));
    }

}