package quiz;

import java.util.ArrayList;
import java.util.Collections;
import question.Question;

public class Quiz {
    private ArrayList<Question> questions = new ArrayList<>();

    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Returns a shuffled copy so the original question bank remains unchanged.
    public ArrayList<Question> getRandomizedQuestions() {
        ArrayList<Question> randomized = new ArrayList<>(questions);
        Collections.shuffle(randomized);
        return randomized;
    }

    public int getQuestionCount() {
        return questions.size();
    }
}
