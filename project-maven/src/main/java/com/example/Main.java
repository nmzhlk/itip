package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        text = text.trim();
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            logger.info("Enter text to count words:");

            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                int count = countWords(input);

                logger.info("Word Count: {}", count);

                try {
                    ObjectMapper mapper = new ObjectMapper();
                    WordCountResult result = new WordCountResult(input, count);

                    String serializedResult = mapper.writeValueAsString(result);
                    logger.info("Serialized JSON Result:\n{}", serializedResult);

                    WordCountResult deserializedResult = mapper.readValue(serializedResult, WordCountResult.class);
                    logger.info("Deserialized JSON Result:\n{}\n{}", deserializedResult.getOriginalText(),
                            deserializedResult.getWordCount());
                } catch (Exception e) {
                    logger.error("JSON Write Error", e);
                }
            }
            scanner.close();
        } catch (Exception e) {
            logger.error("Unexpected error: ", e);
        }

    }
}

class WordCountResult {
    private final String originalText;
    private final int wordCount;

    public WordCountResult() {
        this.originalText = "";
        this.wordCount = 0;
    }

    public WordCountResult(String text, int count) {
        this.originalText = text;
        this.wordCount = count;
    }

    public String getOriginalText() {
        return originalText;
    }

    public int getWordCount() {
        return wordCount;
    }
}