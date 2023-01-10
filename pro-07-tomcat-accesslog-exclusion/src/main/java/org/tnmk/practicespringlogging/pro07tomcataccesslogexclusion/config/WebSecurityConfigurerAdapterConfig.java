package org.tnmk.practicespringlogging.pro07tomcataccesslogexclusion.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.ConcurrentSessionFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurerAdapterConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        String urlPattern = "/**";
        http
            .requestMatchers()
            .antMatchers(urlPattern)
            .and()
            // The PccTracingFilter must run before PccAuthenticationFilter
            // because we want to trace requests
            // regardless of whether they are authenticated successfully or not.
            .addFilterBefore(new TracingFilter(), ConcurrentSessionFilter.class);

        http.csrf().disable();

        http
            .authorizeRequests()
            .antMatchers(urlPattern)
            .authenticated()
        ;
    }
}
