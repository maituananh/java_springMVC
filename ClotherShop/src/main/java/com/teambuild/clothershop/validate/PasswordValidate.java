package com.teambuild.clothershop.validate;

public class PasswordValidate {
    public static boolean passwordValidate(String password) {
        String PASSWORD_REGEX = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,30}";
        if(password.matches(PASSWORD_REGEX)) {
            return true;
        }
        return false;
    }
}