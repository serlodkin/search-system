package org.search.actions;

import com.opensymphony.xwork2.ActionSupport;

public class ResultAction extends ActionSupport{
    private String searchQuery;

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }
    
}