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

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.search.system.managers.DatabaseManager;
import org.search.system.models.Image;
import org.search.system.models.MongoInstance;
import org.search.system.tools.MongoNullQuery;
import org.search.system.tools.MongoQuery;
import org.search.system.utils.LogUtil;
import java.util.List;

/*
 * Data access object for images using MongoDb
 *
 * @author Daniil Matkov
 */
public class ImageDao {

    private static final DatabaseManager databaseManager = new DatabaseManager();

    private static final String DATABASE_NAME = "images";


    public void insertImage(Image image) {
        MongoInstance mongoInstance = databaseManager.getInstance();
        MongoClient mongo = new MongoClient(mongoInstance.getHost(), mongoInstance.getPort());
        try {
            MongoDatabase pages=mongo.getDatabase(DATABASE_NAME);
            Document document = new Document();
            document.put("title",image.getTitle());
            document.put("description",image.getDescription());
            document.put("link",image.getLink());
            document.put("tags",image.getTags());
            document.put("imageHash", image.getImageHash());
            for(String tag:image.getTags()){
                MongoCollection<Document> collection = pages.getCollection(tag.toLowerCase());
                collection.insertOne(document);
            }
            for (String tag : image.getTitle().split(" ")) {
                MongoCollection<Document> collection = pages.getCollection(tag.toLowerCase());
                collection.insertOne(document);
            }
            MongoCollection<Document> collection = pages.getCollection("imagesHash");
            collection.insertOne(document);
            mongo.close();
        } catch (Exception ex) {
            mongo.close();
            LogUtil.log(ex.toString());
        }
    }

    public List<Image> getImages(String tag){
        MongoNullQuery<Image> mongoNullQuery=new MongoNullQuery<>(Image.class);
        return mongoNullQuery.getDataByTag(DATABASE_NAME,tag);
    }

    public List<Image> findSame(Image image){
        MongoQuery<Image> mongoQuery=new MongoQuery<>(Image.class);
        Document query = new Document();
        query.put("imageHash", image.getImageHash());
        return mongoQuery.getDataByCollection(DATABASE_NAME,"imagesHash", query);

    }

}
