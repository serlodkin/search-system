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
    public void testGetHost() throws Exception {
        MongoInstance test = new MongoInstance("localhost", 27010);
        assertEquals("localhost", test.getHost());
    }

    public void testGetPort() throws Exception {
        MongoInstance test = new MongoInstance("localhost", 27010);
        assertEquals(27010, test.getPort());

    }

    public void testGetSize() throws Exception {
        MongoInstance test = new MongoInstance("localhost", 27017);
        assertEquals("localhost", test.getHost());
        int size = 10000;
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