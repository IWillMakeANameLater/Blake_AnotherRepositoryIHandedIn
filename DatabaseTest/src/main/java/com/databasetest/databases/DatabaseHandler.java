package com.databasetest.databases;

import java.sql.*;

public class DatabaseHandler {
    private static final String DB_url = "jdbc:derby:database/forum;create=true";

    private static Connection conn = null;
    private static Statement stmt = null;

    public DatabaseHandler(){
        createConnection();
        createTable();
    }

    private void createConnection(){
        try {
            conn = DriverManager.getConnection(DB_url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable(){
        String TABLE_NAME = "SA";
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dmd = conn.getMetaData();
            ResultSet tables = dmd.getTables(null, null, TABLE_NAME, null);
            if(tables.next()){
                System.err.println("Table " + TABLE_NAME + " already exists");
            } else {
                String statement = "CREATE TABLE " + TABLE_NAME
                        + "(fileName varchar(200) primary key, \n"
                        + "absoluteFilePath varchar(2000), \n"
                        + "fileExtension varchar(20), \n"
                        + "fileByteSize int)";
                stmt.execute(statement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * handles requests to execute stuff on the database
     * @return if it was successful or not
     */
    public boolean runCommand(String command){
        try{
            stmt = conn.createStatement();
            stmt.execute(command);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
