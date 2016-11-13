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
import java.util.stream.Collectors;

public class HtmlParser implements Parser{
    private String getMetaTag(Document document, String attr) {
        Elements elements = document.select("meta[name=" + attr + "]");
        for (Element element : elements) {
            final String s = element.attr("content");
            if (s != null) return s;
        }
        elements = document.select("meta[property=" + attr + "]");
        for (Element element : elements) {
            final String s = element.attr("content");
            if (s != null) return s;
        }
        return null;
    }

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

            ArrayList<String> tags = new ArrayList<>((Arrays.asList(keywords.split(",")))
                    .stream()
                    .map(String::trim)
                    .collect(Collectors.toList()));
            tags.addAll(titles);

            return new Page(title,description,tags,url,0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
