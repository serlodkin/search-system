package org.search.system.recognition.synonims;

import org.search.system.dao.WordDao;

import java.util.List;


public class SynonimProvider {
    public List<String> getSynonymsFromDB(String word) {
        WordDao wordDao = new WordDao();
        return wordDao.getWord(word).getSynonims();
    }

}
