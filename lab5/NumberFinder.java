package lab5;

import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        try {
            String text = "The price of the product is $999.99. I want to buy 9 of it.";
            Pattern pattern = Pattern.compile("-?\\d+(?:\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);

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
