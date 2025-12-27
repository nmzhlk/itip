package lab5;

import java.util.regex.*;

public class CapitalLetterFinder {
    public static void main(String[] args) {
        try {
            String text = "helloWorld testingCode isFun iLoveJava";
            Pattern pattern = Pattern.compile("[a-z][A-Z]");
            Matcher matcher = pattern.matcher(text);

            String result = text;
            while (matcher.find()) {
                String found = matcher.group();
                System.out.println(found);
                result = result.replace(found, "!" + found + "!");
            }

            System.out.println("Исходный текст: " + text);
            System.out.println("Результат: " + result);

        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в синтаксисе регулярного выражения:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }
}
