package org.example.stringutils;

import org.apache.commons.lang3.StringUtils;

public class StringProcessor {
    
    public static String reverseString(String input) {
        return StringUtils.reverse(input);
    }
    
    public static String capitalizeString(String input) {
        return StringUtils.capitalize(input);
    }
    
    public static String reverseAndCapitalize(String input) {
        return StringUtils.capitalize(StringUtils.reverse(input));
    }
    
    public static boolean isBlank(String input) {
        return StringUtils.isBlank(input);
    }
    
    public static int getLength(String input) {
        return StringUtils.length(input);
    }
}