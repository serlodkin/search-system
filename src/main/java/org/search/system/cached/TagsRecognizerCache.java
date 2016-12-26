package org.search.system.cached;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.search.system.models.Word;
import org.search.system.recognition.TagsRecognizer;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static com.google.common.cache.CacheBuilder.newBuilder;

/**
 * Created by Daniil on 26.12.2016.
 */
public class TagsRecognizerCache {
    public static LoadingCache<String, ArrayList<Word>> tagsCache = newBuilder()
            .maximumSize(1000)
            .expireAfterAccess(10, TimeUnit.HOURS)
            .build(new CacheLoader<String, ArrayList<Word>>() {
                @Override
                public ArrayList<Word> load(String request) {
                    TagsRecognizer tagsRecognizer = new TagsRecognizer();
                    return tagsRecognizer.recognize(request);
                }
            });


}
