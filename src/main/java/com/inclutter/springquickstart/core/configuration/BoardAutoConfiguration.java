package com.inclutter.springquickstart.core.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement
public class BoardAutoConfiguration {
    @Value("${spring.datasource.driver-class-name}")
    String driverClassName;

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Bean
    public JDBCConnectionManager getJDBCConnectionManager() {
        JDBCConnectionManager manager = new JDBCConnectionManager();
        manager.setDriverClass(driverClassName);
        manager.setUrl(url);
        manager.setUsername(username);
        manager.setPassword(password);
        return manager;
    }
}
