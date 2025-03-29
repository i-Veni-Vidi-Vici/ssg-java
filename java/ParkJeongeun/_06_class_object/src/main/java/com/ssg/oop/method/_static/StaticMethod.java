package com.ssg.oop.method._static;

public class StaticMethod {
    public String toUpper(String str) {
        str = str.toUpperCase();
        return str;
    }
    public String setChar(String str, int i, char ch){
        char[] arr = str.toCharArray();
        arr[i] = ch;
        return new String(arr);
    }
    public int getAlphabetLength(String str){
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (((char) str.charAt(i) >= 65 && (char) str.charAt(i) <= 90) || ((char) str.charAt(i) >= 97) && ((char) str.charAt(i) <= 122)){
                result++;
            }
        }
        return result;
    }
    public String concat(String str1, String str2){
        String result  = str1 + str2;
        return result;
    }
}
