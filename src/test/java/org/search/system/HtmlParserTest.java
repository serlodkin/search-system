package org.search.system;

import junit.framework.TestCase;
import org.search.system.parsers.HtmlParser;

import java.util.ArrayList;

public class HtmlParserTest extends TestCase {

    public void testParse1() throws Exception{
        HtmlParser parser=new HtmlParser();
        assertEquals(0, parser.parse("https://habrahabr.ru/").getRang());
        assertEquals("Лучшие публикации за сутки / Хабрахабр", parser.parse("https://habrahabr.ru/").getTitle());
    }

    public void testParse2() throws Exception{
        HtmlParser parser=new HtmlParser();
        assertEquals("Lenta.ru", parser.parse("https://m.lenta.ru/").getTitle());
    }

    public void testParse3() throws Exception {
        HtmlParser parser = new HtmlParser();
        assertEquals("Example Domain", parser.parse("http://example.com/").getTitle());
    }

    public void testParse() throws Exception {
        HtmlParser parser=new HtmlParser();
        ArrayList<String> excepted= new ArrayList<>();
        excepted.add("java");
        excepted.add("downloads");
        excepted.add("java.com:");
        excepted.add("Java");
        excepted.add("и");
        excepted.add("вы");
        excepted.add("Загрузите");
        excepted.add("бесплатное");
        excepted.add("ПО");
        excepted.add("Java");
        excepted.add("для");
        excepted.add("Вашего");
        excepted.add("настольного");
        excepted.add("компьютера");
        excepted.add("сейчас!");
        assertEquals("java.com: Java и вы", parser.parse("https://www.java.com/ru/").getTitle());
        assertEquals("https://www.java.com/ru/", parser.parse("https://www.java.com/ru/").getLink());
        assertEquals("Загрузите бесплатное ПО Java для Вашего настольного компьютера сейчас! ", parser.parse("https://www.java.com/ru/").getDescription());
        assertEquals(0, parser.parse("https://www.java.com/ru/").getRang());
        int index=0;
        for (String tag:parser.parse("https://www.java.com/ru/").getTags()){
            assertEquals(excepted.get(index),tag);
            index++;
        }
    }
    
    public void testParse4() throws Exception {
        HtmlParser parser=new HtmlParser();
        assertEquals("C++ Shell", parser.parse("http://cpp.sh/").getTitle());
    }

    public void testParse5() throws Exception {
        HtmlParser parser = new HtmlParser();
        assertEquals("Example Domain", parser.parse("http://example.org/").getTitle());
    }

    public void testParse6() throws Exception {
        HtmlParser parser = new HtmlParser();
        assertEquals("Example Domain", parser.parse("http://example.edu/").getTitle());
    }

    public void testParser7() throws Exception {
        HtmlParser parser = new HtmlParser();
        assertEquals("http://example.com/", parser.parse("http://example.com/").getLink());
    }

}
