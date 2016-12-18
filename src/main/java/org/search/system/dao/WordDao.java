package org.search.system.dao;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.search.system.models.Word;

import java.util.ArrayList;

/**
 * Created by Daniil Matkov on 03.11.16.
 */
public class WordDao {
    public Word getWord(String word) {
        MongoClient mongo = new MongoClient("localhost", 27017);
        Word res = new Word(word, new ArrayList<>());
        try {
            MongoDatabase synonyms = mongo.getDatabase("synonyms");
            MongoCollection<Document> collection = synonyms.getCollection("synonyms");
            Document query = new Document();
            query.put("word", word);
            Document result = collection.find(query).first();
            Gson gson = new Gson();
            res = gson.fromJson(result.toJson(), Word.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        mongo.close();
        return res;
    }

    public void insert(Word word) {
        MongoClient mongo = new MongoClient("localhost", 27017);
        try {
            MongoDatabase synonyms = mongo.getDatabase("synonyms");
            MongoCollection<Document> collection = synonyms.getCollection("synonyms");
            Document document = new Document();
            document.put("word", word.getWord());
            document.put("synonyms", word.getSynonyms());
            collection.insertOne(document);
            mongo.close();
        } catch (Exception ex) {
            mongo.close();
            ex.printStackTrace();
        }
    }
}
