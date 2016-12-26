package org.search.system.recognition.synonims;

import org.search.system.cached.WordCache;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class SynonymProvider {
    /**Provides all synonyms to given from database
     * @param word to find synonyms
     * @return List of synonyms to given word
     */
    public ArrayList<String> getSynonymsFromDB(String word) {
        try {
            return WordCache.wordCache.get(word).getSynonyms();
        } catch (ExecutionException e) {
            return new ArrayList<String>();
        }
    }

}
