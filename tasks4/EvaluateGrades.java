package tasks4;

import java.util.*;

public class EvaluateGrades {
    public static String evaluateGrades(String[] gradeStrings) {
        Map<String, Integer> gradeCounts = new LinkedHashMap<>();
        gradeCounts.put("A", 0);
        gradeCounts.put("B", 0);
        gradeCounts.put("C", 0);
        gradeCounts.put("D", 0);
        gradeCounts.put("F", 0);

        for (String gradeString : gradeStrings) {
            int grade = Integer.parseInt(gradeString.trim());

            if (grade >= 90 && grade <= 100) {
                gradeCounts.put("A", gradeCounts.get("A") + 1);
            } else if (grade >= 80 && grade <= 89) {
                gradeCounts.put("B", gradeCounts.get("B") + 1);
            } else if (grade >= 70 && grade <= 79) {
                gradeCounts.put("C", gradeCounts.get("C") + 1);
            } else if (grade >= 60 && grade <= 69) {
                gradeCounts.put("D", gradeCounts.get("D") + 1);
            } else if (grade >= 0 && grade <= 59) {
                gradeCounts.put("F", gradeCounts.get("F") + 1);
            }
        }

        StringBuilder result = new StringBuilder("{");
        boolean isFirst = true;

        for (Map.Entry<String, Integer> entry : gradeCounts.entrySet()) {
            if (entry.getValue() > 0) {
                if (!isFirst) {
                    result.append(", ");
                }
                result.append(entry.getKey()).append(": ").append(entry.getValue());
                isFirst = false;
            }
        }

        result.append("}");
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        if (input.equals("[]")) {
            System.out.println("{}");
        } else {
            String cleanedInput = input.replace("[", "").replace("]", "");
            String[] grades = cleanedInput.split(",");

            System.out.println(evaluateGrades(grades));
        }
        scanner.close();
    }
}