package org.search.system.models;

import java.util.ArrayList;

/**
 * user model.
 */
public class User {
    private String address;
    private String country;
    private String language;
    private ArrayList<String> history = new ArrayList<>();


    public User(String address, String country, String language) {
        this.address = address;
        this.country = country;
        this.language = language;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void addToHistory(String request) {
        history.add(request);
    }

    public void clearHistory() {
        history.clear();
    }

    public void deleteHistory(String toDelete) {
        history.remove(toDelete);
    }

    public void deleteHistory(int toDelete) {
        history.remove(toDelete);
    }
}
