package question;

public class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    public TrueFalseQuestion(String text, String category,
                             boolean correctAnswer) {
        super(text, category);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void display() {
        System.out.println("\n" + getText());
        System.out.println("1. True");
        System.out.println("2. False");
    }

    @Override
    public boolean checkAnswer(String answer) {
        if (answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("true")) {
            return correctAnswer;
        }
        if (answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("false")) {
            return !correctAnswer;
        }
        return false;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer ? "True" : "False";
    }
}
