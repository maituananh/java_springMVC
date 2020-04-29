package com.teambuild.clothershop.utils;

import java.util.Random;

public class RenameFile {
    private String temporaryFilename;

//    public String getTemporaryFilename() {
//        return this.temporaryFilename;
//    }
//
//    public void setTemporaryFilename(String temporaryFilename) {
//        this.temporaryFilename = renameFile() + cutSuffixFile(temporaryFilename);
//    }
//
//    private String cutSuffixFile(String nameFile) {
//        String cutSuffixFile = nameFile.substring(nameFile.lastIndexOf(".")).trim();
//        return cutSuffixFile;
//    }
//
//    private String renameFile() {
//        int leftLimit = 97; // letter 'a'
//        int rightLimit = 122; // letter 'z'
//        int targetStringLength = 10;
//        Random random = new Random();
//        String generatedString = random.ints(leftLimit, rightLimit + 1)
//                .limit(targetStringLength)
//                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//                .toString();
//        return generatedString;
//    }
}
