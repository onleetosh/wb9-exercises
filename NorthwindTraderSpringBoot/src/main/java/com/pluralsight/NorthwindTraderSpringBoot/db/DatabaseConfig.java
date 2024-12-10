package com.pluralsight.NorthwindTraderSpringBoot.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;

public class DatabaseConfig {

    private BasicDataSource basicDataSource;


    /**
     * Contructor
     * @param url
     * @param username
     * @param password
     */
    public DatabaseConfig(@Value("${datasource.url}") String url,
                          @Value("${datasource.username}") String username,
                          @Value("${datasource.password}") String password){

        this.basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);


    }

}
