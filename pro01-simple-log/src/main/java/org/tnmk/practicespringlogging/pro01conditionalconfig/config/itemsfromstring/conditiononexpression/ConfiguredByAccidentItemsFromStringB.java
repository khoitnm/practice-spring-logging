package org.tnmk.practicespringlogging.pro01conditionalconfig.config.itemsfromstring.conditiononexpression;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnExpression("'${items-from-string.services-list}'.contains('b')")
public class ConfiguredByAccidentItemsFromStringB {
}
