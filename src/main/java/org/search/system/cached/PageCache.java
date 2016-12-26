package org.search.system.cached;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.search.system.dao.PageDao;
import org.search.system.models.Page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.google.common.cache.CacheBuilder.newBuilder;

/**
 * Created by Daniil on 26.12.2016.
 */
public class PageCache {
    public static LoadingCache<String, List<Page>> pageCache = newBuilder()
            .maximumSize(1000)
            .expireAfterAccess(10, TimeUnit.HOURS)
            .build(new CacheLoader<String, List<Page>>() {
                @Override
                public List<Page> load(String tag) throws Exception {
                    PageDao pageDao = new PageDao();
                    return pageDao.getPages(tag);
                }
            });
}
