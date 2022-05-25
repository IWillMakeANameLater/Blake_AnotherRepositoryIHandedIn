package com.databasetest.fileHandler;

import com.databasetest.databases.DatabaseFileEntry;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Interacts with the local files of the system directly, retrieving information from directories
 * Does not directly communicate with the database or the database handler - that is for the communicator to do
 */
public class LocalSystemFileHandler {

    /**
     * No need to create instances of this class
     */
    private LocalSystemFileHandler(){

    }

    /**
     * Gets a requested path as a File directory
     * @param requestPath requested path
     * @return directory as a File, or null if it was not a valid directory/couldn't be found/doesn't exist
     */
    public static File getDirectory(String requestPath){
        File baseDirectory = new File(requestPath);
        if(!baseDirectory.exists() || !FileUtils.isDirectory(baseDirectory) ){
            return null;
        }
        return baseDirectory;
    }

    /**
     * Gets all files from a valid directory and returns them as an arraylist of DatabaseFileEntries (format that is compatible with the database)
     * @param requestDirectory valid directory to scan
     * @return an arraylist of DatabaseFileEntries
     */
    public static ArrayList<DatabaseFileEntry> getFileEntriesFromDirectory (File requestDirectory){
        ArrayList<DatabaseFileEntry> foundFiles = new ArrayList<>();
        Iterator<File> fileIterator = FileUtils.iterateFiles(requestDirectory, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        while(fileIterator.hasNext()){
            File nextFile = fileIterator.next();
            foundFiles.add(getInfoFromFile(nextFile));
        }
        return foundFiles;
    }

    private static DatabaseFileEntry getInfoFromFile(File requestFile){
        String fileName = requestFile.getName();
        String absoluteFilePath = requestFile.getAbsolutePath();
        String fileExtension = FilenameUtils.getExtension(fileName);
        Integer fileByteSize = (int) FileUtils.sizeOf(requestFile);
        DatabaseFileEntry newEntry = new DatabaseFileEntry(fileName, absoluteFilePath, fileExtension, fileByteSize);
        return newEntry;
    }
}
