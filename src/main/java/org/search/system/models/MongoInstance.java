package org.search.system.models;

import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.search.system.utils.LogUtil;

/*
 * Class holding information about MongoDb instance
 * @author Daniil Matkov
 */
public class MongoInstance {

    private static final int DEFAULT_SIZE = 100000;


    private String host;

    private int port;

    public MongoInstance(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }


    public int getSize() {
        int size = DEFAULT_SIZE;
        MongoClient mongo = new MongoClient(host, port);
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
        return size;
    }
}
