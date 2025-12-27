package tasks6;

import java.util.*;

public class IsValid {
    public static String isValid(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> countFreq = new HashMap<>();
        for (int freq : freqMap.values()) {
            countFreq.put(freq, countFreq.getOrDefault(freq, 0) + 1);
        }

        if (countFreq.size() == 1) {
            return "YES";
        }
        if (countFreq.size() == 2) {
            List<Integer> keys = new ArrayList<>(countFreq.keySet());
            int k1 = keys.get(0);
            int k2 = keys.get(1);
            int v1 = countFreq.get(k1);
            int v2 = countFreq.get(k2);

            if ((k1 == 1 && v1 == 1) || (k2 == 1 && v2 == 1)) {
                return "YES";
            }
            if ((k1 - k2 == 1 && v1 == 1) || (k2 - k1 == 1 && v2 == 1)) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(isValid(s));
    }
}