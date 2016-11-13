package org.search.system;

import junit.framework.TestCase;
import org.search.system.parsers.HtmlParser;

import java.util.ArrayList;

public class HtmlParserTest extends TestCase {

    public void testParse1() throws Exception{
        HtmlParser parser=new HtmlParser();
        assertEquals(0, parser.parse("https://habrahabr.ru/").getRang());
        assertEquals("Интересные публикации / Хабрахабр", parser.parse("https://habrahabr.ru/").getTitle());
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
        excepted.add("Чат");
        excepted.add("случайный чат");
        excepted.add("беседа");
        excepted.add("поболтать");
        excepted.add("развлечение");
        excepted.add("досуг");
        excepted.add("Анонимный");
        excepted.add("чат");
        excepted.add("Анонимный");
        excepted.add("чат,разговор");
        excepted.add("с");
        excepted.add("незнакомцем,случайная");
        excepted.add("беседа");
        assertEquals("Анонимный чат", parser.parse("https://anonimplace.com/").getTitle());
        assertEquals("https://anonimplace.com/", parser.parse("https://anonimplace.com/").getLink());
        assertEquals("Анонимный чат,разговор с незнакомцем,случайная беседа", parser.parse("https://anonimplace.com/").getDescription());
        assertEquals(0, parser.parse("https://anonimplace.com/").getRang());
        assertEquals(excepted, parser.parse("https://anonimplace.com/").getTags());
    }


}