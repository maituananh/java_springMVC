package com.teambuild.clothershop.validate;

public class SpecialCharactersValidate {
    public static boolean specialCharactersValidate(String string) {
        String specialCharacters = "^[a-zA-Z0-9._-]$";
        if (string.matches(specialCharacters)) {
            return true;
        }
        return false;
    }
}
