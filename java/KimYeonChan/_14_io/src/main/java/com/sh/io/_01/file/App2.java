package com.sh.io._01.file;

import java.io.File;

public class App2 {
    public static void main(String[] args) {
        File dir = new File(App.ROOT);
        System.out.println(dir);
        System.out.println(dir.isDirectory());
        System.out.println(dir.exists());

        // 디렉토리 내부 파일 확인
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory())
                System.out.println(f.getName() + "/");
            else
                System.out.println(f.getName());
        }

        // 디렉토리 생성
        File myDir= new File(dir, "abc");
        if (myDir.exists())
            System.out.println("abc 존재");
        else {
            boolean bool = myDir.mkdir();
            System.out.println(bool ? "abc 생성" : "abc 생성 실패");
        }
    }
}
