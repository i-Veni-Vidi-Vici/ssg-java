package com.sh.io._01.file;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 * java.io.File
 * - jdk1.0부터 지원한 파일/디렉토리 제어 클래스
 * - 실제파일(가상파일)을 가리키는 자바객체이다.
 * </pre>
 */
public class App {
    public static final String ROOT = "ByeonSeongil/_14_io/";

    public static void main(String[] args) {

        File file = new File(ROOT + "test.txt");
        System.out.println(file); // 파일경로로 toString오버라이드 됨
        System.out.println(file.getParent());
        System.out.println(file.getName());
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        try {
            boolean bool = file.createNewFile();
            System.out.println(bool ? "파일 생성" : "파일 존재");

            // 절대경로 : 루트디렉토리부터 시작되는 경로. 윈도우 C:\~, D:\~, 맥/리눅스/유닉스 /Users/honggd/~
            // 상대경로 : 현재파일 기준으로 작성된 경로. 현재디렉토리 ./~, 부모디렉토리 ../~
            System.out.println(file.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 파일삭제
        boolean bool = file.delete();
        System.out.println(bool ? "파일 삭제" : "파일 삭제 완");
    }
}
