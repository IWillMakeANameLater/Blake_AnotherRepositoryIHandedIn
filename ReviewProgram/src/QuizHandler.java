
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class QuizHandler {
    private ArrayList<QuizQuestion> questions;

    public QuizHandler() throws IOException { // Get Questions
        this.questions = SaveLoadQuizHandler.loadQuestions();
    }

    public void saveQuestion(QuizQuestion question) throws IOException {
        this.questions.add(question);
        SaveLoadQuizHandler.saveQuiz(this.questions);
    }

    public ArrayList<QuizQuestion> getRandomQuestions(int questions){
        if (questions > this.questions.size() || questions <= 0){
            return null; // Impossible to fetch that many questions
        }
        Random randomNumber = new Random();
        ArrayList<Integer> randomQuestionNumbers = new ArrayList<>();
        while(randomQuestionNumbers.size() < questions){
            Integer newPosition = randomNumber.nextInt(this.questions.size());
            if (!randomQuestionNumbers.contains(newPosition)){
                randomQuestionNumbers.add(newPosition);
            }
        }
        ArrayList<QuizQuestion> returnedQuestions = new ArrayList<>();
        for(Integer position : randomQuestionNumbers){
            returnedQuestions.add(this.questions.get(position));
        }
        return returnedQuestions;
    }

    public int getQuizLength(){
        return questions.size();
    }
}
