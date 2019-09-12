package com.teambuild.clothershop.validate;

public class CodesValidate {
    public static boolean codesValidate(String codes) {
        String CODES_REGEX = "[A-Za-z0-9_]+";
        if (codes.matches(CODES_REGEX)) {
            return true;
        }
        return false;
    }
}
