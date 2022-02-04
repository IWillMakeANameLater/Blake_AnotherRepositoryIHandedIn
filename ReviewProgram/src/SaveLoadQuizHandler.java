
import java.io.*;
import java.util.ArrayList;

public class SaveLoadQuizHandler {
    private static final File saveFile = new File("src/QuizQuestions.txt");

    private static FileReader baseReader;
    private static BufferedReader quizReader;

    private static FileWriter baseWriter;
    private static BufferedWriter quizWriter;

    private static final String quizQuestionStartTag = "<--QUIZQUESTION-->";
    private static final String questionTag = "QUESTION:";
    private static final String answerTag = "ANSWER:";
    private static final String seperatorTag = "-->";
    private static final String terminateTag = "<--END-->";

    public static void saveQuiz(ArrayList<QuizQuestion> questions) throws IOException{
        PrintWriter clearWriter = new PrintWriter(saveFile);
        clearWriter.close(); // Empty existing file

        baseWriter = new FileWriter(saveFile, true);
        quizWriter = new BufferedWriter(baseWriter);

        for(QuizQuestion question : questions){
            quizWriter.write(quizQuestionStartTag + "\n");
            quizWriter.write(questionTag + question.toString() + seperatorTag + "\n");
            quizWriter.write(answerTag + question.getExpectedAnswer() + seperatorTag + "\n");
            quizWriter.write(terminateTag + "\n");
        }

        quizWriter.close();
    }

    public static ArrayList<QuizQuestion> loadQuestions() throws IOException {
        if(!saveFile.exists()){
            return null;
        }
        baseReader = new FileReader(saveFile);
        quizReader = new BufferedReader(baseReader);

        ArrayList<QuizQuestion> questions = new ArrayList<>();

        String currentLine;
        boolean readingQuestion = false;
        String currentQuestion = "";
        String currentAnswer = "";

        while((currentLine = quizReader.readLine()) != null){
            if(currentLine.equals(quizQuestionStartTag)){
                readingQuestion = true;
                continue;
            } else if (currentLine.equals(terminateTag)){
                readingQuestion = false;
                questions.add(new QuizQuestion(currentQuestion, currentAnswer));
                currentQuestion = "";
                currentAnswer = "";
                continue;
            }
            if (readingQuestion){

                int endCutoffPoint = currentLine.indexOf(seperatorTag);
                currentLine = currentLine.substring(0, endCutoffPoint); // cut off end tag

                if(currentLine.contains(questionTag)){
                    currentLine = currentLine.substring(questionTag.length()); // cut off start tag
                    currentQuestion = currentLine;
                } else if (currentLine.contains(answerTag)){
                    currentLine = currentLine.substring(answerTag.length()); // cut off start tag
                    currentAnswer = currentLine;
                }
            }
        }

        return questions;
    }

}
