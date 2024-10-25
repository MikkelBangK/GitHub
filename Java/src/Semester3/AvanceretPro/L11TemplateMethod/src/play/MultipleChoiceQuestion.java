package play;

import java.util.Scanner;

// Konkrete implementeringer af Question
public class MultipleChoiceQuestion extends Question {
    private String question;
    private String[] choices;
    private int correctChoiceIndex;

    public MultipleChoiceQuestion(String question, String[] choices, int correctChoiceIndex) {
        this.question = question;
        this.choices = choices;
        this.correctChoiceIndex = correctChoiceIndex;
    }

    protected void displayQuestion() {
        System.out.println("Multiple Choice Question: " + question);
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }
    }

    protected String getUserAnswer() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nummer på rigtigt svar: ");
        String answer = scan.nextLine();
        return answer;
    }

    protected boolean checkAnswer(String answer) {
        int userChoiceIndex = Integer.parseInt(answer) - 1;
        return userChoiceIndex == correctChoiceIndex;
    }
}

