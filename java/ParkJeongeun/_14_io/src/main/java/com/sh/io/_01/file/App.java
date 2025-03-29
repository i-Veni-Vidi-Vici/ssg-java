package com.sh.io._01.file;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 * java.io.File
 * - jdk1.0부터 지원한 파일/디렉토리 제어 클래스
 * - 실제 파일(or 가상파일)을 가리키는 자바 객체임
 * </pre>
 */
public class App {
    public static final String ROOT = "ParkJeongeun/_14_io/"; // 프로젝트 루트 (상대경로)
    public static void main(String[] args) {
        File file = new File(ROOT + "test.txt");
        System.out.println(file); // ParkJeongeun\_14_io\test.txt 파일경로로 toString 오버라이드 되어있음
        System.out.println(file.getParent()); // ParkJeongeun\_14_io
        System.out.println(file.getName()); // test.txt
        System.out.println(file.exists()); // false -> file.createNewFile() 후 true
        System.out.println(file.isFile()); // false -> file.createNewFile() 후 true
        System.out.println(file.isDirectory()); // false
        System.out.println(file.length()); // 0 -> 24

        try {
            boolean bool = file.createNewFile();
            System.out.println(bool ? "파일 생성함" : "파일 이미 존재함");

            // 절대경로 : 루트디렉토리부터 시작되는 경로 (윈도우 : C:\~, D:\~ 맥/리눅스/유닉스 : /Users/honggd/~)
            // 상대경로 : 현재 파일 기준으로 작성된 경로 (현재디렉토리 의미 : ./~, 부모디렉토리 의미 : ../~)
            System.out.println(file.getAbsolutePath()); // 절대경로) C:\Workspaces\java_workspace\ParkJeongeun\_14_io\test.txt
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 파일 삭제
        boolean bool = file.delete();
        System.out.println(bool ? "파일 삭제함" : "파일 삭제 못함");
    }
}
