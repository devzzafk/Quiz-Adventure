package question;

public class MCQQuestion extends Question {
    private String[] options;
    private int correctOption;

    public MCQQuestion(String text, String category,
                       String[] options, int correctOption) {
        super(text, category);
        this.options = options;
        this.correctOption = correctOption;
    }

    @Override
    public void display() {
        System.out.println("\n" + getText());
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    @Override
    public boolean checkAnswer(String answer) {
        try {
            return Integer.parseInt(answer) == correctOption;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getCorrectAnswer() {
        return correctOption + ". " + options[correctOption - 1];
    }
}
