package org.search.system.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.search.system.dao.PageDao;
import org.search.system.models.Page;
import org.search.system.models.Word;
import org.search.system.recognition.TagsRecognizer;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

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
        WeakHashMap<String, List<Page>> resultByTag = new WeakHashMap<>();
        PageDao pageDao = new PageDao();
        ArrayList<Page> temp = new ArrayList<>();
        for (Word tag : tags) {
            temp.addAll(pageDao.getPages(tag.getWord()));
            for (String synonim : tag.getSynonims()) {
                temp.addAll(pageDao.getPages(tag.getWord()));
            }
            resultByTag.put(tag.getWord(), temp);
            temp.clear();
        }
        return SUCCESS;
    }

}