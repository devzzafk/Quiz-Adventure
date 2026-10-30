package quiz;

import java.util.ArrayList;
import java.util.Scanner;
import player.Player;
import question.Question;
import exception.InvalidInputException;

public class QuizManager {
    private Quiz quiz;
    private ScoreManager scoreManager;

    public QuizManager(Quiz quiz) {
        this.quiz = quiz;
        this.scoreManager = new ScoreManager();
    }

    public void start(Player player, Scanner scanner) {
        boolean playAgain = true;

        while (playAgain) {
            playOneRound(player, scanner);
            scoreManager.saveTopScore(player.getName(), player.getScore());
            scoreManager.displayTopScores();

            System.out.print("\nWould you like to play again? (Y/N): ");
            String choice = scanner.nextLine().trim();
            playAgain = choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("YES");

            if (playAgain) {
                player.resetScore();
                System.out.println("\nStarting a new round. Good luck!");
            }
        }

        System.out.println("\nThanks for playing Quiz Adventure!");
    }

    private void playOneRound(Player player, Scanner scanner) {
        ArrayList<Question> questions = quiz.getRandomizedQuestions();
        System.out.println("\n=== QUIZ STARTED ===");
        System.out.println("Questions have been shuffled for this round!");

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + " of " + questions.size());
            question.display();

            try {
                System.out.print("Your answer: ");
                String answer = scanner.nextLine().trim();

                if (answer.isEmpty()) {
                    throw new InvalidInputException("Answer cannot be empty.");
                }

                if (question.checkAnswer(answer)) {
                    System.out.println("Correct!");
                    player.addScore(1);
                } else {
                    System.out.println("Incorrect!");
                }
            } catch (InvalidInputException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }

            System.out.print("Would you like to see the correct answer? (Y/N): ");
            String showAnswer = scanner.nextLine().trim();
            if (showAnswer.equalsIgnoreCase("Y") || showAnswer.equalsIgnoreCase("YES")) {
                System.out.println("Correct answer: " + question.getCorrectAnswer());
            }
        }

        System.out.println("\n========== FINAL RESULT ==========");
        System.out.println("Player: " + player.getName());
        System.out.println("Score: " + player.getScore() + "/" + questions.size());
        double percentage = questions.isEmpty() ? 0.0
                : (player.getScore() * 100.0 / questions.size());
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.println("==================================");
    }
}
