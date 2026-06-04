package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

public class App {
    /*
    1. Creat dataSource
    2. Open con
    3. PrepStat.
    4. Query
    5. ResultSet
    6. close res.

     */
    public static void main(String[] args) {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername("root");
        dataSource.setPassword("");
    }
}
