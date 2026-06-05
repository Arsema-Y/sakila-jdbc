package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.time.Instant;

public class App {
    /*
    1. Creat dataSource
    2. Open con
    3. PrepStat.
    4. Query
    5. ResultSet : the display/result from query
    6. close res.

    API : web skeletal, no styling
     */
    public static void main(String[] args) {
      // setup dataSource
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://LocalHost:3306/sakila");
        dataSource.setUsername("root");
        dataSource.setPassword("root@88");

        //Query the database

        String sql = """
                SELECT actor_id,
                first_name,
                last_name,
                last_update
                FROM actor""";

        //Creat connection
          //try
          //prepare
          //resultSet
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            //next method: iterator (while loop)
            while (resultSet.next()) { //resultSet = row of data

                int actorID = resultSet.getInt("actor_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Instant lastUpdate = resultSet.getTimestamp("last_update").toInstant();

                System.out.printf("%d %s %s -- %s \n", actorID,  firstName, lastName, lastUpdate.toString() );
            }


            /* AUTOCLOSE (behind the scenes)
            resultSet.close();
            statement.close();
            connection.close();
          */
        } catch (SQLException e) {
            System.out.println("Failed to retrieve actors, Please try again");
            e.printStackTrace();
        }
    }
}
