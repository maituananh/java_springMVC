package com.teambuild.clothershop.validate;

public class PriceValidate {
    public static boolean priceValidate(String price) {
        String PRICE_REGEX = "[-+]?[0-9]*\\.?[0-9]+";
        if (price.matches(PRICE_REGEX)) {
            return true;
        }
        return false;
    }
}
