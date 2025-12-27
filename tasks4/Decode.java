package tasks4;

import java.util.*;

public class Decode {
    public static int[] decode(String[] inputStrings) {
        String message = inputStrings[0].trim();
        String key = inputStrings[1].trim();
        int length = message.length();
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int messageCharValue = message.charAt(i) - 'A' + 1;
            int keyCharValue = key.charAt(i % key.length()) - 'A' + 1;
            result[i] = messageCharValue ^ keyCharValue;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine().replace("\"", "").replaceAll("\\s+", "");
        scanner.close();
        String[] inputStrings = inputLine.split(",");
        System.out.println(Arrays.toString(decode(inputStrings)));
    }
}