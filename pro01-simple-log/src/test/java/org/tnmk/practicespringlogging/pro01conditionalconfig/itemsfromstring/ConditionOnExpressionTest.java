package org.tnmk.practicespringlogging.pro01conditionalconfig.itemsfromstring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tnmk.practicespringlogging.pro01conditionalconfig.Pro01SimpleLogApplication;
import org.tnmk.practicespringlogging.pro01conditionalconfig.config.itemsfromstring.conditiononexpression.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Pro01SimpleLogApplication.class)
public class ConditionOnExpressionTest {

    @Autowired(required = false)
    private ConfiguredByAccidentItemsFromStringA configuredByAccidentItemsFromStringA;

    @Autowired(required = false)
    private ConfiguredByAccidentItemsFromStringB configuredByAccidentItemsFromStringB;

    @Autowired(required = false)
    private NotConfiguredItemsFromStringC notConfiguredItemsFromStringC;

    @Autowired(required = false)
    private ConfiguredByAccidentItemsFromStringC configuredByAccidentItemsFromStringC;

    @Autowired(required = false)
    private ConfiguredCorrectlyItemsFromStringBC configuredCorrectlyItemsFromStringBC;

    @Test
    public void testConditionalOnExpression() {
        Assert.assertNotNull(configuredByAccidentItemsFromStringA);

        Assert.assertNotNull(configuredByAccidentItemsFromStringB);

        Assert.assertNull(notConfiguredItemsFromStringC);

        Assert.assertNotNull(configuredByAccidentItemsFromStringC);

        Assert.assertNotNull(configuredCorrectlyItemsFromStringBC);
    }

}
