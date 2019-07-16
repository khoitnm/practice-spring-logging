package org.tnmk.practicespringlogging.pro01conditionalconfig.config.itemslist.conditiononexpression;

import org.springframework.stereotype.Service;

@Service
//I assume that this expression should work. But somehow it shows error cannot find the bean 'itemsListPropertiesB'.
//It's weird because that bean is created inside PropertiesConfig.
//@ConditionalOnExpression("#{@itemsListPropertiesB.services.contains('bbb')}") //Doesn't work: cannot find the bean 'itemsListPropertiesB'
//@ConditionalOnProperty(name = "items-list-b.services", havingValue = "bbb") //Doesn't work
//@ConditionalOnExpression("#{T(java.util.Arrays).asList('${items-list-b.services-list}').contains('bbb')}") //Doesn't work
/**
 * @deprecated Have not figured out how to configured with CondictionalOnXxx yet.
 */
@Deprecated
public class ConfiguredCorrectlyItemsListBBB {
}
