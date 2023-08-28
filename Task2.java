import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Task2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String inputText = "";

    System.out.println("Welcome to the Word Counter!");

    System.out.print("Enter '1' to input text manually or '2' to provide a file: ");
    int inputType = scanner.nextInt();
    scanner.nextLine();

    if (inputType == 1) {
      System.out.print("Enter your text: ");
      inputText = scanner.nextLine();
    } else if (inputType == 2) {
      System.out.print("Enter the path of the file: ");
      String filePath = scanner.nextLine();
      try {
        inputText = new String(Files.readAllBytes(new File(filePath).toPath()));
      } catch (IOException e) {
        System.err.println("Error reading the file: " + e.getMessage());
        System.exit(1);
      }
    } else {
      System.out.println("Invalid input type.");
      System.exit(1);
    }

    String[] words = inputText.split("[\\s.,;!?()\\-]+");

    int totalWordCount = 0;
    Set<String> uniqueWords = new HashSet<>();
    Map<String, Integer> wordFrequency = new HashMap<>();

    for (String word : words) {
      word = word.toLowerCase();
      if (!word.isEmpty()) {
        totalWordCount++;
        uniqueWords.add(word);
        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
      }
    }

    System.out.println("\nWord Count: " + totalWordCount);
    System.out.println("Unique Words: " + uniqueWords.size());

    System.out.println("\nWord Frequency:");
    for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    scanner.close();
  }
}