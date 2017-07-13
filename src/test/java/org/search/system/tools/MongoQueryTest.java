package org.search.system.tools;

import junit.framework.TestCase;
import org.bson.Document;
import org.search.system.dao.ImageDao;
import org.search.system.models.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by exam on 29.04.2017.
 */
public class MongoQueryTest extends TestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        ArrayList<String> test = new ArrayList<>();
        test.add("test");
        test.add("tests");
        test.add("testing");
        Image image=new Image("test","test",test,"test",Integer.toString("test".hashCode()));
        Image image1=new Image("test2","test",test,"test",Integer.toString("test".hashCode()));
        ImageDao imageDao = new ImageDao();
        imageDao.insertImage(image);
        imageDao.insertImage(image1);

    }

    public void testGetDataByTag() throws Exception {
        ArrayList<String> test = new ArrayList<>();
        test.add("test");
        test.add("tests");
        test.add("testing");
        Image image=new Image("test","test",test,"test",Integer.toString("test".hashCode()));
        Image image1=new Image("test2","test",test,"test",Integer.toString("test".hashCode()));
        List<Image> excepted=new ArrayList<>();
        excepted.add(image);
        excepted.add(image1);
        Document query=new Document();
        MongoQuery<Image> mongoQuery=new MongoQuery<>(Image.class);
        query.put("imageHash", image.getImageHash());
        ArrayList<Image> result=mongoQuery.getDataByCollection("images","imagesHash", query);
        assertEquals(excepted.get(0).getImageHash(),result.get(0).getImageHash());
    }

}