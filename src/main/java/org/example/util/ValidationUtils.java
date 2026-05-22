package org.example.util;

public class ValidationUtils {

    public static boolean isValidMark(double mark) {

        return mark >= 0 && mark <= 100;
    }
}