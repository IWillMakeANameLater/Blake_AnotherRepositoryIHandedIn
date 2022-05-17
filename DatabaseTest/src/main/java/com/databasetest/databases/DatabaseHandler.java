package com.databasetest.databases;

import java.sql.*;
import java.util.ArrayList;
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
        tableName = "\"" + tableName + "\"";
        try {
            ResultSet tables = tableSearch(tableName);
            if(!doesTableExist(tableName)){
                String statement = "CREATE TABLE " + tableName
                        + "(fileName varchar(200) primary key, \n"
                        + "absoluteFilePath varchar(2000), \n"
                        + "fileExtension varchar(20), \n"
                        + "fileByteSize int)";
                runCommand(statement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return tableName;
    }

    public void insertFile(DatabaseFileEntry fileToInsert, String tableName){
        String statement = "INSERT INTO " + tableName + "(fileName,absoluteFilePath,fileExtension,fileByteSize) \n"
                + "VALUES (" + fileToInsert.getFileName() + "," + fileToInsert.getAbsoluteFilePath() + "," + fileToInsert.getFileExtension() + "," + fileToInsert.getFileByteSize() + ")";
        try{
            runCommand(statement);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<DatabaseFileEntry> getFileEntries (String tableName, String propertyIndentifier, String propertyValue){
        return getEntriesFromSearch("SELECT * FROM " + tableName + "\n WHERE " + propertyIndentifier + "=" + propertyValue);
    }

    public ArrayList<DatabaseFileEntry> getFileEntries (String tableName){
        return getEntriesFromSearch("SELECT * FROM " + tableName);
    }

    private ArrayList<DatabaseFileEntry> getEntriesFromSearch(String searchStatement){
        ArrayList<DatabaseFileEntry> foundEntries = new ArrayList<>();
        try{
            ResultSet result = runCommand(searchStatement);
            if(result != null){
                while(result.next()){
                    String fileName = result.getString("fileName");
                    String absoluteFilePath = result.getString("absoluteFilePath");
                    String fileExtension = result.getString("fileExtension");
                    String fileByteSize = result.getString("fileByteSize");
                    foundEntries.add(new DatabaseFileEntry(fileName, absoluteFilePath, fileExtension, Integer.parseInt(fileByteSize)));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return foundEntries;
    }

    public ArrayList<String> getTables(){
        ArrayList<String> foundTables = new ArrayList<>();
        try{
            ResultSet tablesInDatabase = tableSearch("%");
            if(tablesInDatabase != null){
                while(tablesInDatabase.next()){
                    ResultSetMetaData tablesMetaData = tablesInDatabase.getMetaData();
                    foundTables.add(tablesMetaData.getTableName(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundTables;
    }

    private ResultSet runCommand(String command) throws SQLException{ //For internal use only\
        stmt = conn.createStatement();
        if(stmt.execute(command)){
            return stmt.getResultSet();
        }
        return null;
    }

    private ResultSet tableSearch(String tableSearchFor) throws SQLException{
        stmt = conn.createStatement();
        DatabaseMetaData dmd = conn.getMetaData();
        return dmd.getTables(null, null, tableSearchFor, null);
    }

    public boolean doesTableExist(String requestName){
        try{
            ResultSet result = tableSearch(requestName);
            if(result.next()){
                return true;
            }
        }catch(SQLException e){
            System.out.println("Something went wrong with the request.");
        }
        return false;
    }
}
