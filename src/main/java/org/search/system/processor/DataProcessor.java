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

package org.search.system.processor;

import org.search.system.models.Page;
import org.search.system.models.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
 * Processes data from diffrent tag search results
 * @author Daniil Matkov
 */
public class DataProcessor {
    /*
     * @param tagResult {@link HashMap} of keyword to search results for this keyword
     * @param tags      {@link ArrayList} of {@link Word} all keywords from user request
     * @return {@link ArrayList} contains {@link Page} which v
     */

    public ArrayList<Page> process(HashMap<String, HashSet<Page>> tagResult, ArrayList<Word> tags) {
        ArrayList<Page> res = new ArrayList<>();
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
