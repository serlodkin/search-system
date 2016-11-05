package org.search.system.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.search.system.dao.PageDao;
import org.search.system.models.Page;
import org.search.system.models.Word;
import org.search.system.processor.DataProcessor;
import org.search.system.recognition.TagsRecognizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ResultAction extends ActionSupport{
    private String searchQuery;

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @Override
    public String execute(){
        TagsRecognizer recognizer = new TagsRecognizer();
        ArrayList<Word> tags = recognizer.recognize(searchQuery);
        HashMap<String, HashSet<Page>> resultByTag = new HashMap<>();
        PageDao pageDao = new PageDao();
        HashSet<Page> temp = new HashSet<>();
        for (Word tag : tags) {
            temp.addAll(pageDao.getPages(tag.getWord()));
            for (String synonim : tag.getSynonims()) {
                temp.addAll(pageDao.getPages(synonim));
            }
            resultByTag.put(tag.getWord(), temp);
            temp.clear();
        }
        DataProcessor dataProcessor = new DataProcessor();
        ArrayList<Page> result = dataProcessor.process(resultByTag, tags);

        return SUCCESS;
    }

}