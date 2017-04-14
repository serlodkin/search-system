/*
MIT License

Copyright (c) 2016-2017 Daniil Matkov

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package org.search.system.managers;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.search.system.models.MongoInstance;
import org.search.system.utils.LogUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;

/**
 * Holds all operations on MongoDb instances, provides best one for insert.
 * allow to make find requests on all instances
 * @author Daniil Matkov
 */
public class DatabaseManager {

    private static final int DEFAULT_PORT = 27017;

    private static final String DEFAULT_HOST_NAME = "localhost";

    private static final String DEFAULT_FOLDER = "localhost";

    private static final int MAX_DATABASE_SIZE = 65536;

    private static final int MAX_THREADS = 10;

    private static final int MAX_WAIT_TIME = 5;

    private static final TimeUnit MAX_TIME_UNIT = TimeUnit.SECONDS;

    private int nextPort = DEFAULT_PORT;

    private ArrayList<MongoInstance> instances = new ArrayList<>();

    public DatabaseManager() {
        if (instances.isEmpty()) {
            instances.add(new MongoInstance(DEFAULT_HOST_NAME, DEFAULT_PORT));
        }
    }

    private void createNewInstance() {
        String command = " mongod --dbpath " + DEFAULT_FOLDER + "--port " + Integer.toString(nextPort);
        try {
            Process process = Runtime.getRuntime().exec(command);
            instances.add(new MongoInstance(DEFAULT_HOST_NAME, nextPort + 1));
            LogUtil.log("Trying to run MongoDb on port: " + Integer.toString(nextPort) + " with exitcode: " + Integer.toString(process.exitValue()));
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

    private List<Document> fetchFromInstance(String databaseName, String collectionName, Document query, MongoInstance instance) {
        ArrayList<Document> result = new ArrayList<>();
        MongoClient mongo = new MongoClient(instance.getHost(), instance.getPort());
        try {
            MongoDatabase database = mongo.getDatabase(databaseName);
            MongoCollection<Document> data = database.getCollection(collectionName);
            FindIterable<Document> cursor = null;
            if (query == null) {
                cursor = data.find();
            } else {
                cursor = data.find(query);
            }
            if (cursor == null) {
                return result;
            }
            for (Document doc : cursor) {
                result.add(doc);
            }
            mongo.close();
        } catch (Exception ex) {
            mongo.close();
            LogUtil.log(ex.toString());
        }
        return result;
    }

    public List<Document> find(String databaseName, String collectionName, Document query) {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);
        ArrayList<Document> result = new ArrayList<>();
        ArrayList<Future<List<Document>>> instanceFuture = new ArrayList<>();
        for (MongoInstance instance : instances) {
            instanceFuture.add(executor.submit(() -> fetchFromInstance(databaseName, collectionName, query, instance)));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(MAX_WAIT_TIME, MAX_TIME_UNIT);
        } catch (InterruptedException e) {
            LogUtil.log(e.getMessage());
        }
        for (Future<List<Document>> future : instanceFuture) {
            try {
                result.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                LogUtil.log(e.getMessage());
            }
        }
        return result;
    }

    public Document findOne(String databaseName, String collectionName, Document query) {
        Document result = null;
        for (MongoInstance instance : instances) {
            MongoClient mongo = new MongoClient(instance.getHost(), instance.getPort());
            try {
                MongoDatabase database = mongo.getDatabase(databaseName);
                MongoCollection<Document> collection = database.getCollection(collectionName);
                result = collection.find(query).first();
                mongo.close();
            } catch (Exception ex) {
                LogUtil.log(ex.toString());
                mongo.close();
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }
}
