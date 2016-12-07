package org.search.system.models;

import java.util.List;

/**
 * Class which contains main info about html page
 */
public class Page {
    private String title;
    private String description;
    private List<String> tags;
    private String link;
    private long rang;

    public Page(String title, String description, List<String> tags, String link, long rang) {
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.link = link;
        this.rang = rang;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public String getLink() {
        return link;
    }

    public long getRang() {
        return rang;
    }

    public List<String> getTags() {
        return tags;
    }
}
