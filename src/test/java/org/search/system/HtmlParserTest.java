package org.search.system;

import junit.framework.TestCase;
import org.junit.Test;
import org.search.system.parsers.HtmlParser;

import java.util.ArrayList;

public class HtmlParserTest extends TestCase {
    public void testParse() throws Exception {
        HtmlParser parser=new HtmlParser();
        ArrayList<String> excepted=new ArrayList<String>();
        excepted.add("Чат");
        excepted.add(" случайный чат");
        excepted.add(" беседа");
        excepted.add("поболтать");
        excepted.add(" развлечение");
        excepted.add(" досуг");


        assertEquals(parser.parse("https://anonimplace.com/").getTitle(),"Анонимный чат");
        assertEquals(parser.parse("https://anonimplace.com/").getLink(),"https://anonimplace.com/");
        assertEquals(parser.parse("https://anonimplace.com/").getDescription(),"Анонимный чат,разговор с незнакомцем,случайная беседа");
        assertEquals(parser.parse("https://anonimplace.com/").getRang(),0);
        assertEquals(parser.parse("https://anonimplace.com/").getTags(),excepted);

    }

    public void testParse1() throws Exception{
        HtmlParser parser=new HtmlParser();
        assertEquals(parser.parse("https://habrahabr.ru/").getRang(),0);
        assertEquals(parser.parse("https://habrahabr.ru/").getTitle(),"Интересные публикации / Хабрахабр");


    }


}