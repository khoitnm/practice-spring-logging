package org.tnmk.practicespringlogging.pro01conditionalconfig.config.itemslist;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManyPropertiesBeansWithSameModelConfig {

    @Bean
    @ConfigurationProperties("items-list-a")
    public ItemsListProperties itemsListPropertiesA() {
        return new ItemsListProperties();
    }

    @Bean
    @ConfigurationProperties("items-list-b")
    public ItemsListProperties itemsListPropertiesB() {
        return new ItemsListProperties();
    }
}
