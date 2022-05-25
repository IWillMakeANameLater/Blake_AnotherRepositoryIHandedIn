package com.databasetest.userInterface;

import com.databasetest.databases.DatabaseFileEntry;
import com.databasetest.databases.DatabaseHandler;
import com.databasetest.fileHandler.LocalSystemFileHandler;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Acts as the connecting point between the database handler and the user interface, sending and getting information from these 2 points
 * And indirectly also connects with the local file handler
 */
public class FileDatabaseCommunicator {
    private final DatabaseHandler databaseHandler;

    public FileDatabaseCommunicator(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
    }

    /**
     * Gives a specified path of a valid directory, requests the creation of a table of that directory
     * As well as putting files into it
     * @param requestPath path of the directory to upload
     * @return if it succeeded or not
     */
    public boolean uploadDirectory(String requestPath){
        File baseDirectory = LocalSystemFileHandler.getDirectory(requestPath);
        if(baseDirectory != null){
            String directoryTableName = databaseHandler.createTable(baseDirectory.getName());
            ArrayList<DatabaseFileEntry> directoryFiles = LocalSystemFileHandler.getFileEntriesFromDirectory(baseDirectory);
            for(DatabaseFileEntry fileEntry:directoryFiles){
                databaseHandler.insertFile(fileEntry, directoryTableName);
            }
            return true;
        }
        return false;
    }

    /**
     * Gets entries from a specified table representing a directory and filters through the results to return a select
     * group of file entries that match the search request
     * @param tableName name of table to look through
     * @param searchCategory category/column to search for
     * @param searchValue value to filter for
     * @return an arraylist of found results
     */
    public ArrayList<DatabaseFileEntry> getFilesFromDatabase(String tableName, String searchCategory, String searchValue){
        ArrayList<DatabaseFileEntry> allEntries = databaseHandler.getFileEntries(tableName);
        ArrayList<DatabaseFileEntry> filteredEntries = new ArrayList<>();
        for(DatabaseFileEntry fileEntry:allEntries){
            switch(searchCategory){
                case("File Name") ->{
                    if(fileEntry.getFileName().equals(searchValue)){
                        filteredEntries.add(fileEntry);
                    }
                }
                case("File Absolute Path") ->{
                    if(fileEntry.getAbsoluteFilePath().equals(searchValue)){
                        filteredEntries.add(fileEntry);
                    }
                }
                case("File Extension") ->{
                    if(fileEntry.getFileExtension().equals(searchValue)){
                        filteredEntries.add(fileEntry);
                    }
                }
                case("File Size") ->{
                    if(fileEntry.getFileByteSize() == Integer.parseInt(searchValue)){
                        filteredEntries.add(fileEntry);
                    }
                }
            }
        }
        return filteredEntries;
    }

    /**
     * A variant of getFilesFromDatabase that returns all results from a table
     * Does not filter them at all
     * @param tableName table to search for
     * @return all file entries in that table
     */
    public ArrayList<DatabaseFileEntry> getFilesFromDatabase(String tableName){
        return databaseHandler.getFileEntries(tableName);
    }
}
