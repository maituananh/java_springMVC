package com.teambuild.clothershop.validate;

public class UserNameValidate {
    public static boolean UserNamevalidate(String userName) {
        String USERNAME_REGEX = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
        if(userName.matches(USERNAME_REGEX)) {
            return true;
        }
        return false;
    }
}
