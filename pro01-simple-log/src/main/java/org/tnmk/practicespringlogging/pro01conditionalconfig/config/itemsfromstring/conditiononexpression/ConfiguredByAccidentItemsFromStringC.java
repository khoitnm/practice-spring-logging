package org.tnmk.practicespringlogging.pro01conditionalconfig.config.itemsfromstring.conditiononexpression;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

/**
 * With this configuration:<br/>
 * <pre>
 * items-from-string.services-list: b, bb, bc
 * </pre>
 * This bean is populated because the character 'c' exist inside the string 'b, bb, bc'.<br/>
 * However, this is not what we want. We want that this bean should be only populated only if the configuration has any element with exactly character 'c', the element 'bc' is not acceptable.<br/>
 * <p/>
 * Please view {@link NotConfiguredItemsFromStringC} and {@link ConfiguredCorrectlyItemsFromStringBC} for the correct configuration.
 */
@Service
@ConditionalOnExpression("'${items-from-string.services-list}'.contains('c')")
public class ConfiguredByAccidentItemsFromStringC {
}
