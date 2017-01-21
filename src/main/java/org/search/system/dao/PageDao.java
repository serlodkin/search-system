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
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.search.system.models.Page;
import org.search.system.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/*
 * Data access object for page collection using MongoDb
 *
 * @author Daniil Matkov
 */
public class PageDao {

    private static final int PORT = 27017;

    public void insert(Page page) {
        MongoClient mongo = new MongoClient("localhost", PORT);
        try {
            MongoDatabase pages=mongo.getDatabase("pages");
            Document document = new Document();
            document.put("title",page.getTitle());
            document.put("description",page.getDescription());
            document.put("rang",0);
            document.put("link",page.getLink());
            document.put("tags",page.getTags());
            for(String tag:page.getTags()){
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

    public List<Page> getPages(String tag){
        MongoClient mongo = new MongoClient("localhost", PORT);
        ArrayList<Page> result = new ArrayList<>();
        try {
            MongoDatabase pages=mongo.getDatabase("pages");
            MongoCollection<Document> data=pages.getCollection(tag);
            FindIterable<Document> cursor = data.find();
            Gson gson = new Gson();
            for (Document doc:cursor){
                result.add(gson.fromJson(doc.toJson(),Page.class));
            }
            mongo.close();
        } catch (Exception ex) {
            mongo.close();
            LogUtil.log(ex.toString());
        }
        return result;
    }

}
