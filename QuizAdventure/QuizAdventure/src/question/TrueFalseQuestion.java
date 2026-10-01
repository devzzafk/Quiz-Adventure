package question;

import exception.InvalidInputException;

public class TrueFalseQuestion extends Question {

    private final boolean correctAnswer;

    public TrueFalseQuestion(String text, boolean correctAnswer) {
        super(text);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("  (Enter true or false)");
    }

    @Override
    public boolean checkAnswer(String input) throws InvalidInputException {
        String answer = input.trim().toLowerCase();
        if (answer.equals("true") || answer.equals("t")) {
            return correctAnswer;
        }
        if (answer.equals("false") || answer.equals("f")) {
            return !correctAnswer;
        }
        throw new InvalidInputException("Please enter true or false.");
    }

    @Override
    public String getCorrectAnswerText() {
        return String.valueOf(correctAnswer);
    }
}
