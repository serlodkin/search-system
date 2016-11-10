package org.search.system.models;


import java.util.ArrayList;

public class Word {
    private String word;
    private ArrayList<String> synonims;

    public Word(String word, ArrayList<String> synonims) {
        this.word = word;
        this.synonims = synonims;
    }

    public ArrayList<String> getSynonims() {
        return synonims;
    }

    public String getWord() {
        if (word == null) {
            return "";
        }

        return word;
    }
}
