package org.search.system.recognition.synonims;

import org.search.system.dao.WordDao;

import java.util.ArrayList;


public class SynonimProvider {
    public ArrayList<String> getSynonymsFromDB(String word) {
        WordDao wordDao = new WordDao();
        return wordDao.getWord(word).getSynonims();
    }

}
