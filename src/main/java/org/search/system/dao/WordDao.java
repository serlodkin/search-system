/*
MIT License

Copyright (c) 2016 Daniil Matkov

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
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.search.system.models.Word;

import java.util.ArrayList;

/*
 * Data access object for word collection using MongoDb/
 * @author Daniil Matkov
 */
public class WordDao {

    private static final int PORT = 27017;

    public Word getWord(String word) {
        MongoClient mongo = new MongoClient("localhost", PORT);
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
        MongoClient mongo = new MongoClient("localhost", PORT);
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
