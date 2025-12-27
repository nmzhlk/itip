package lab5;

import java.util.regex.*;

public class IPAddressChecker {
    public static void main(String[] args) {
        try {
            String ip = "192.168.1.1";
            Pattern pattern = Pattern
                    .compile("^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$");
            Matcher matcher = pattern.matcher(ip);

            if (matcher.matches()) {
                System.out.println("IP-адрес " + ip + " корректен");
            } else {
                System.out.println("IP-адрес " + ip + " не корректен");
            }

        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }
}
