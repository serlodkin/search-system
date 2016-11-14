package org.search.system.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.search.system.cached.ResultCache;
import org.search.system.models.Page;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ResultAction extends ActionSupport{
    private String searchQuery;
    private ArrayList<Page> result;
    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery.toLowerCase();
    }

    @Override
    public String execute() {
        result = new ArrayList<>();
        ResultCache cache = new ResultCache();
        try {
            result = cache.resultsCache.get(searchQuery);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }


    public ArrayList<Page> getResult() {
        return result;
    }

    public void setResult(ArrayList<Page> result) {
        this.result = result;
    }
}