package com.teambuild.clothershop.validate;

public class EmptyValidate {
    public static boolean emptyValidate(String string) {
        if (!string.trim().isEmpty()){
            return true;
        }
        return false;
    }
}
