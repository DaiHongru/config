package com.freework.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<BusRefreshFilter> filterRegistration() {
        FilterRegistrationBean<BusRefreshFilter> registration = new FilterRegistrationBean<BusRefreshFilter>();
        registration.setFilter(new BusRefreshFilter());
        List<String> urlList = new ArrayList<String>();
        urlList.add("/*");
        registration.setUrlPatterns(urlList);
        registration.setName("BusRefreshFilter");
        registration.setOrder(1);
        return registration;
    }
}
