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

package org.search.system.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.search.system.interfaces.Parser;
import org.search.system.models.Page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;


/*
 * Parser web page
 * implements {@link Parser}
 *
 * @author Daniil Matkov
 */
public class HtmlParser implements Parser{
    private String getMetaTag(Document document, String attr) {
        Elements elements = document.select("meta[name=" + attr + "]");
        for (Element element : elements) {
            final String s = element.attr("content");
            if (s != null) {
                return s;
            }
        }
        elements = document.select("meta[property=" + attr + "]");
        return elements.stream().map(element -> element.attr("content")).filter(Objects::nonNull).findFirst().orElse(null);
    }

    /**
     * Parses web page meta info,find title,metaTags,description
     * @param url web page url
     * @return {@link Page} object which contains main info about given page
     */
    @Override
    public Page parse(String url) {
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            String title = doc.title();
            if(title==null){
                title="";
            }
            String description=getMetaTag(doc,"description");
            if (description==null){
                description="";
            }
            String keywords=getMetaTag(doc,"keywords");
            if (keywords==null){
                keywords="";
            }

            ArrayList<String> titles = new ArrayList<>((Arrays.asList(title.split(" ")))
                    .stream()
                    .map(String::trim)
                    .collect(Collectors.toList()));
            ArrayList<String> descriptions = new ArrayList<>((Arrays.asList(description.split(" ")))
                    .stream()
                    .map(String::trim)
                    .collect(Collectors.toList()));
            ArrayList<String> tags = new ArrayList<>((Arrays.asList(keywords.split(",")))
                    .stream()
                    .map(String::trim)
                    .collect(Collectors.toList()));
            tags.addAll(titles);
            tags.addAll(descriptions);
            return new Page(title,description,tags,url,0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
