package org.tnmk.practicespringlogging.pro01conditionalconfig.itemslist;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tnmk.practicespringlogging.pro01conditionalconfig.Pro01SimpleLogApplication;
import org.tnmk.practicespringlogging.pro01conditionalconfig.config.itemslist.ItemsListProperties;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Pro01SimpleLogApplication.class)
public class ManyPropertiesBeansWithSameModelConfigTest {

    @Autowired
    @Qualifier("itemsListPropertiesA")
    private ItemsListProperties itemsListPropertiesA;

    @Autowired
    @Qualifier("itemsListPropertiesB")
    private ItemsListProperties itemsListPropertiesB;

    @Test
    public void testCanLoadDifferentPropertiesBeansWithTheSameDataStructure() {
        Assert.assertNotNull(itemsListPropertiesB.getServices().contains("b"));
        Assert.assertNotNull(itemsListPropertiesA.getServices().contains("a"));
    }

}
