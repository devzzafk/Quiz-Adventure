package question;

public abstract class Question {
    private String text;
    private String category;

    public Question(String text, String category) {
        this.text = text;
        this.category = category;
    }

    public String getText() { return text; }
    public String getCategory() { return category; }

    public abstract boolean checkAnswer(String answer);
    public abstract void display();
    public abstract String getCorrectAnswer();
}
