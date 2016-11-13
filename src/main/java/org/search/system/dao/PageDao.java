package org.search.system.dao;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.search.system.models.Page;

import java.util.ArrayList;
import java.util.List;

public class PageDao {

    public void insert(Page page) {
        MongoClient mongo = new MongoClient("localhost", 27017);
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
            ex.printStackTrace();
        }
    }

    public List<Page> getPages(String tag){
        MongoClient mongo = new MongoClient("localhost", 27017);
        ArrayList<Page> result = new ArrayList<>();
        try {
            MongoDatabase pages=mongo.getDatabase("pages");
            MongoCollection<Document> data=pages.getCollection(tag);
            FindIterable<Document> cursor = data.find();
            Gson gson = new Gson();
            for (Document doc:cursor){
                //fix this
                result.add(gson.fromJson(doc.toJson(),Page.class));
            }
            mongo.close();
        } catch (Exception ex) {
            mongo.close();
            ex.printStackTrace();
        }
        return result;
    }

}
