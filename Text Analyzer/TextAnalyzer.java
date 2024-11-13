import java.io.*;
import java.util.*;

public class TextAnalyzer {

    public static void main(String[] args) {
        String filePath = "kia.txt"; 
        StringBuilder text = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
            return;
        }

        String content = text.toString();

        int wordCount = content.split("\\s+").length;

        int sentenceCount = content.split("[.!?]").length;

        String upperCaseContent = content.toUpperCase();

        String longestWord = "";
        for (String word : content.split("\\W+")) {  
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        System.out.println("Word Count: " + wordCount);
        System.out.println("Sentence Count: " + sentenceCount);
        System.out.println("Text in Uppercase:\n" + upperCaseContent);
        System.out.println("Longest Word: " + longestWord);
        
        String contentWithoutPunctuation = content.replaceAll("[^a-zA-Z0-9\\s]", "");

        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : contentWithoutPunctuation.split("\\s+")) {
            word = word.toLowerCase();
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        System.out.println("\nWord Frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nContent with Line Numbers:");
        String[] lines = content.split("\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println("Line " + (i + 1) + ": " + lines[i]);
        }
    }
}
