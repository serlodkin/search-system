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

package org.search.system.dao;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.search.system.interfaces.Page;
import org.search.system.managers.DatabaseManager;
import org.search.system.models.MongoInstance;
import org.search.system.models.NullablePage;
import org.search.system.tools.MongoNullQuery;
import org.search.system.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/*
 * Data access object for page collection using MongoDb
 *
 * @author Daniil Matkov
 */
public class PageDao {

    private static final DatabaseManager databaseManager = new DatabaseManager();

    private static final String DATABASE_NAME = "pages";


    public void insertPage(Page page) {
        MongoInstance mongoInstance = databaseManager.getInstance();
        MongoClient mongo = new MongoClient(mongoInstance.getHost(), mongoInstance.getPort());
        try {
            MongoDatabase pages = mongo.getDatabase(DATABASE_NAME);
            Document document = new Document();
            document.put("title", page.getTitle());
            document.put("description", page.getDescription());
            document.put("rang", 0);
            document.put("link", page.getLink());
            document.put("tags", page.getTags());
            for (String tag : page.getTags()) {
                MongoCollection<Document> collection = pages.getCollection(tag.toLowerCase());
                collection.insertOne(document);
            }
            for (String tag : page.getTitle().split(" ")) {
                MongoCollection<Document> collection = pages.getCollection(tag.toLowerCase());
                collection.insertOne(document);
            }
            mongo.close();
        } catch (Exception ex) {
            mongo.close();
            LogUtil.log(ex.toString());
        }
    }

    public List<Page> getPages(String tag) {
        MongoNullQuery<Page> mongoNullQuery = new MongoNullQuery<>(Page.class);
        return mongoNullQuery.getDataByTag(DATABASE_NAME, tag);
    }
}
