package com.databasetest.fileHandler;

import com.databasetest.databases.DatabaseFileEntry;
import com.databasetest.databases.DatabaseHandler;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class FileHandler {

    public File getDirectory(String requestPath){
        File baseDirectory = new File(requestPath);
        if(!FileUtils.isDirectory(baseDirectory)){
            return null;
        }
        return baseDirectory;
    }

    public ArrayList<DatabaseFileEntry> getFileEntriesFromDirectory (File requestDirectory){
        ArrayList<DatabaseFileEntry> foundFiles = new ArrayList<>();
        Iterator<File> fileIterator = FileUtils.iterateFiles(requestDirectory,null, TrueFileFilter.INSTANCE);
        while(fileIterator.hasNext()){
            File nextFile = fileIterator.next();
            foundFiles.add(getInfoFromFile(nextFile));
        }
        return foundFiles;
    }

    private DatabaseFileEntry getInfoFromFile(File requestFile){
        String fileName = requestFile.getName();
        String absoluteFilePath = requestFile.getAbsolutePath();
        String fileExtension = FilenameUtils.getExtension(fileName);
        Integer fileByteSize = (int) FileUtils.sizeOf(requestFile);
        return new DatabaseFileEntry(fileName, absoluteFilePath, fileExtension, fileByteSize);
    }
}
