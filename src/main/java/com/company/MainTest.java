package com.company;

import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.Db2Container;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainTest {

    @ClassRule
    public static Db2Container db2Container = new Db2Container("ibmcom/db2")
            .acceptLicense()
            .withDatabaseName("testdb")
            .withUsername("username")
            .withPassword("password")
            .withInitScript("/home/dmitars/IdeaProjects/db2-test/script.sql");

    @Test
    public void whenSelectQueryExecuted_thenResulstsReturned() throws SQLException {
        String jdbcUrl = db2Container.getJdbcUrl();
        String username = db2Container.getUsername();
        String password = db2Container.getPassword();
        Connection conn = DriverManager
                .getConnection(jdbcUrl, username, password);
        ResultSet resultSet =
                conn.createStatement().executeQuery("SELECT 1");
        resultSet.next();
        int result = resultSet.getInt(1);
        System.out.println(result);
    }
}
