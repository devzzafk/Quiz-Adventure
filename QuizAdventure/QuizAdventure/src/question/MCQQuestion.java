package question;

import exception.InvalidInputException;

public class MCQQuestion extends Question {

    private final String[] options;
    private final int correctOption; // 1-based, matches what the player types

    public MCQQuestion(String text, String[] options, int correctOption) {
        super(text);
        this.options = options;
        this.correctOption = correctOption;
    }

    @Override
    public void display() {
        super.display();
        for (int i = 0; i < options.length; i++) {
            System.out.println("  " + (i + 1) + ". " + options[i]);
        }
    }

    @Override
    public boolean checkAnswer(String input) throws InvalidInputException {
        int choice;
        try {
            choice = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter the option number.");
        }
        if (choice < 1 || choice > options.length) {
            throw new InvalidInputException(
                    "Choose a number between 1 and " + options.length + ".");
        }
        return choice == correctOption;
    }

    @Override
    public String getCorrectAnswerText() {
        return correctOption + ". " + options[correctOption - 1];
    }
}
