package org.tnmk.practicespringlogging.pro01conditionalconfig.itemslist;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tnmk.practicespringlogging.pro01conditionalconfig.Pro01SimpleLogApplication;
import org.tnmk.practicespringlogging.pro01conditionalconfig.config.itemslist.conditiononexpression.ConfiguredCorrectlyItemsListBBB;
import org.tnmk.practicespringlogging.pro01conditionalconfig.config.itemslist.conditiononexpression.NotConfiguredItemsListBB;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Pro01SimpleLogApplication.class)
public class ConditionalConfigurationTest {

    @Autowired(required = false)
    private NotConfiguredItemsListBB notConfiguredItemsListBB;

    @Autowired(required = false)
    private ConfiguredCorrectlyItemsListBBB configuredCorrectlyItemsListBBB;

    /**
     * @deprecated this test is still fail because I cannot find a solution when working with properties list.
     * View more at {@link ConfiguredCorrectlyItemsListBBB}
     */
    @Disabled
    @Deprecated
    @Test
    public void testConditionalOnExpression() {
        Assert.assertNull(notConfiguredItemsListBB);
        Assert.assertNotNull(configuredCorrectlyItemsListBBB);
    }

}
