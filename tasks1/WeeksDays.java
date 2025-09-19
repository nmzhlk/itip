package tasks1;

import java.util.Scanner;

public class WeeksDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(daysToWeeks(n));
    }

    public static String daysToWeeks(int n) {
        int week = n / 7;
        int day = n % 7;
        String weekWord = "";
        String dayWord = "";

        if (week == 1) {
            weekWord = "неделя";
        } else if (week >= 2 && week <= 4) {
            weekWord = "недели";
        } else {
            weekWord = "недель";
        }

        if (day == 1) {
            dayWord = "день";
        } else if (day >= 2 && day <= 4) {
            dayWord = "дня";
        } else {
            dayWord = "дней";
        }
        return Integer.toString(week) + " " + weekWord + " и " + Integer.toString(day) + " " + dayWord;
    }
}
