package com.company;

import org.testcontainers.containers.Db2Container;

public class Main {

    public static void main(String[] args) {
        Db2Container db2Container = new Db2Container("ibmcom/db2")
                .acceptLicense()
                .withDatabaseName("mydb")
                .withUsername("")
                .withPassword("");
        db2Container.start();
    }
}
