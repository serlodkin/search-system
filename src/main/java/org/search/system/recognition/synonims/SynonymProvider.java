package org.search.system.recognition.synonims;

import org.search.system.dao.WordDao;

import java.util.ArrayList;


public class SynonymProvider {
    /**Provides all synonyms to given from database
     * @param word to find synonyms
     * @return List of synonyms to given word
     */
    public ArrayList<String> getSynonymsFromDB(String word) {
        WordDao wordDao = new WordDao();
        return wordDao.getWord(word).getSynonyms();
    }

}
