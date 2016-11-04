package org.search.system.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.search.system.models.Word;
import org.search.system.recognition.TagsRecognizer;

import java.util.ArrayList;

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
        //for(String tag:)

        return SUCCESS;
    }

}