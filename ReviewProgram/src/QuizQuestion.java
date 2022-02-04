public class QuizQuestion {
    // Fields
    private String question;
    private String expectedAnswer;

    // Constructor;
    public QuizQuestion(String question, String expectedAnswer){
        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }

    // Getters

    public String getExpectedAnswer(){
        return this.expectedAnswer;
    }

    // Check answer
    public boolean checkAnswer(String submittedAnswer){
        return expectedAnswer.equals(submittedAnswer);
    }

    @Override
    public String toString(){
        return this.question;
    }
}
