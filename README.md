<div align="center">

# 🎯 QUIZ ADVENTURE

### 🧠 An Interactive Quiz Game Built with Core Java

**Learn • Play • Challenge Yourself**

<br>

![Java](https://img.shields.io/badge/Java-Core%20Java-orange?style=for-the-badge&logo=openjdk)
![OOP](https://img.shields.io/badge/OOP-Object%20Oriented%20Programming-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-In%20Development-yellow?style=for-the-badge)

</div>

---

## 🎮 About the Project

**Quiz Adventure** is an interactive quiz game developed using **Core Java** as a mini project.

The project provides a simple and engaging quiz experience where players can answer questions, test their knowledge, and receive a final score.

More importantly, the project demonstrates how **Object-Oriented Programming concepts can be applied to a practical application** instead of keeping the entire program inside a single main method.

---

## ✨ What Can You Do?

🎮 **Play a Quiz**  
Answer a series of questions and test your knowledge.

📚 **Choose a Category**  
Select the area of questions you want to attempt.

⚡ **Choose Difficulty**  
Challenge yourself with different difficulty levels.

📝 **Answer Questions**  
Questions are presented sequentially and evaluated by the program.

🏆 **Track Your Score**  
Your score is updated based on your answers.

🎯 **View Your Result**  
At the end of the quiz, your final performance is displayed.

---

## 🕹️ How It Works

```text
                    🎮 START
                       │
                       ▼
                👤 PLAYER DETAILS
                       │
                       ▼
             📚 SELECT CATEGORY
                       │
                       ▼
             ⚡ SELECT DIFFICULTY
                       │
                       ▼
                 📝 START QUIZ
                       │
                       ▼
              ❓ DISPLAY QUESTION
                       │
                       ▼
                ✏️ SUBMIT ANSWER
                       │
                       ▼
              🔍 EVALUATE ANSWER
                       │
                       ▼
                  🏆 UPDATE SCORE
                       │
                       ▼
              ❓ MORE QUESTIONS?
                  /          \
                YES           NO
                 │             │
                 └─────┐       ▼
                       │   🏆 FINAL RESULT
                       │
                       └──► NEXT QUESTION

🏗️ Project Architecture
QuizAdventure/
│
├── 📁 src/
│   │
│   ├── 📁 main/
│   │   └── Main.java
│   │
│   ├── 📁 player/
│   │   └── Player.java
│   │
│   ├── 📁 question/
│   │   ├── Question.java
│   │   ├── MCQQuestion.java
│   │   └── TrueFalseQuestion.java
│   │
│   ├── 📁 quiz/
│   │   ├── Quiz.java
│   │   └── QuizManager.java
│   │
│   └── 📁 exception/
│       └── InvalidInputException.java
│
└── README.md
🧠 Class Structure
                     ┌─────────────────────┐
                     │      Question       │
                     │   <<abstract>>      │
                     └──────────┬──────────┘
                                │
                  ┌─────────────┴─────────────┐
                  │                           │
                  ▼                           ▼
        ┌──────────────────┐       ┌────────────────────┐
        │   MCQQuestion    │       │ TrueFalseQuestion  │
        └──────────────────┘       └────────────────────┘
                  │                           │
                  └─────────────┬─────────────┘
                                │
                                ▼
                       ┌────────────────┐
                       │      Quiz      │
                       └───────┬────────┘
                               │
                               ▼
                      ┌──────────────────┐
                      │   QuizManager    │
                      └───────┬──────────┘
                              │
                    ┌─────────┴─────────┐
                    ▼                   ▼
             ┌────────────┐      ┌────────────┐
             │   Player   │      │   Score    │
             └────────────┘      └────────────┘
☕ Java Concepts Used
Concept	Application
Classes & Objects	Represent players, quizzes and questions
Constructors	Initialize objects
Strings	Store player and question information
Arrays	Store MCQ options
Collections	Manage multiple questions
Methods	Implement individual operations
Control Statements	Control quiz flow
Access Modifiers	Control data accessibility
Abstract Classes	Define common question behaviour
Inheritance	Create specialized question classes
Polymorphism	Handle different question types
Method Overriding	Implement question-specific behaviour
Exception Handling	Handle invalid input
Packages	Organize related classes
🛠️ Technologies
<div align="center">

Java • Core Java • OOP • Collections • Exception Handling

</div>
🚀 Getting Started
1️⃣ Clone the repository
git clone <your-repository-url>
2️⃣ Navigate to the project
cd QuizAdventure
3️⃣ Compile
javac -d out src/main/Main.java src/player/Player.java src/question/*.java src/quiz/*.java src/exception/*.java
4️⃣ Run
java -cp out main.Main
📸 Project Preview

Screenshots of the running application will be added here after implementation.

┌──────────────────────────────────────┐
│          🎯 QUIZ ADVENTURE           │
├──────────────────────────────────────┤
│                                      │
│  Welcome, Player!                    │
│                                      │
│  Select your category:               │
│                                      │
│  [1] Java                            │
│  [2] General Knowledge               │
│  [3] Science                         │
│                                      │
│             [ START ]                │
│                                      │
└──────────────────────────────────────┘
🌱 Future Scope

The project can be further enhanced with:

🖥️ Graphical User Interface
📚 Larger question bank
🎚️ Multiple difficulty levels
🏆 Leaderboard
💾 Persistent score history
⏱️ Timed quizzes
👤 Multiple player profiles
🗄️ Database integration
🎨 Improved visual design


👥 Team
Team Members
Name
DEVI CHANDRAN S
DEVIKA NA
DEVIKA VIJIKUMAR
DEVU NANDITHA A S
<div align="center">
🎯 QUIZ ADVENTURE

Think. Answer. Score. Repeat.

Made with ☕ Java 

</div> ```
