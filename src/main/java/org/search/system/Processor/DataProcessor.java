package org.search.system.Processor;

import org.search.system.models.Page;
import org.search.system.models.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Daniil Matkov on 04.11.16.
 */
public class DataProcessor {
    public ArrayList<Page> process(HashMap<String, HashSet<Page>> tagResult, ArrayList<Word> tags) {
        ArrayList<Page> res = new ArrayList<Page>();
        if (tagResult.size() == 0) {
            return res;
        }
        HashSet<Page> result = new HashSet<>(tagResult.get(tags.get(0).getWord()));
        for (int index = 1; index < tags.size(); index++) {
            result.retainAll(tagResult.get(tags.get(index).getWord()));
        }
        res.addAll(result);
        return res;
    }
}
