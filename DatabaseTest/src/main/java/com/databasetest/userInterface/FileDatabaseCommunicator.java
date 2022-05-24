package com.databasetest.userInterface;

import com.databasetest.databases.DatabaseFileEntry;
import com.databasetest.databases.DatabaseHandler;
import com.databasetest.fileHandler.LocalSystemFileHandler;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FileDatabaseCommunicator {
    private final DatabaseHandler databaseHandler;


    public FileDatabaseCommunicator(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
    }

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

    public ArrayList<DatabaseFileEntry> getFilesFromDatabase(String tableName){
        return databaseHandler.getFileEntries(tableName);
    }
}
