package org.tnmk.practicespringlogging.pro01conditionalconfig.itemsfromstring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tnmk.practicespringlogging.pro01conditionalconfig.Pro01SimpleLogApplication;
import org.tnmk.practicespringlogging.pro01conditionalconfig.config.itemsfromstring.ItemsFromStringProperties;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Pro01SimpleLogApplication.class)
public class ItemsFromStringPropertiesTest {

    @Autowired
    private ItemsFromStringProperties itemsFromStringProperties;


    @Test
    public void testCanLoadListWithOneItem() {
        Assert.assertEquals("x", itemsFromStringProperties.getListWithOneItem().get(0));
    }

    @Test
    public void testCanLoadArrayAndListFromConfiguration() {
        Assert.assertArrayEquals(new String[]{"a", "aa"}, itemsFromStringProperties.getServicesArray());
        Assert.assertEquals(3, itemsFromStringProperties.getServicesList().size());
        Assert.assertEquals("b, bb, bc", itemsFromStringProperties.getServicesListString());
        Assert.assertEquals(3, itemsFromStringProperties.getServicesListParseByValueAnnotation().size());
    }

}
