import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String text;
    List<String> options;
    int correctAnswer;

    public Question(String text, List<String> options, int correctAnswer) {
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

class Quiz {
    List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public void runQuiz() {
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);

            System.out.println("Question " + (i + 1) + ": " + question.text);
            for (int j = 0; j < question.options.size(); j++) {
                System.out.println((j + 1) + ". " + question.options.get(j));
            }

            int userAnswer = getUserInput(question.options.size());
            if (userAnswer == question.correctAnswer) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was " + question.correctAnswer + ".\n");
            }
        }

        System.out.println("Your final score is: " + score + "/" + questions.size());
    }

    private int getUserInput(int numOptions) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter your choice (1-" + numOptions + "): ");
                int userInput = Integer.parseInt(scanner.nextLine());

                if (userInput >= 1 && userInput <= numOptions) {
                    return userInput;
                } else {
                    System.out.println("Invalid input. Please enter a number within the specified range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}

public class QuizApp {
    public static void main(String[] args) {
        // Example usage:
        // Create quiz questions
        Question question1 = new Question("What is the capital of France?", List.of("Paris", "Berlin", "Madrid", "Rome"), 1);
        Question question2 = new Question("Which planet is known as the Red Planet?", List.of("Mars", "Venus", "Jupiter", "Saturn"), 1);
        Question question3 = new Question("What is the largest mammal on Earth?", List.of("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"), 2);
        Question question4 = new Question("Which programming language is known for its simplicity and readability?", List.of("Java", "Python", "C++", "JavaScript"), 2);
        Question question5 = new Question("What is the largest ocean on Earth?", List.of("Atlantic Ocean", "Indian Ocean", "Southern Ocean", "Pacific Ocean"), 4);
        Question question6 = new Question("Who is the author of 'To Kill a Mockingbird'?", List.of("J.K. Rowling", "Harper Lee", "George Orwell", "Mark Twain"), 2);
        Question question7 = new Question("What is the powerhouse of the cell?", List.of("Nucleus", "Mitochondria", "Endoplasmic Reticulum", "Golgi Apparatus"), 2);
        Question question8 = new Question("Which country is known as the Land of the Rising Sun?", List.of("China", "South Korea", "Japan", "Vietnam"), 3);


        // Create quiz and add questions
        Quiz quiz = new Quiz();
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);
        quiz.addQuestion(question4);
        quiz.addQuestion(question5);
        quiz.addQuestion(question6);
        quiz.addQuestion(question7);
        quiz.addQuestion(question8);


        // Run the quiz
        quiz.runQuiz();
    }
}
