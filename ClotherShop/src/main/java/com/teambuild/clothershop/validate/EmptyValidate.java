package com.teambuild.clothershop.validate;

public class EmptyValidate {
    public static boolean emptyValidate(String string) {
        if (!string.trim().equals("")){
            return true;
        }
        return false;
    }
}
