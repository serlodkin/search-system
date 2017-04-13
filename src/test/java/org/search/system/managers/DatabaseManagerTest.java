package org.search.system.managers;

import junit.framework.TestCase;
import org.search.system.models.MongoInstance;

/**
 * Created by Daniil on 13.04.2017.
 */
public class DatabaseManagerTest extends TestCase {
    public void testGetInstance() throws Exception {
        DatabaseManager databaseManager = new DatabaseManager();
        MongoInstance exceptedInstance = new MongoInstance("localhost", 27017);
        MongoInstance instance = databaseManager.getInstance();
        assertEquals(exceptedInstance.getHost(), instance.getHost());
        assertEquals(exceptedInstance.getPort(), instance.getPort());
        assertEquals(exceptedInstance.getSize(), instance.getSize());
    }


}