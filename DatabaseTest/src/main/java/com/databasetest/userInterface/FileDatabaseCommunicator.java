package com.databasetest.userInterface;

import com.databasetest.databases.DatabaseFileEntry;
import com.databasetest.databases.DatabaseHandler;
import com.databasetest.fileHandler.LocalSystemFileHandler;

import java.io.File;
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
}
