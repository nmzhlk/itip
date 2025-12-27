package tasks6;

import java.util.*;

public class Formula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine();
        scanner.close();

        System.out.println(formula(expr));
    }

    public static boolean formula(String expr) {
        String[] parts = expr.split("=");
        double[] values = new double[parts.length];

        for (int i = 0; i < parts.length; i++) {
            values[i] = evaluate(parts[i].trim());
        }

        for (int i = 1; i < values.length; i++) {
            if (Math.abs(values[i] - values[0]) > 1e-9) {
                return false;
            }
        }
        return true;
    }

    private static double evaluate(String expr) {
        expr = expr.replace(" ", "");
        List<Double> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        StringBuilder num = new StringBuilder();
        for (char c : expr.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                numbers.add(Double.parseDouble(num.toString()));
                ops.add(c);
                num.setLength(0);
            } else {
                num.append(c);
            }
        }
        numbers.add(Double.parseDouble(num.toString()));

        for (int i = 0; i < ops.size(); i++) {
            char op = ops.get(i);
            if (op == '*' || op == '/') {
                double a = numbers.get(i);
                double b = numbers.get(i + 1);
                double res = (op == '*') ? a * b : a / b;
                numbers.set(i, res);
                numbers.remove(i + 1);
                ops.remove(i);
                i--;
            }
        }

        double result = numbers.get(0);
        for (int i = 0; i < ops.size(); i++) {
            char op = ops.get(i);
            double next = numbers.get(i + 1);
            if (op == '+') {
                result += next;
            } else {
                result -= next;
            }
        }

        return result;
    }
}