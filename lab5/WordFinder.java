package lab5;

import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        try {
            String text = "I just love the joy of Java programming";
            char startLetter = 'j';

            Pattern pattern = Pattern.compile("\\b" + startLetter + "[a-zA-Z]*\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            System.out.println("Слова, начинающиеся с буквы '" + startLetter + "'");
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }
}
