package lab5;

import java.util.regex.*;

public class PasswordChecker {
    public static void main(String[] args) {
        try {
            String password = "Password9";
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
            Matcher matcher = pattern.matcher(password);

            if (matcher.matches()) {
                System.out.println("Пароль " + password + " корректен");
            } else {
                System.out.println("Пароль " + password + " не соответствует требованиям!");
                System.out.println(
                        "Требования: латинские буквы и цифры, длина 8-16 символов, минимум одна заглавная буква и одна цифра.");
            }

        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }
}
