import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

    private static void createQuiz(Scanner inputScanner, QuizHandler quizHandler) throws IOException {
        System.out.println("What is the question?");
        String newQuestion = inputScanner.nextLine();
        System.out.println("What is the answer?");
        String newAnswer = inputScanner.nextLine();
        QuizQuestion newQuizQuestion = new QuizQuestion(newQuestion, newAnswer);
        quizHandler.saveQuestion(newQuizQuestion);
        System.out.println("Created new Quiz Question with Question: \"" + newQuestion + "\" and Answer: \"" + newAnswer + "\"");
        System.out.println("Returning to main...\n");
    }

    private static void runQuiz(Scanner inputScanner, QuizHandler quizHandler){
        System.out.println("How many questions in the quiz?");
        System.out.println("Total number of available questions: " + quizHandler.getQuizLength());
        int quizLength;
        try{
             quizLength = inputScanner.nextInt();
             inputScanner.nextLine(); // Clear input
             ArrayList<QuizQuestion> randomQuizQuestions = quizHandler.getRandomQuestions(quizLength);
             if (randomQuizQuestions == null){
                 System.out.println("Bad input. Number of questions was either too little or too much.");
             } else {
                 System.out.println("Starting Quiz...\n");
                 for(QuizQuestion currentQuestion : randomQuizQuestions){
                     System.out.println("Question: " + currentQuestion.toString());
                     String inputAnswer = inputScanner.nextLine();
                     if(currentQuestion.checkAnswer(inputAnswer)){
                         System.out.println("Answer is correct.");
                     } else {
                         System.out.println("Answer is incorrect.");
                         System.out.println("Expected: " + currentQuestion.getExpectedAnswer());
                         System.out.println("Got: " + inputAnswer);
                     }
                     System.out.println("Next Question...\n");
                 }
                 System.out.println("Quiz finished.");
             }
        } catch (Exception e){
            System.out.println("Bad input.");
        }
        System.out.println("Returning to main...\n");
    }


    public static void main(String[] args) throws IOException {
        QuizHandler quizhandler = new QuizHandler();
        Scanner userInput = new Scanner(System.in);

        mainLoop: while(true){
            System.out.println("What do you want to do?");
            System.out.println("1 - Add A Question");
            System.out.println("2 - Take a Quiz");
            System.out.println("3 - Exit the program");
            int userChoice;
            try{
                userChoice = userInput.nextInt();
                userInput.nextLine(); // clear inputs
                switch(userChoice){
                    case 1:
                        System.out.println("Going to Add a Question...\n");
                        createQuiz(userInput, quizhandler);
                        break;
                    case 2:
                        System.out.println("Running quiz...\n");
                        runQuiz(userInput, quizhandler);
                        break;
                    case 3:
                        System.out.println("Exiting program...\n");
                        break mainLoop;
                    default:
                        System.out.println("Please input a valid option.\n");
                        break;
                }
            } catch (Exception e){
                System.out.println("Bad input. Try again.\n");
                userInput.nextLine();
            }
        }
    }

}
