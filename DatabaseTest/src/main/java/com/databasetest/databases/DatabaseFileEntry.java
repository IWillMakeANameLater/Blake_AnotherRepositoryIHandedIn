package com.databasetest.databases;

/**
 * Represents a row inside the table
 * Each instance holds the values of every column
 */
public class DatabaseFileEntry {
    private String fileName;
    private String absoluteFilePath;
    private String fileExtension;
    private Integer fileByteSize;

    public DatabaseFileEntry(String fileName, String absoluteFilePath, String fileExtension, Integer fileByteSize){
        this.fileName = fileName;
        this.absoluteFilePath = absoluteFilePath;
        this.fileExtension = fileExtension;
        this.fileByteSize = fileByteSize;
    }

    public String getFileName() {
        return fileName;
    }

    public String getAbsoluteFilePath() {
        return absoluteFilePath;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public Integer getFileByteSize() {
        return fileByteSize;
    }


    @Override
    public String toString(){
        return "File Name: " + this.fileName + "\n"
                + "File Absolute Path: " + this.absoluteFilePath + "\n"
                + "File Extension: " + this.fileExtension + "\n"
                + "File Size (In Bytes): " + this.fileByteSize;
    }
}
