package lab4;

import java.io.*;

class CustomNumberFormatException extends Exception {
    public CustomNumberFormatException(String message) {
        super(message);
    }
}

class ExceptionLogger {
    public static void log(Exception e) {
        try (FileWriter writer = new FileWriter("exceptions.log", true)) {
            writer.write("Ошибка! " + e.getClass().getSimpleName() + " -> " + e.getMessage() + "\n");
        } catch (IOException ioException) {
            System.out.println("Ошибка логирования: " + ioException.getMessage());
        }
    }
}

public class NumberConverter {
    public static int convertToInt(String str) throws CustomNumberFormatException {
        if (str.trim().isEmpty()) {
            throw new CustomNumberFormatException("Строка '" + str + "' пустая");
        }

        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatException("Строка '" + str + "' не является целым числом");
        }
    }

    public static void main(String[] args) {
        String[] testStrings = { "9", "12345", "abc", "лсдуз", "" };

        for (String str : testStrings) {
            try {
                int number = convertToInt(str);
                System.out.println("Преобразованное число: " + number);
            } catch (CustomNumberFormatException e) {
                ExceptionLogger.log(e);
                System.out.println("Ошибка! " + e.getMessage());
            }
        }
    }
}
