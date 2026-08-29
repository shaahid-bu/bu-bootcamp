package Module2;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;


public class GradeAnalyzer {

    private static int invalidCount = 0;
    public static void main(String[] args) {
        // ArrayList<Integer> testScores = new ArrayList<>();
        // testScores.add(10);
        // testScores.add(20);
        // testScores.add(30);
        // System.out.println("Test average: " + calculateAverage(testScores));

        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores("scores.txt");
        
        // Step 2: calculate statistics
        double average = calculateAverage(scores);

        int highest = 0;
        int lowest = 0;
        if (!scores.isEmpty()) {
            highest = Integer.MIN_VALUE;
            lowest = Integer.MAX_VALUE;
            for (int score : scores) {
                if (score > highest) {
                    highest = score;
                }
                if (score < lowest) {
                    lowest = score;
                }
                if (score >= 90) {
                    countA++;
                } else if (score >= 80) {
                    countB++;
                } else if (score >= 70) {
                    countC++;
                } else if (score >= 60) {
                    countD++;
                } else {
                    countF++;
                }
            }
        }

        String outputFile = "report.txt";
        String report = String.format(
            "=== Grade Analysis Report ===\n" + //
            "Total scores processed:  %d\n" + //
            "Invalid lines skipped:    %d \n\n" + //
            "Average score:   %.2f\n" + //
            "Highest score:   %d\n" + //
            "Lowest score:     %d\n\n" + //
            "Grade distribution:\n" + //
            "  A (90-100):   %d\n" + //
            "  B (80-89):    %d\n" + //
            "  C (70-79):    %d\n" + //
            "  D (60-69):    %d\n" + //
            "  F (below 60): %d ", scores.size(), invalidCount, average, highest, lowest, countA, countB, countC, countD, countF);

        System.out.println(report);
        writeReport(report, outputFile);
    }
        
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                // skip empty lines
                if (line.isEmpty()) {
                    continue;
                }
                try {
                    int score = Integer.parseInt(line);
                    scores.add(score);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid score found in file: " + line);
                    // Increment the invalid count for each invalid line
                    invalidCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        return scores;
    }
    
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (int score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }
    // Writes and prints the report
    public static void writeReport(String report, String outputFile) {
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(report);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file: " + e.getMessage());
        }
    }
}