🎯 QUIZ ADVENTURE

An Interactive Quiz Game Using Core Java

📌 About the Project

Quiz Adventure is a Java-based interactive quiz game developed as a mini project to demonstrate the practical application of Java programming and Object-Oriented Programming (OOP) concepts.

The game allows a player to participate in a quiz by selecting a category and difficulty level, answering questions, and receiving a score based on their performance.

The project focuses on applying OOP concepts such as encapsulation, abstraction, inheritance, polymorphism, constructors, and method overriding in a simple and interactive application.

🎯 Objectives
To develop an interactive quiz game using Core Java.
To allow players to select quiz categories and difficulty levels.
To display questions and evaluate submitted answers.
To calculate and display the player's score.
To apply Java and OOP concepts through a practical application.
To develop a modular and easy-to-maintain Java application.


🎮 Game Flow
START
  ↓
PLAYER DETAILS
  ↓
SELECT CATEGORY / DIFFICULTY
  ↓
START QUIZ
  ↓
DISPLAY QUESTION
  ↓
SUBMIT ANSWER
  ↓
EVALUATE ANSWER
  ↓
UPDATE SCORE
  ↓
MORE QUESTIONS?
  ↓
FINAL RESULT


✨ Key Features
Player details entry
Category selection
Difficulty selection
Multiple-choice questions
True/False questions
Answer evaluation
Score calculation
Sequential question display
Final score and result
Invalid input handling

☕ Java & OOP Concepts Used
Encapsulation

Protects the internal data of classes and provides controlled access through methods.

Abstraction

The Question class provides a common structure for different types of questions without exposing unnecessary implementation details.

Inheritance

MCQQuestion and TrueFalseQuestion inherit common properties and behaviour from the Question class.

Polymorphism

A common Question reference can represent different question types and invoke their respective implementations.

Method Overriding

Different question classes provide their own implementation of methods such as displaying and checking answers.

Constructors

Used to initialize objects such as players and questions.

this Keyword

Used to refer to the current object when initializing or accessing instance members.

Access Modifiers

Used to control access to class members and protect data.

Exception Handling

Used to handle invalid input and prevent the application from terminating unexpectedly.

🧩 Main Classes
                    Question
                 <<Abstract Class>>
                         │
             ┌───────────┴───────────┐
             ↓                       ↓
      MCQQuestion             TrueFalseQuestion
             │                       │
             └───────────┬───────────┘
                         ↓
                        Quiz
                         │
                    QuizManager
                    /         \
                   ↓           ↓
                Player       Score

Player

Stores player information and maintains the player's score.

Question

Abstract class containing the common structure and behaviour of questions.

MCQQuestion

Represents multiple-choice questions.

TrueFalseQuestion

Represents True/False questions.

Quiz

Maintains and manages the collection of questions.

QuizManager

Controls the overall quiz session and game flow.

Score

Responsible for score-related operations.

📂 Project Structure

QuizAdventure/
│
├── src/
│   ├── main/
│   │   └── Main.java
│   │
│   ├── player/
│   │   └── Player.java
│   │
│   ├── question/
│   │   ├── Question.java
│   │   ├── MCQQuestion.java
│   │   └── TrueFalseQuestion.java
│   │
│   ├── quiz/
│   │   ├── Quiz.java
│   │   └── QuizManager.java
│   │
│   └── exception/
│       └── InvalidInputException.java
│
└── README.md


🛠️ Technologies Used
Programming Language: Java
Programming Paradigm: Object-Oriented Programming
Development: Core Java
Data Structures: Arrays / Collections
Exception Handling: Java Exception Handling
📈 Expected Outcome

The completed application will allow the player to:

Enter player details.
Select a quiz category and difficulty.
Answer questions sequentially.
Receive immediate answer evaluation.
Track their score.
View the final result.
🚀 Future Scope

The project can be extended with:

Graphical User Interface
More quiz categories
More difficulty levels
Larger question banks
Leaderboard
Player score history
Database-based question and score storage
Timer-based quizzes

👥 Team Members
DEVI CHANDRAN S
DEVIKA NA
DEVIKA VIJIKUMAR
DEVU NANDITHA A S
