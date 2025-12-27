package tasks6;

import java.util.*;
import java.util.stream.Collectors;

public class SortParams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        scanner.close();

        System.out.println(sortParams(url));
    }

    public static String sortParams(String url) {
        int qIndex = url.indexOf('?');
        if (qIndex == -1) {
            return url;
        }

        String base = url.substring(0, qIndex);
        String queryPart = url.substring(qIndex + 1);

        if (queryPart.isEmpty()) {
            return base;
        }

        String[] params = queryPart.split("&");
        List<Param> validParams = new ArrayList<>();

        for (String param : params) {
            String[] kv = param.split("=", 2);
            if (kv.length == 2 && !kv[1].isEmpty()) {
                validParams.add(new Param(kv[0], kv[1]));
            }
        }

        if (validParams.isEmpty()) {
            return base;
        }

        validParams.sort((a, b) -> {
            int lengthCompare = Integer.compare(a.value.length(), b.value.length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return a.name.compareTo(b.name);
        });

        String newQuery = validParams.stream()
                .map(p -> p.name + "=" + p.value)
                .collect(Collectors.joining("&"));

        return base + "?" + newQuery;
    }

    static class Param {
        String name;
        String value;

        Param(String n, String v) {
            name = n;
            value = v;
        }
    }
}
