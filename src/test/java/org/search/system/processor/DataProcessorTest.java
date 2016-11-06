package org.search.system.processor;

import junit.framework.TestCase;
import org.search.system.models.Page;
import org.search.system.models.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Daniil Matkov on 04.11.16.
 */
public class DataProcessorTest extends TestCase {
    public void testProcess() throws Exception {
        DataProcessor dataProcessor = new DataProcessor();
        HashMap<String, HashSet<Page>> test = new HashMap<>();
        HashSet<Page> first = new HashSet<>();
        HashSet<Page> second = new HashSet<>();
        ArrayList<String> synonims = new ArrayList<>();
        synonims.add("statistics");
        synonims.add("documents");
        Page t = new Page("Test", "Test", synonims, "http://example.com", 0);
        Page t1 = new Page("Test", "Data", synonims, "http://example.com", 0);
        Page t2 = new Page("Data", "Test", synonims, "http://example.com", 0);
        first.add(t1);
        first.add(t);
        second.add(t);
        second.add(t2);
        test.put("Data", first);
        test.put("Test", second);
        ArrayList<Word> d = new ArrayList<>();
        d.add(new Word("Data", new ArrayList<>()));
        d.add(new Word("Test", new ArrayList<>()));
        ArrayList<Page> result = dataProcessor.process(test, d);
        assertEquals(result.size(), 1);
        assertEquals("Test", result.get(0).getTitle());
        assertEquals(0, result.get(0).getRang());
        assertEquals("Test", result.get(0).getDescription());
        assertEquals("http://example.com", result.get(0).getLink());
    }

    public void testProcess1() throws Exception {
        DataProcessor dataProcessor = new DataProcessor();
        HashMap<String, HashSet<Page>> test = new HashMap<>();
        HashSet<Page> first = new HashSet<>();
        ArrayList<String> synonims = new ArrayList<>();
        synonims.add("statistics");
        synonims.add("documents");
        Page t = new Page("Test", "Test", synonims, "http://example.com", 0);
        Page t1 = new Page("Test", "Data", synonims, "http://example.com", 0);
        Page t2 = new Page("Data", "Test", synonims, "http://example.com", 0);
        first.add(t1);
        first.add(t2);
        test.put("Data", first);
        ArrayList<Word> d = new ArrayList<>();
        d.add(new Word("Data", new ArrayList<>()));
        ArrayList<Page> result = dataProcessor.process(test, d);
        assertEquals(result.size(), 2);

        assertEquals("http://example.com", result.get(0).getLink());
        assertEquals("Data", result.get(0).getTitle());
        assertEquals("Test", result.get(0).getDescription());
        assertEquals(0, result.get(0).getRang());

        assertEquals("http://example.com", result.get(1).getLink());
        assertEquals("Test", result.get(1).getTitle());
        assertEquals("Data", result.get(1).getDescription());
        assertEquals(0, result.get(1).getRang());

    }

    public void testProcess2() throws Exception {
        DataProcessor dataProcessor = new DataProcessor();
        HashMap<String, HashSet<Page>> test = new HashMap<>();
        ArrayList<Word> d = new ArrayList<>();
        ArrayList<Page> result = dataProcessor.process(test, d);
        assertEquals(0, result.size());
    }

}