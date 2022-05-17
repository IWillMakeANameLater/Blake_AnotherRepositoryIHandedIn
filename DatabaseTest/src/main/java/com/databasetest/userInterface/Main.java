package com.databasetest.userInterface;

import com.databasetest.databases.DatabaseFileEntry;
import com.databasetest.databases.DatabaseHandler;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DatabaseHandler DB = new DatabaseHandler();
        FileDatabaseCommunicator communicator = new FileDatabaseCommunicator(DB);

        Scanner userInputReader = new Scanner(System.in);

        MainProgramLoop: while(true){
            System.out.println("Menu:");
            System.out.println("1 - Upload a directory to the database");
            System.out.println("2 - View current directories and files");
            System.out.println("3 - Quit the program");
            switch(userInputReader.nextLine()){
                case("1") -> {
                    UploadFileLoop: while(true){ // Upload Menu
                        System.out.println("Input file path of target directory.");
                        System.out.println("Input \"Back\" to return to the menu.");
                        String filePath = userInputReader.nextLine();
                        if(!filePath.equals("Back")){
                            if(communicator.uploadDirectory(filePath)){
                                System.out.println("Successfully uploaded directory.");
                            } else {
                                System.out.println("Bad path - not a directory or does not exist.");
                                continue UploadFileLoop;
                            }
                        }
                        System.out.println("Returning to main menu.");
                        break UploadFileLoop;
                    }
                }
                case("2") -> { // Search menu
                    SearchLoop: while(true){ // Search Menu
                        System.out.println("Search Menu:");
                        System.out.println("1 - Show All Tables");
                        System.out.println("2 - Show Files in a Table");
                        System.out.println("3 - Return to Main Menu");
                        switch(userInputReader.nextLine()){
                            case("1") -> {
                                System.out.println("\nTables in database: ");
                                for(String tableName:DB.getTables()){
                                    System.out.print(tableName + ", ");
                                }
                            }
                            case("2") -> {
                                FileSearchLoop: while(true){
                                    System.out.println("Input a table.");
                                    String tableName = userInputReader.nextLine();
                                    if(DB.doesTableExist(tableName)){
                                        System.out.println("Input search parameters. Keep both empty to show all files.");
                                        String parameterName = userInputReader.nextLine();
                                        String parameterValue = userInputReader.nextLine();
                                        if(parameterName.equals("") && parameterValue.equals("")){
                                            for(DatabaseFileEntry fileEntry:DB.getFileEntries(tableName)){
                                                System.out.println(fileEntry);
                                            }
                                        }else{
                                            for(DatabaseFileEntry fileEntry:DB.getFileEntries(tableName, parameterName, parameterValue)){
                                                System.out.println(fileEntry);
                                            }
                                        }
                                        break FileSearchLoop;
                                    }else{
                                        System.out.println("Table not found");
                                    }
                                }
                            }
                            case("3") -> {
                                System.out.println("Returning to Main menu");
                                break SearchLoop;
                            }
                            default -> {
                                System.out.println("Input not recognized");
                            }
                        }
                    }
                }
                case("3") -> { // End program
                    break MainProgramLoop;
                }
                default -> { // Unknown input
                    System.out.println("Input not recognized");
                }
            }
        }
        System.out.println("Closing program.");
    }
}
