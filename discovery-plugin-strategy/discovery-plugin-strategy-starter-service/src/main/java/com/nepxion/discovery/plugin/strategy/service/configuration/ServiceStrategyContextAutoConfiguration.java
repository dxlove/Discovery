package com.nepxion.discovery.plugin.strategy.service.configuration;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nepxion.discovery.plugin.strategy.service.context.ServiceStrategyContextHolder;

@Configuration
public class ServiceStrategyContextAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public ServiceStrategyContextHolder serviceStrategyContextHolder() {
        return new ServiceStrategyContextHolder();
    }
}