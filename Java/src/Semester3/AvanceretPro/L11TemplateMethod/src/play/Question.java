package play;

public abstract class Question {

    // Template Method
    public final void askQuestion() {
        displayQuestion();
        String userAnswer = getUserAnswer();
        if (checkAnswer(userAnswer)) {
            System.out.println("Korrekt svar!");
        } else {
            System.out.println("Forkert svar.");
        }
    }

    // Abstrakte metoder, der skal implementeres af underklasser
    protected abstract void displayQuestion();

    protected abstract String getUserAnswer();

    protected abstract boolean checkAnswer(String answer);
}
