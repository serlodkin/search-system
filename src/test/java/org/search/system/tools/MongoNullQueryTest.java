package org.search.system.tools;

import junit.framework.TestCase;
import org.search.system.dao.ImageDao;
import org.search.system.models.Image;

import java.util.ArrayList;

/**
 * Created by exam on 29.04.2017.
 */
public class MongoNullQueryTest extends TestCase {
    @Override
    public void setUp() throws Exception {
        super.setUp();
        ImageDao imageDao = new ImageDao();
        ArrayList<String> test = new ArrayList<>();
        test.add("test");
        test.add("tests");
        test.add("testing");
        imageDao.insertImage(new Image("test","test",test,"test",Integer.toString("test".hashCode())));
    }

    public void testGetDataByTag() throws Exception {
        MongoNullQuery<Image> mongoNullQuery=new MongoNullQuery<>(Image.class);
        ArrayList<Image> res=mongoNullQuery.getDataByTag("images","test");
        ArrayList<String> test = new ArrayList<>();
        test.add("test");
        test.add("tests");
        test.add("testing");
        Image excepted=new Image("test","test",test,"test",Integer.toString("test".hashCode()));
        assertEquals(excepted.getTitle(),res.get(0).getTitle());
        assertEquals(excepted.getDescription(),res.get(0).getDescription());
        assertEquals(excepted.getLink(),res.get(0).getLink());

    }

}