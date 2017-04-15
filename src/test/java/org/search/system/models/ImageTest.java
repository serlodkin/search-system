package org.search.system.models;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Daniil on 15.04.2017.
 */
public class ImageTest extends TestCase {

    public void testGetImageHash() throws Exception {
        Image image=new Image("test","test",new ArrayList<>(),"test",Integer.toString("test".hashCode()));
        assertEquals(image.getImageHash(),Integer.toString("test".hashCode()));
    }

    public void testGetLink() throws Exception {
        Image image=new Image("test","test",new ArrayList<>(),"test",Integer.toString("test".hashCode()));
        assertEquals(image.getLink(),"test");
    }

    public void testGetTags() throws Exception {
        Image image=new Image("test","test",new ArrayList<>(),"test",Integer.toString("test".hashCode()));
        assertEquals(image.getTags(),new ArrayList<>());
    }

    public void testGetDescription() throws Exception {
        Image image=new Image("test","test",new ArrayList<>(),"test",Integer.toString("test".hashCode()));
        assertEquals(image.getDescription(),"test");
    }

    public void testGetTitle() throws Exception {
        Image image=new Image("test","test",new ArrayList<>(),"test",Integer.toString("test".hashCode()));
        assertEquals(image.getTitle(),"test");
    }

}