/*
MIT License

Copyright (c) 2016-2017 Daniil Matkov

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

package org.search.system.models;

import java.util.List;

/*
 * Class contains main info about web-page
 * @author Daniil Matkov
 */
public class Page implements Comparable {

    private String title;

    private String description;

    private List<String> tags;

    private String link;

    private long rang;

    public Page(String title, String description, List<String> tags, String link, long rang) {
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.link = link;
        this.rang = rang;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public String getLink() {
        return link;
    }

    public long getRang() {
        return rang;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public int compareTo(Object o) {
        Page compare = (Page) o;
        int result = Long.compare(this.rang, compare.getRang());
        if (result != 0) {
            return result;
        }
        result = this.title.compareTo(compare.getTitle());
        return result;
    }
}
