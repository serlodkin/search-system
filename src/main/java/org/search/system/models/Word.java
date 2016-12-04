package org.search.system.models;


import java.util.ArrayList;

public class Word {
    private String word;
    private ArrayList<String> synonyms;

    public Word(String word, ArrayList<String> synonims) {
        this.word = word;
        this.synonyms = synonims;
    }

    public ArrayList<String> getSynonyms() {
        return synonyms;
    }

    public String getWord() {
        if (word == null) {
            return "";
        }

        return word;
    }
}
