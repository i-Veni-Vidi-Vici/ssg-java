package com.ssg.api.string;

public class StringProcess {


    public String preChar(String str) {
//        return str.charAt(0).toLowerCase(str); // String은 이뮤터블이라 직접 못바꿈..
        String result = str.substring(0,1).toUpperCase()+ str.substring(1);
        return result ;
    }

    //문자열에서 찾는 문자가 몇개 포함되어 있는지
    public int charSu(String str, char c) {
        int num =0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c){
                num++;
            }
        }
        return num;
    }
}
