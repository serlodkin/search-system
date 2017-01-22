package org.search.system.interfaces;

import java.util.List;

/**
 * Created by Daniil on 22.01.2017.
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
