# Quiz Adventure - Updated Java Source Code

## Features
- MCQ and True/False questions.
- Randomized question order for every round.
- Option to reveal the correct answer after each question.
- Play-again option with the score reset for each new round.
- Persistent top-five leaderboard saved in `high_scores.txt`.
- Each player's best score is retained; a lower replay score does not replace it.
- Blank-answer handling through the custom `InvalidInputException`.

## Requirements
- Java JDK 8 or later.
- VS Code, IntelliJ IDEA, Eclipse, or any terminal.

## Compile (run from the project root)
```powershell
javac -d out src/main/Main.java src/player/*.java src/question/*.java src/quiz/*.java src/exception/*.java
```

## Run
```powershell
java -cp out main.Main
```

The program creates `high_scores.txt` in the directory from which it is run. Keep this file if you want leaderboard scores to remain available between sessions. Do not delete it unless you want to reset the leaderboard.
