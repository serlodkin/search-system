package org.search.system.models;

import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import junit.framework.TestCase;
import org.search.system.utils.LogUtil;

/**
 * Created by Daniil on 13.04.2017.
 */
public class MongoInstanceTest extends TestCase {

    private static final int TEST_PORT = 27017;

    private static final int JUST_TEST_SIZE = 10000;


    public void testGetHost() throws Exception {
        MongoInstance test = new MongoInstance("localhost", TEST_PORT);
        assertEquals("localhost", test.getHost());
    }

    public void testGetPort() throws Exception {
        MongoInstance test = new MongoInstance("localhost", TEST_PORT);
        assertEquals(TEST_PORT, test.getPort());

    }

    public void testGetSize() throws Exception {
        MongoInstance test = new MongoInstance("localhost", TEST_PORT);
        assertEquals("localhost", test.getHost());
        int size = JUST_TEST_SIZE;
        MongoClient mongo = new MongoClient(test.getHost(), test.getPort());
        try {
            DB synonyms = mongo.getDB("synonyms");
            DB pages = mongo.getDB("pages");
            CommandResult result = synonyms.getStats();
            size = (int) result.get("objects");
            result = pages.getStats();
            size += (int) result.get("objects");
            mongo.close();
        } catch (Exception ex) {
            mongo.close();
            LogUtil.log(ex.toString());
        }
        assertEquals(size, test.getSize());
    }

}