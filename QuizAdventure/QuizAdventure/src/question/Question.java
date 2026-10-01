package question;

import exception.InvalidInputException;

public abstract class Question {

    private final String text;

    protected Question(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // Subclasses call super.display() to print the question text,
    // then add their own extra lines (options or a hint).
    public void display() {
        System.out.println(text);
    }

    // Each question type validates and checks its input differently.
    public abstract boolean checkAnswer(String input) throws InvalidInputException;

    public abstract String getCorrectAnswerText();
}
