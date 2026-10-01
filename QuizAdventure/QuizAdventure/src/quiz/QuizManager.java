package quiz;

import java.util.Scanner;

import exception.InvalidInputException;
import player.Player;
import question.MCQQuestion;
import question.Question;
import question.TrueFalseQuestion;

public class QuizManager {

    private static final String[] CATEGORIES = {
            "Java Basics", "General Knowledge", "Science"
    };

    private final Scanner scanner;
    private Player player;
    private Quiz quiz;

    public QuizManager() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        showWelcome();
        player = createPlayer();
        quiz = chooseQuiz();
        playQuiz();
        showResult();
        scanner.close();
    }

    private void showWelcome() {
        System.out.println("=================================");
        System.out.println("   Welcome to Quiz Adventure!");
        System.out.println("=================================");
    }

    private Player createPlayer() {
        while (true) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            try {
                return new Player(name);
            } catch (InvalidInputException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        }
    }

    private Quiz chooseQuiz() {
        System.out.println("\nHello, " + player.getName() + "! Choose a category:");
        for (int i = 0; i < CATEGORIES.length; i++) {
            System.out.println("  " + (i + 1) + ". " + CATEGORIES[i]);
        }

        while (true) {
            System.out.print("Your choice: ");
            try {
                int choice = parseChoice(scanner.nextLine(), CATEGORIES.length);
                return buildQuiz(choice);
            } catch (InvalidInputException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        }
    }

    private int parseChoice(String input, int max) throws InvalidInputException {
        try {
            int choice = Integer.parseInt(input.trim());
            if (choice < 1 || choice > max) {
                throw new InvalidInputException("Choose a number between 1 and " + max + ".");
            }
            return choice;
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a number.");
        }
    }

    private void playQuiz() {
        System.out.println("\nStarting: " + quiz.getCategory());

        for (int i = 0; i < quiz.getTotalQuestions(); i++) {
            // Polymorphism: the reference type is Question, but display()
            // and checkAnswer() run the MCQ or TrueFalse version at runtime.
            Question question = quiz.getQuestion(i);

            System.out.println("\nQuestion " + (i + 1) + " of " + quiz.getTotalQuestions());
            question.display();
            askUntilValid(question);
        }
    }

    private void askUntilValid(Question question) {
        while (true) {
            System.out.print("Your answer: ");
            String input = scanner.nextLine();
            try {
                if (question.checkAnswer(input)) {
                    System.out.println("Correct!");
                    player.addPoint();
                } else {
                    System.out.println("Wrong. Correct answer: " + question.getCorrectAnswerText());
                }
                return;
            } catch (InvalidInputException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        }
    }

    private void showResult() {
        int total = quiz.getTotalQuestions();
        int score = player.getScore();
        double percentage = (score * 100.0) / total;

        System.out.println("\n=================================");
        System.out.println("Quiz finished, " + player.getName() + "!");
        System.out.println("Final score: " + score + " / " + total);

        if (percentage == 100) {
            System.out.println("Perfect score. Excellent!");
        } else if (percentage >= 60) {
            System.out.println("Well done!");
        } else {
            System.out.println("Keep practising, you will get there.");
        }
        System.out.println("=================================");
    }

    private Quiz buildQuiz(int choice) {
        Quiz newQuiz = new Quiz(CATEGORIES[choice - 1]);

        switch (choice) {
            case 1:
                newQuiz.addQuestion(new MCQQuestion(
                        "Which keyword is used to inherit a class?",
                        new String[]{"implements", "extends", "inherits", "super"}, 2));
                newQuiz.addQuestion(new MCQQuestion(
                        "Which of these is NOT a primitive type?",
                        new String[]{"int", "boolean", "String", "double"}, 3));
                newQuiz.addQuestion(new TrueFalseQuestion(
                        "A Java class can extend two classes at the same time.", false));
                newQuiz.addQuestion(new MCQQuestion(
                        "How many bits does an int use in Java?",
                        new String[]{"8", "16", "32", "64"}, 3));
                newQuiz.addQuestion(new TrueFalseQuestion(
                        "A constructor can have a return type.", false));
                break;
            case 2:
                newQuiz.addQuestion(new MCQQuestion(
                        "What is the capital of Australia?",
                        new String[]{"Sydney", "Canberra", "Melbourne", "Perth"}, 2));
                newQuiz.addQuestion(new TrueFalseQuestion(
                        "The Great Wall of China is visible from the Moon with the naked eye.", false));
                newQuiz.addQuestion(new MCQQuestion(
                        "Which is the largest ocean?",
                        new String[]{"Atlantic", "Indian", "Pacific", "Arctic"}, 3));
                newQuiz.addQuestion(new TrueFalseQuestion(
                        "Mount Everest is the highest mountain above sea level.", true));
                newQuiz.addQuestion(new MCQQuestion(
                        "Which planet is known as the Red Planet?",
                        new String[]{"Venus", "Mars", "Jupiter", "Mercury"}, 2));
                break;
            default:
                newQuiz.addQuestion(new MCQQuestion(
                        "What is the chemical formula of water?",
                        new String[]{"HO2", "H2O", "OH2", "H2O2"}, 2));
                newQuiz.addQuestion(new TrueFalseQuestion(
                        "Sound travels faster in air than in water.", false));
                newQuiz.addQuestion(new MCQQuestion(
                        "Which gas do plants absorb for photosynthesis?",
                        new String[]{"Oxygen", "Nitrogen", "Carbon dioxide", "Hydrogen"}, 3));
                newQuiz.addQuestion(new TrueFalseQuestion(
                        "An adult human body has 206 bones.", true));
                newQuiz.addQuestion(new MCQQuestion(
                        "What is the hardest natural substance?",
                        new String[]{"Gold", "Iron", "Diamond", "Quartz"}, 3));
                break;
        }
        return newQuiz;
    }
}
