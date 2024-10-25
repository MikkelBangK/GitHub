package play;


public class QuizGame extends Game {

    private Question[] questions;

    public QuizGame(Question[] questions) {
        this.questions = questions;
    }

    protected void askQuestions() {
        for (Question question : questions) {
            question.askQuestion();
        }
    }
}

