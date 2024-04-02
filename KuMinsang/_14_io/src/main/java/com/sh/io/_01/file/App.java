package com.sh.io._01.file;

import java.io.File;
import java.io.IOException;

public class App {
    public static final String ROOT = "KuMinsang/_14_io";
    public static void main(String[] args) {
        File file = new File(ROOT + "/test.txt");
        System.out.println(file);   //KuMinsang\_14_io\test.txt 파일경로로 toString 오버라이드 됨
        System.out.println(file.getParent()); //KuMinsang\_14_io
        System.out.println(file.getName()); //test.txt
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.length());

        try {
            boolean bool = file.createNewFile();
            System.out.println(bool? "파일생성 성공" : "파일생성 실패");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //절대경로 : 루트디렉토리부터 시작되는 경로 윈도우 C:\~, D:\~, 맥/리눅스/유닉스 /users/honggd/~
        //상대경로 : 현재파일 기준으로 작성된 경로
        //파일삭제
        boolean bool = file.delete();
        System.out.println(bool? "파일을 삭제했습니다" : "파일을 삭제하지 못했습니다");

    }
}
