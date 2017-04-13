package org.search.system.managers;

import org.search.system.models.MongoInstance;
import org.search.system.utils.LogUtil;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Object holds all MongoDb instances, provides best one
 */
public class DatabaseManager {

    private static final int DEFAULT_PORT = 27017;

    private static final String DEFAULT_HOST_NAME = "localhost";

    private static final String DEFAULT_FOLDER = "localhost";

    private static final int MAX_DATABASE_SIZE = 65536;


    private int nextPort = DEFAULT_PORT;

    private ArrayList<MongoInstance> instances = new ArrayList<>();

    private void createNewInstance() {
        String command = " mongod --dbpath " + DEFAULT_FOLDER + "--port " + Integer.toString(nextPort);
        try {
            Process process = Runtime.getRuntime().exec(command);
            instances.add(new MongoInstance(DEFAULT_HOST_NAME, nextPort + 1));
            nextPort++;
        } catch (IOException ex) {
            LogUtil.log(ex.toString());
        }
    }

    private MongoInstance findBestInstance() {
        MongoInstance best = null;
        int bestSize = Integer.MAX_VALUE;
        int size;
        for (MongoInstance instance : instances) {
            size = instance.getSize();
            if (size < bestSize) {
                bestSize = size;
                best = instance;
            }
        }
        return best;
    }

    public MongoInstance getInstance() {
        if (instances.isEmpty()) {
            instances.add(new MongoInstance(DEFAULT_HOST_NAME, DEFAULT_PORT));
        }
        MongoInstance best = findBestInstance();
        if (best == null) {
            createNewInstance();
            best = findBestInstance();
        }
        if (best.getSize() > MAX_DATABASE_SIZE) {
            createNewInstance();
            best = findBestInstance();
        }
        return best;
    }
}
