package play;

import java.util.Scanner;

class TrueFalseQuestion extends Question {

    private String question;
    private boolean correctAnswer;

    public TrueFalseQuestion(String question, boolean correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    protected void displayQuestion() {
        System.out.println("True/False Question: " + question);
    }

    protected String getUserAnswer() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Svar med True eller False: ");
        String answer = scan.nextLine();
        return answer;
    }

    protected boolean checkAnswer(String answer) {
        boolean userAnswer = Boolean.parseBoolean(answer);
        return userAnswer == correctAnswer;
    }
}

