package org.search.system.models;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Daniil on 11.01.2017.
 */
public class WordTest extends TestCase {

    private static final int ARRAY_LENGTH = 5000000;

    public void testGetSynonyms() throws Exception {
        Word word = new Word("word", new ArrayList<>());
        assertEquals(new ArrayList<String>(), word.getSynonyms());
    }

    public void testGetSynonyms1() throws Exception {
        ArrayList<String> s = new ArrayList<>();
        s.add("test");
        s.add("testing");
        Word word = new Word("another word", s);
        assertEquals(s, word.getSynonyms());
    }

    public void testGetSynonyms2() throws Exception {
        ArrayList<String> s = new ArrayList<>();
        s.add("data");
        s.add("ping");
        s.add("pong");
        Word word = new Word("word", s);
        assertEquals(s, word.getSynonyms());
    }

    public void testGetSynonyms3() throws Exception {
        ArrayList<String> s = new ArrayList<>();
        for (int value = 0; value < ARRAY_LENGTH; value++) {
            s.add(Integer.toString(value));
        }
        Word word = new Word("word", s);
        assertEquals(s, word.getSynonyms());
    }

    public void testGetWord() throws Exception {
        Word word = new Word("word", new ArrayList<>());
        assertEquals("word", word.getWord());
    }

    public void testGetWord1() throws Exception {
        ArrayList<String> s = new ArrayList<>();
        s.add("data");
        s.add("ping");
        s.add("pong");
        Word word = new Word("Another word", s);
        assertEquals("Another word", word.getWord());
        assertEquals(s, word.getSynonyms());
    }

    public void testGetWord2() throws Exception {
        Word word = new Word("Yet another word", new ArrayList<>());
        assertEquals("Yet another word", word.getWord());
        assertEquals(new ArrayList<>(), word.getSynonyms());
    }

    public void testGetWordNull() throws Exception {
        Word word = new Word(null, new ArrayList<>());
        assertEquals("", word.getWord());
    }

    public void testGetWordNull1() throws Exception {
        ArrayList<String> s = new ArrayList<>();
        s.add("data");
        s.add("ping");
        s.add("pong");
        Word word = new Word(null, s);
        assertEquals("", word.getWord());
        assertEquals(s, word.getSynonyms());

    }

    public void testGetWordNull2() throws Exception {
        Word word = new Word(null, null);
        assertEquals("", word.getWord());
    }

    public void testGetSynonymsNull() throws Exception {
        Word word = new Word("word", null);
        assertEquals(new ArrayList<String>(), word.getSynonyms());
    }

    public void testGetSynonymsNull1() throws Exception {
        Word word = new Word("Another word", null);
        assertEquals(new ArrayList<String>(), word.getSynonyms());
    }

    public void testGetSynonymsNull2() throws Exception {
        Word word = new Word(null, null);
        assertEquals(new ArrayList<String>(), word.getSynonyms());
    }

    public void testNull() throws Exception {
        Word word = new Word(null, null);
        assertEquals("", word.getWord());
        assertEquals(new ArrayList<String>(), word.getSynonyms());
    }
}