package com.databasetest.userInterface;

import com.databasetest.databases.DatabaseFileEntry;
import com.databasetest.databases.DatabaseHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final String backCommand = "<Go Back>";
    private static Scanner userInputReader;

    public static void main(String[] args) throws SQLException {
        DatabaseHandler DB = new DatabaseHandler();
        FileDatabaseCommunicator communicator = new FileDatabaseCommunicator(DB);

        userInputReader = new Scanner(System.in);

        HashMap<Integer, String> mainMenuChoices = createDialogueChoices(new int[]{1, 2},new String[]{"Upload a directory to the database", "View current directories and files"});
        HashMap<Integer, String> searchMenuChoices = createDialogueChoices(new int[]{1, 2},new String[]{"Show All Tables", "Show Files in a Table"});
        HashMap<Integer, String> tableSearchMenuChoices = createDialogueChoices(new int[]{1, 2, 3, 4, 5}, new String[]{"Filter by file name", "Filter by file absolute path", "Filter by file extension", "Filter by file size", "No filter"});

        System.out.println("To go back, or to exit the program from the main menu, use \""+backCommand+"\"");

        MainProgramLoop: while(true){
            System.out.println("\nMain Menu:");
            switch(dialogueOptionHandler(mainMenuChoices)){
                case(1) -> {
                    UploadFileLoop: while(true){ // Upload Menu
                        System.out.println("Input file path of target directory.");
                        String filePath = userInputReader.nextLine();
                        if(!filePath.equals(backCommand)){
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
                case(2) -> { // Search menu
                    SearchLoop: while(true){ // Search Menu
                        System.out.println("Search Menu:");
                        switch(dialogueOptionHandler(searchMenuChoices)){
                            case(1) -> {
                                ArrayList<String> databaseTables = DB.getTables();
                                if(databaseTables.size() > 1){
                                    System.out.println("\nTables in database: ");
                                    for(String tableName:databaseTables){
                                        System.out.print(tableName + ", ");
                                    }
                                }else{
                                    System.out.println("No tables exist");
                                }
                                System.out.println("\n");
                            }
                            case(2) -> {
                                FileSearchLoop: while(true){
                                    System.out.println("Input a table.");
                                    String tableName = userInputReader.nextLine();
                                    if(DB.getTables().contains(tableName)){
                                        System.out.println("Table found, showing files: \n");
                                        ArrayList<DatabaseFileEntry> foundEntries = new ArrayList<>();
                                        switch(dialogueOptionHandler(tableSearchMenuChoices)){
                                            case(1) ->{
                                                System.out.print("\nFile Name to Search For: ");
                                                String searchFileName = userInputReader.nextLine();
                                                foundEntries = communicator.getFilesFromDatabase(tableName, "File Name", searchFileName);
                                            }
                                            case(2) ->{
                                                System.out.print("\nFile Absolute Path to Search For: ");
                                                String searchFileAbsolutePath = userInputReader.nextLine();
                                                foundEntries = communicator.getFilesFromDatabase(tableName, "File Absolute Path", searchFileAbsolutePath);
                                            }
                                            case(3) ->{
                                                System.out.print("\nFile Extension to Search For: ");
                                                String searchFileExtension = userInputReader.nextLine();
                                                foundEntries = communicator.getFilesFromDatabase(tableName, "File Extension", searchFileExtension);
                                            }
                                            case(4) ->{
                                                System.out.print("\nFile Size to Search For: ");
                                                String searchFileSize = userInputReader.nextLine();
                                                foundEntries = communicator.getFilesFromDatabase(tableName, "File Size", searchFileSize);
                                            }
                                            case(5) ->{
                                                System.out.println("Displaying all entries.");
                                                foundEntries = communicator.getFilesFromDatabase(tableName);
                                            }
                                            case(-1) ->{
                                                System.out.println("Returning to search menu");
                                                break FileSearchLoop;
                                            }
                                        }
                                        if(foundEntries.size() < 1){
                                            System.out.println("Nothing was found");
                                        }
                                        for(DatabaseFileEntry fileEntry:foundEntries){
                                            System.out.println(fileEntry);
                                            System.out.println("");
                                        }
                                    }else if (!tableName.equals(backCommand)){
                                        System.out.println("Table not found");
                                        continue;
                                    }
                                    System.out.println("Returning to search menu.");
                                    break FileSearchLoop;
                                }
                            }
                            case(-1) -> {
                                System.out.println("Returning to Main menu");
                                break SearchLoop;
                            }
                        }
                    }
                }
                case(-1) -> { // End program
                    break MainProgramLoop;
                }
            }
        }
        System.out.println("Closing program.");
    }

    /**
     * Acts as a quick way to get a valid option from the user
     * Uses an infinite loop so that they are forced to put in a valid input to proceed
     * Also handles quit command easily for these type of option menus
     * @param dialogueChoices Map of the options and the associated dialogue
     * @return once the user has made a valid input, returns the kind of input it is
     */
    private static int dialogueOptionHandler(HashMap<Integer,String> dialogueChoices){
        for(Integer dialogueIndex:dialogueChoices.keySet()){
            System.out.println(dialogueIndex.toString() + " - " + dialogueChoices.get(dialogueIndex));
        }
        while(true){
            System.out.print("\nSelect an Option: ");
            String userInput = userInputReader.nextLine();
            if(userInput.equals(backCommand)) {
                return -1;
            }
            try{
                int selectedOption = Integer.parseInt(userInput);
                if(dialogueChoices.containsKey(selectedOption)){
                    return selectedOption;
                }else{
                    System.out.println("Invalid option");
                }
            }catch(NumberFormatException e){
                System.out.println("Bad input, try again.");
            }
        }
    }

    /**
     * Quickly create a hashmap of dialogue choices.
     * Assumes both arrays are of the same size, will cause errors otherwise
     * @param choiceIndexes array of options the user can choose
     * @param choiceDialogues array of dialogue with each option
     * @return a hashMap of dialogue
     */
    private static HashMap<Integer, String> createDialogueChoices(int[] choiceIndexes, String[] choiceDialogues){
        HashMap<Integer, String> dialogueChoices = new HashMap<>();
        for(int i = 0; i<choiceIndexes.length; i++){
            dialogueChoices.put(choiceIndexes[i], choiceDialogues[i]);
        }
        return dialogueChoices;
    }
}
