package quiz;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScoreManager {
    private static final Path SCORE_FILE = Paths.get("high_scores.txt");
    private static final int MAX_ENTRIES = 5;

    private static class ScoreEntry {
        private String name;
        private int score;

        private ScoreEntry(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public void saveTopScore(String name, int score) {
        List<ScoreEntry> scores = loadScores();
        boolean playerFound = false;

        for (ScoreEntry entry : scores) {
            if (entry.name.equalsIgnoreCase(name)) {
                if (score > entry.score) {
                    entry.score = score;
                }
                playerFound = true;
                break;
            }
        }

        if (!playerFound) {
            scores.add(new ScoreEntry(name.replace("|", " "), score));
        }

        scores.sort(Comparator.comparingInt((ScoreEntry entry) -> entry.score).reversed()
                .thenComparing(entry -> entry.name, String.CASE_INSENSITIVE_ORDER));

        if (scores.size() > MAX_ENTRIES) {
            scores = new ArrayList<>(scores.subList(0, MAX_ENTRIES));
        }

        List<String> lines = new ArrayList<>();
        for (ScoreEntry entry : scores) {
            lines.add(entry.name + "|" + entry.score);
        }

        try {
            Files.write(SCORE_FILE, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Unable to save scores: " + e.getMessage());
        }
    }

    public void displayTopScores() {
        List<ScoreEntry> scores = loadScores();
        System.out.println("\n========== TOP 5 SCORES ==========");

        if (scores.isEmpty()) {
            System.out.println("No scores recorded yet.");
        } else {
            for (int i = 0; i < scores.size(); i++) {
                ScoreEntry entry = scores.get(i);
                System.out.println((i + 1) + ". " + entry.name + " - " + entry.score + " points");
            }
        }
        System.out.println("==================================");
    }

    private List<ScoreEntry> loadScores() {
        List<ScoreEntry> scores = new ArrayList<>();
        if (!Files.exists(SCORE_FILE)) {
            return scores;
        }

        try {
            for (String line : Files.readAllLines(SCORE_FILE, StandardCharsets.UTF_8)) {
                String[] parts = line.split("\\|", 2);
                if (parts.length == 2) {
                    try {
                        scores.add(new ScoreEntry(parts[0], Integer.parseInt(parts[1])));
                    } catch (NumberFormatException ignored) {
                        // Skip damaged score entries and continue loading valid ones.
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to read saved scores: " + e.getMessage());
        }
        return scores;
    }
}
