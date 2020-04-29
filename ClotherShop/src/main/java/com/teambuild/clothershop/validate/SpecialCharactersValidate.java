package com.teambuild.clothershop.validate;

public class SpecialCharactersValidate {
    public static boolean specialCharactersValidate(String string) {
        String specialCharacters = "[^A-Za-z0-9]";
        if (string.matches(specialCharacters)) {
            return true;
        }
        return false;
    }
}
