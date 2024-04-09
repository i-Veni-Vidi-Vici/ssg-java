package com.ssg.exception.charcheck;

public class CharacterProcess {
    public CharacterProcess() {
    }

    public int countAlpha(String s) {
        try {
            for (int i = 0; i < s.length(); i++) {
                if (s.contains("A")) {

                }
            }
            return 0;
        } catch (CharCheckException e) {
            System.out.println();
            return 0;
        }
    }
}
