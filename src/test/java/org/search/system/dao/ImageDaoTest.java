package org.search.system.dao;

import junit.framework.TestCase;
import org.search.system.interfaces.Page;
import org.search.system.models.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniil on 15.04.2017.
 */
public class ImageDaoTest extends TestCase {

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

    public void testInsertImage() throws Exception {
        ImageDao imageDao = new ImageDao();
        ArrayList<String> test = new ArrayList<>();
        test.add("test");
        test.add("tests");
        test.add("testing");
        Image excepted=new Image("test","test",test,"test",Integer.toString("test".hashCode()));
        imageDao.insertImage(excepted);
        Image result =imageDao.getImages("data").get(0);
        assertEquals(excepted.getDescription(), result.getDescription());
        assertEquals(excepted.getLink(), result.getLink());
        assertEquals(excepted.getTags(), result.getTags());
        assertEquals(excepted.getImageHash(), result.getImageHash());
        assertEquals(excepted.getTitle(), result.getTitle());
    }

    public void testGetImages() throws Exception {
        ImageDao imageDao = new ImageDao();
        ArrayList<String> test = new ArrayList<>();
        test.add("test");
        test.add("tests");
        test.add("testing");
        Image excepted=new Image("test","test",test,"test",Integer.toString("test".hashCode()));
        Image result =imageDao.getImages("data").get(0);
        assertEquals(excepted.getDescription(), result.getDescription());
        assertEquals(excepted.getLink(), result.getLink());
        assertEquals(excepted.getTags(), result.getTags());
        assertEquals(excepted.getImageHash(), result.getImageHash());
        assertEquals(excepted.getTitle(), result.getTitle());
    }

    public void testFindSame() throws Exception {
        ArrayList<String> test = new ArrayList<>();
        test.add("test");
        test.add("tests");
        test.add("testing");
        Image image=new Image("test","test",test,"test",Integer.toString("test".hashCode()));
        Image image1=new Image("test2","test",test,"test",Integer.toString("test".hashCode()));
        ImageDao imageDao = new ImageDao();
        imageDao.insertImage(image);
        imageDao.insertImage(image1);
        List<Image> excepted=new ArrayList<>();
        excepted.add(image);
        excepted.add(image1);
    }

}