package play;

import java.util.Scanner;

public class OpenQuestion extends  Question{
    String question;
    String correctAnswer;

    public OpenQuestion(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    @Override
    protected void displayQuestion() {
        System.out.println("Your open question is: " + question);
    }

    @Override
    protected String getUserAnswer() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Your answer: ");
        String answer = scan.nextLine();
        return answer;
    }

    @Override
    protected boolean checkAnswer(String answer) {
        String userAnswer = (answer);
        return userAnswer.equals(correctAnswer);
    }
}
