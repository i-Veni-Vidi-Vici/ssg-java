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
    public static final String ROOT = "JeonHyeonseon/_14_io/"; // ROOT는 프로젝트 루트를 의미한다(상대경로)
    public static void main(String[] args) {
        File file = new File(ROOT + "test.txt");
        System.out.println(file); // JeonHyeonseon\_14_io\test.txt 파일 경로로 toString 오버라이드 되어 있다.
        System.out.println(file.getParent()); // JeonHyeonseon\_14_io
        System.out.println(file.getName()); // test.txt
        System.out.println(file.exists()); // false -> true
        System.out.println(file.isFile()); // false -> true
        System.out.println(file.isDirectory()); // false
        System.out.println(file.length()); // 파일의 크키, 0 -> 30

        // 파일 생성
        try {
            boolean bool = file.createNewFile(); // createNewFile은 boolean을 받는다.
            System.out.println(bool ? "파일을 생성했습니다." : "파일이 이미 존재합니다.");

            // 절대경로 : 루트디렉토리부터 시작되는 경로, 윈도우 :  C:\~, D:\~ , 맥/리눅스/유닉스 /Users/honggd/~ -> 시작하는게 다르다.
            // 상대경로 : 현재 파일 기준으로 작성된 경로, 현재 디렉토리./~ , 부모디렉토리 ../~
            System.out.println(file.getAbsolutePath()); // 절대경로, C:\Workspaces\java_workspace\JeonHyeonseon\_14_io\test.txt
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 파일 삭제
        boolean bool = file.delete();
        System.out.println(bool ? "파일을 삭제했습니다." : "파일을 삭제하지 못했습니다.");


    }
}
