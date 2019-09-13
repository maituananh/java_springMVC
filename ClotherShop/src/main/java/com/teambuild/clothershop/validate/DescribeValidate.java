package com.teambuild.clothershop.validate;

public class DescribeValidate {
    public static Boolean describeValidate(String describe){
        String DESCRIBE_REGEX = "^[a-z0-9._-]{20,250}$";
        if (describe.matches(DESCRIBE_REGEX)) {
            return true;
        }
        return false;
    }
}
