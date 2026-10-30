package main;

import java.util.Scanner;
import player.Player;
import question.MCQQuestion;
import question.TrueFalseQuestion;
import quiz.Quiz;
import quiz.QuizManager;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("         QUIZ ADVENTURE");
        System.out.println("================================");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            name = "Player";
        }

        Quiz quiz = new Quiz();
        quiz.addQuestion(new MCQQuestion(
                "Which language is used in this project?", "Programming",
                new String[]{"Java", "Python", "C", "HTML"}, 1));
        quiz.addQuestion(new MCQQuestion(
                "Which keyword is used for inheritance in Java?", "Java",
                new String[]{"this", "super", "extends", "static"}, 3));
        quiz.addQuestion(new TrueFalseQuestion(
                "Java supports method overriding.", "Java", true));
        quiz.addQuestion(new TrueFalseQuestion(
                "A constructor has a return type.", "Java", false));

        Player player = new Player(name);
        QuizManager manager = new QuizManager(quiz);
        manager.start(player, scanner);
        scanner.close();
    }
}
