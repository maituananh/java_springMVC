package com.teambuild.clothershop.validate;

public class QualityValidate {
    public static boolean qualityValidate(String quality) {
        try {
            Integer.parseInt(quality);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
