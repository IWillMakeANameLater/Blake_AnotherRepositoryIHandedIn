package com.databasetest.databases;

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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAbsoluteFilePath() {
        return absoluteFilePath;
    }

    public void setAbsoluteFilePath(String absoluteFilePath) {
        this.absoluteFilePath = absoluteFilePath;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public Integer getFileByteSize() {
        return fileByteSize;
    }

    public void setFileByteSize(Integer fileByteSize) {
        this.fileByteSize = fileByteSize;
    }

    @Override
    public String toString(){
        return "File Name: " + this.fileName + "\n"
                + "File Absolute Path: " + this.absoluteFilePath + "\n"
                + "File Extension: " + this.fileExtension + "\n"
                + "File Size (In Bytes): " + this.fileByteSize;
    }
}
