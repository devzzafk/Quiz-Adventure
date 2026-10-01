package quiz;

import java.util.ArrayList;

import question.Question;

public class Quiz {

    private final String category;
    private final ArrayList<Question> questions;

    public Quiz(String category) {
        this.category = category;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public String getCategory() {
        return category;
    }
}
