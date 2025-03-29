package com.ssg.thread.sleep;

import com.ssg.thread.alphabet.AlphabetThread;

public class app2 {
    public static void main(String[] args) {
        AlphabetThread upperCaseThread = new AlphabetThread(true);
        AlphabetThread lowerCaseThread = new AlphabetThread(false);

        upperCaseThread.start();
        lowerCaseThread.start();
    }
}
