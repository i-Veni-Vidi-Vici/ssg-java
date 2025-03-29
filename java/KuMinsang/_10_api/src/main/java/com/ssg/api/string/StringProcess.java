package com.ssg.api.string;

public class StringProcess {
    /**
     * 문자열을 넘겨받아 첫글자를 대문자로 바꾸는 메소드
     * @param helloWorld
     * @return
     */
    public String preChar(String helloWorld) {
        return helloWorld.toUpperCase().charAt(0)+helloWorld.substring(1,helloWorld.length());
    }

    /**
     * 문자열에서 찾는 문자가 몇개 포함되어 있는지 반환하는 메소드
     * @param applicationCarCable
     * @param c
     * @return
     */
    public int charSu(String applicationCarCable, char c) {
        int cnt=0;
        for(int i =0; i<applicationCarCable.length(); i++){
            if(applicationCarCable.charAt(i)==c)
                cnt++;
        }
        return cnt;
    }
}
