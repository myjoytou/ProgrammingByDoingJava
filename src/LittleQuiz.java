import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Vivek Kumar on 19/8/16.
 * A simple quiz
 */
public class LittleQuiz {
    private int correctResponse;
    private int incorrectResponse;
    private ArrayList<Map> questions = new ArrayList<>();

    private LittleQuiz() {
        this.correctResponse = 0;
        this.incorrectResponse = 0;
    }

    private void initializeQuiz() {
        Path file = Paths.get("quiz_questions.txt");
        try (BufferedReader reader = Files.newBufferedReader(file, Charset.defaultCharset())) {
            String line;
            while ((line = reader.readLine()) != null) {
                Map<String, Object> question = new HashMap<>();
                String [] questionObj = line.split(":");
                question.put("question", questionObj[0]);
                String [] options = questionObj[1].split(",");
                question.put("options", options);
                question.put("answer", questionObj[2]);
                questions.add(question);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    private void updateCorrectCount() {
        this.correctResponse++;
    }

    private void updateIncorrectCount() {
        this.incorrectResponse++;
    }

    private ArrayList<Map> getQuestions() {
        return questions;
    }

    private void printQuestion(String question, int index) {
        System.out.println(String.format("Q%d) %s", index, question));
    }

    private void printOptions(String [] options) {
        for (int i = 0, size = options.length; i < size; ++i) {
            System.out.println(String.format("%4d) %s", i, options[i]));
        }
    }

    private boolean checkCorrectness(String correctAnswer, String response) {
        return correctAnswer.equals(response);
    }

    private void printSuccessMessage() {
        System.out.println("That's correct!");
    }

    private void printFailureMessage() {
        System.out.println("Wrong answer!");
    }

    private void printStats() {
        System.out.println(
                String.format("Overall you got %d out of %d correct",
                        this.correctResponse,
                        (this.correctResponse + this.incorrectResponse)));
        System.out.println("Thanks for playing!");
    }

    private void startQuiz() {
        Scanner in = new Scanner(System.in);
        for (int i = 0, size = questions.size(); i < size; ++i) {
            printQuestion((String) questions.get(i).get("question"), i);
            String [] options = (String []) questions.get(i).get("options");
            printOptions(options);
            int response = in.nextInt();
            String correctAnswer = (String) questions.get(i).get("answer");
            boolean correct = checkCorrectness(correctAnswer.trim(), options[response].trim());
            if (correct) {
                updateCorrectCount();
                printSuccessMessage();
            }
            else {
                updateIncorrectCount();
                printFailureMessage();
            }
        }
        printStats();
    }

    public static void main(String[] args) {
        LittleQuiz lq = new LittleQuiz();
        lq.initializeQuiz();
        lq.startQuiz();
    }
}
