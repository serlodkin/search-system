package org.search.system.models.validated;

import org.search.system.interfaces.Page;
import org.search.system.models.NullablePage;

import java.util.List;

/*
 * Class contains main info about web-page null-safe
 * @author Daniil Matkov
 */
public class ValidatedPage implements Page {

    private NullablePage origin;

    public ValidatedPage(String title, String description, List<String> tags, String link, long rang) throws IllegalArgumentException {
        validate(title, description, tags, link);
        origin = new NullablePage(title, description, tags, link, rang);
    }

    private void validate(String title, String description, List<String> tags, String link) throws IllegalArgumentException {
        if (title == null) {
            throw new IllegalArgumentException();
        }

        if (description == null) {
            throw new IllegalArgumentException();
        }

        if (tags == null) {
            throw new IllegalArgumentException();
        }

        if (link == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getTitle() {
        return this.origin.getTitle();
    }

    @Override
    public String getDescription() {
        return this.origin.getDescription();
    }

    @Override
    public String getLink() {
        return this.origin.getLink();
    }

    @Override
    public long getRang() {
        return this.origin.getRang();
    }

    @Override
    public List<String> getTags() {
        return this.origin.getTags();
    }

    @Override
    public int compareTo(Object o) {
        return this.origin.compareTo(o);
    }
}
