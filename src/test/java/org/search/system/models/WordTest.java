package org.search.system.models;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Daniil on 11.01.2017.
 */
public class WordTest extends TestCase {

    public void testGetSynonyms() throws Exception {
        Word word = new Word("word", new ArrayList<>());
        assertEquals(new ArrayList<String>(), word.getSynonyms());
    }

    public void testGetWord() throws Exception {
        Word word = new Word("word", new ArrayList<>());
        assertEquals("word", word.getWord());
    }

    public void testGetWordNull() throws Exception {
        Word word = new Word(null, new ArrayList<>());
        assertEquals("", word.getWord());
    }

    public void testGetSynonymsNull() throws Exception {
        Word word = new Word("word", null);
        assertEquals(new ArrayList<String>(), word.getSynonyms());
    }

    public void testNull() throws Exception {
        Word word = new Word(null, null);
        assertEquals("", word.getWord());
        assertEquals(new ArrayList<String>(), word.getSynonyms());
    }
}