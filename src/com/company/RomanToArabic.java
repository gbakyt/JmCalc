package com.company;
import java.util.*;

public class RomanToArabic {
    static Scanner scanner = new Scanner(System.in);

    static int romanToArabicMethod(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int s1 = valueOf(str.charAt(i));
            if (i + 1 < str.length()) {
                int s2 = valueOf(str.charAt(i + 1));
                if (s1 >= s2) {
                    result += s1;
                } else {
                    result +=  + s2 - s1;
                    i++;
                }
            } else {
                result += + s1;
            }
        }

        return result;
    }
    static int valueOf(char c) {
        if (c == 'I')
            return 1;
        else if (c == 'V')
            return 5;
        else if (c == 'X')
            return 10;
        else if (c == 'L')
            return 50;
        else if (c == 'C')
            return 100;
        else if (c == 'D')
            return 500;
        else if (c == 'M')
            return 1000;
        return 0;
    }
}