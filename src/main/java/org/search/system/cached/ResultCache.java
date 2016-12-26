package org.search.system.cached;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.search.system.dao.PageDao;
import org.search.system.models.Page;
import org.search.system.models.Word;
import org.search.system.processor.DataProcessor;
import org.search.system.recognition.TagsRecognizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import static com.google.common.cache.CacheBuilder.newBuilder;

/**
 * Class caching searchQuery->result
 */
public class ResultCache {
    public static LoadingCache<String, ArrayList<Page>> resultsCache;

    {
        resultsCache = newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(10, TimeUnit.HOURS)
                .build(new CacheLoader<String, ArrayList<Page>>() {
                    @Override
                    public ArrayList<Page> load(String searchQuery) throws Exception {
                        TagsRecognizer recognizer = new TagsRecognizer();
                        ArrayList<Word> tags = recognizer.recognize(searchQuery);
                        HashMap<String, HashSet<Page>> resultByTag = new HashMap<>();
                        PageDao pageDao = new PageDao();
                        HashSet<Page> temp = new HashSet<>();
                        for (Word tag : tags) {
                            temp.addAll(pageDao.getPages(tag.getWord()));

                            for (String synonym : tag.getSynonyms()) {
                                temp.addAll(pageDao.getPages(synonym));
                            }
                            resultByTag.put(tag.getWord(), (HashSet<Page>) temp.clone());
                            temp.clear();
                        }

                        DataProcessor dataProcessor = new DataProcessor();
                        return dataProcessor.process(resultByTag, tags);
                    }
                });
    }
}
