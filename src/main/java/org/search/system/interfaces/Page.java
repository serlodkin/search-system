package org.search.system.interfaces;

import java.util.List;

/*
 * Interface describes all pages
 *
 * @author Daniil Matkov
 */
public interface Page extends Comparable {
    String getTitle();

    String getDescription();

    String getLink();

    long getRang();

    List<String> getTags();

    @Override
    int compareTo(Object o);

    @Override
    String toString();
}
