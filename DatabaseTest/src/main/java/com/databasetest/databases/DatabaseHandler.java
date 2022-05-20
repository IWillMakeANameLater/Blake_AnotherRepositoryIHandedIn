package com.databasetest.databases;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

public class DatabaseHandler {
    private static final String DB_url = "jdbc:derby:database/forum;create=true";

    private static Connection conn = null;
    private static Statement stmt = null;
    private static final String allDirectoriesTable = "\"<Directories in Database>\"";

    public DatabaseHandler(){
        createConnection();
        setupTableOfDirectories();
    }

    private void createConnection(){
        try {
            conn = DriverManager.getConnection(DB_url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setupTableOfDirectories(){
        try {
            boolean tableExists = false;
            stmt = conn.createStatement();
            DatabaseMetaData dmd = conn.getMetaData();
            ResultSet result = dmd.getTables(null, null, null, new String[] {"TABLE"});
            while(result.next()){
                String name = result.getString("TABLE_NAME");
                if(("\"" + name + "\"").equals(allDirectoriesTable)){
                    tableExists = true;
                    break;
                }
            }
            if(!tableExists){
                runCommand("CREATE TABLE " + allDirectoriesTable + "(directoryName varchar(200) primary key)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String createTable(String tableName){
        try {
            if(tableSearch(tableName) == null){
                String statement = "CREATE TABLE \"" + tableName + "\""
                        + "(fileName varchar(2000), \n"
                        + "absoluteFilePath varchar(2000) primary key, \n"
                        + "fileExtension varchar(2000), \n"
                        + "fileByteSize int)";
                runCommand(statement);
                runCommand("INSERT INTO " + allDirectoriesTable + "(directoryName) \n VALUES ('" +tableName+ "')");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return tableName;
    }

    public void insertFile(DatabaseFileEntry fileToInsert, String tableName){
        String statement = "INSERT INTO \"" + tableName + "\"(fileName,absoluteFilePath,fileExtension,fileByteSize) \n"
                + "VALUES ('" + fileToInsert.getFileName() + "','" + fileToInsert.getAbsoluteFilePath() + "','" + fileToInsert.getFileExtension() + "'," + fileToInsert.getFileByteSize() + ")";
        try{
            runCommand(statement);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<DatabaseFileEntry> getFileEntries (String tableName){
        ArrayList<DatabaseFileEntry> foundEntries = new ArrayList<>();
        try{
            ResultSet result = runCommand("SELECT * FROM \"" + tableName + "\"");
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
            ResultSet tablesInDatabase = runCommand("SELECT * FROM "+allDirectoriesTable);
            if(tablesInDatabase != null){
                while(tablesInDatabase.next()){
                    foundTables.add(tablesInDatabase.getString("directoryName"));
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

    public String tableSearch(String tableSearchFor) throws SQLException{
        ResultSet result = runCommand("SELECT * FROM " + allDirectoriesTable + " \n WHERE directoryName = '"+tableSearchFor+"'");
        if(result.next()){
            return result.getString("directoryName");
        }
        return null;
    }
}
