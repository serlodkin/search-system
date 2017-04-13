package org.search.system.managers;

import com.google.gson.Gson;
import junit.framework.TestCase;
import org.bson.Document;
import org.search.system.dao.PageDao;
import org.search.system.dao.WordDao;
import org.search.system.interfaces.Page;
import org.search.system.models.MongoInstance;
import org.search.system.models.NullablePage;
import org.search.system.models.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniil on 13.04.2017.
 */
public class DatabaseManagerTest extends TestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        WordDao wordDao = new WordDao();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        wordDao.insertPage(new Word("data", synonyms));
        PageDao pageDao = new PageDao();
        ArrayList<String> test = new ArrayList<>();
        test.add("test");
        test.add("tests");
        test.add("testing");
        pageDao.insertPage(new NullablePage("Test", "test test", test, "http://example.com", 0));
    }

    public void testFind() throws Exception {
        DatabaseManager databaseManager = new DatabaseManager();
        Document query = null;
        List<Document> documents = databaseManager.find("pages", "test", query);
        ArrayList<Page> result = new ArrayList<>();
        Gson gson = new Gson();
        for (Document document : documents) {
            result.add(gson.fromJson(document.toJson(), NullablePage.class));
        }
        ArrayList<String> excepted = new ArrayList<>();
        excepted.add("test");
        excepted.add("tests");
        excepted.add("testing");
        assertEquals(excepted, result.get(0).getTags());
    }

    public void testFindOne() throws Exception {
        DatabaseManager databaseManager = new DatabaseManager();
        Document query = new Document();
        query.put("word", "data");
        Document document = databaseManager.findOne("synonyms", "synonyms", query);
        Gson gson = new Gson();
        ArrayList<String> synonyms = new ArrayList<>();
        synonyms.add("statistics");
        synonyms.add("documents");
        Word excepted = new Word("data", synonyms);
        Word actual = gson.fromJson(document.toJson(), Word.class);
        assertEquals(excepted.getWord(), actual.getWord());
        assertEquals(excepted.getSynonyms(), actual.getSynonyms());
    }

    public void testGetInstance() throws Exception {
        DatabaseManager databaseManager = new DatabaseManager();
        MongoInstance exceptedInstance = new MongoInstance("localhost", 27017);
        MongoInstance instance = databaseManager.getInstance();
        assertEquals(exceptedInstance.getHost(), instance.getHost());
        assertEquals(exceptedInstance.getPort(), instance.getPort());
        assertEquals(exceptedInstance.getSize(), instance.getSize());
    }


}