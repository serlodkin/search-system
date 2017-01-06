/*
MIT License

Copyright (c) 2016 Daniil Matkov

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package org.search.system.cached;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.search.system.dao.WordDao;
import org.search.system.models.Word;

import java.util.concurrent.TimeUnit;

import static com.google.common.cache.CacheBuilder.newBuilder;

/*
 * Class contains cache for getting  {@link Word} by keyword from database using {@link WordDao}
 * @author Daniil Matkov
 */
public class WordCache {

    private static final int MAX_SIZE = 1000;

    private static final int MAX_TIME = 10;

    public static LoadingCache<String, Word> wordCache = newBuilder()
            .maximumSize(MAX_SIZE)
            .expireAfterAccess(MAX_TIME, TimeUnit.HOURS)
            .build(new CacheLoader<String, Word>() {
                @Override
                public Word load(String word) throws Exception {
                    WordDao wordDao = new WordDao();
                    return wordDao.getWord(word);
                }
            });
}
