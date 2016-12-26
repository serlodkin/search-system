package org.search.system.cached;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.search.system.dao.WordDao;
import org.search.system.models.Word;

import java.util.concurrent.TimeUnit;

import static com.google.common.cache.CacheBuilder.newBuilder;

/**
 * Created by Daniil on 26.12.2016.
 */
public class WordCache {
    public static LoadingCache<String, Word> wordCache = newBuilder()
            .maximumSize(1000)
            .expireAfterAccess(10, TimeUnit.HOURS)
            .build(new CacheLoader<String, Word>() {
                @Override
                public Word load(String word) throws Exception {
                    WordDao wordDao = new WordDao();
                    return wordDao.getWord(word);
                }
            });
}
