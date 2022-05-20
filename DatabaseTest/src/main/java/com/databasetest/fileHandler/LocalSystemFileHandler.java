package com.databasetest.fileHandler;

import com.databasetest.databases.DatabaseFileEntry;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class LocalSystemFileHandler {

    public static File getDirectory(String requestPath){
        File baseDirectory = new File(requestPath);
        if(!baseDirectory.exists() || !FileUtils.isDirectory(baseDirectory) ){
            return null;
        }
        return baseDirectory;
    }

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
