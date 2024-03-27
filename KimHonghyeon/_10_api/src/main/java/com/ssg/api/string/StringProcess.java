package com.ssg.api.string;

public class StringProcess {
    public String preChar(String original){
        char[] charSeq = original.toCharArray();
        if(charSeq[0]>='A' &&charSeq[0]<='Z') return original;
        else{
            charSeq[0] = (char)(charSeq[0] - 32);
            return new String(charSeq);
        }
    }
    public int charSu(String s, char ch){
        int count =0;
        for(int  i=0; i<s.length(); i++){
            if(s.charAt(i)==ch)count++;
        }
        return count;
    }
}
