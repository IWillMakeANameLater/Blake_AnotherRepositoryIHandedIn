package com.databasetest.databases;

import java.sql.*;
import java.util.Locale;

public class DatabaseHandler {
    private static final String DB_url = "jdbc:derby:database/forum;create=true";

    private static Connection conn = null;
    private static Statement stmt = null;

    public DatabaseHandler(){
        createConnection();
    }

    private void createConnection(){
        try {
            conn = DriverManager.getConnection(DB_url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String createTable(String tableName){
        String TABLE_NAME = tableName.toUpperCase(Locale.ROOT);
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
                runCommand(statement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return TABLE_NAME;
    }

    public void insertFile(String fileName, String fileAbsolutePath, String fileExtension, Integer fileSize, String tableName){
        String statement = "INSERT INTO " + tableName + "(fileName,absoluteFilePath,fileExtension,fileByteSize) \n"
                + "VALUES (" + fileName + "," + fileAbsolutePath + "," + fileExtension + "," + fileSize + ")";
        try{
            runCommand(statement);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    

    private void runCommand(String command) throws SQLException{ //For internal use only
        stmt = conn.createStatement();
        stmt.execute(command);
    }
}
