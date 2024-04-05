package com.sh.io._01.file;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 *     java.io.File
 *     - jdk 1.0부터 지원한 파일/디렉토리 제어 클래스
 *     - 실제 파일(가상 파일)을 가리키는 자바 객체이다
 * </pre>
 */
public class App {
    public static final String ROOT = "HongJimin/_14_io/"; //프로젝트 루트를 의미 - 상대 경로 ㅣ
    public static void main(String[] args) {
        File file = new File(ROOT + "test.txt");
//        File file = new File(ROOT + "test.txt");// 부모 디렉토리 , 파일 명
//        File file = new File("C:\\Workspaces\\java_workspace\\HongJimin\\_14_io:"); //절대 경로

        System.out.println(file); // Honjimin\_14_io\test.txt 파일 경로로 toString 오버라이드 되어 있음
        System.out.println(file.getParent()); //HonJimin\_14_io
        System.out.println(file.getName()); //test.txt
        System.out.println(file.exists()); //false -> true / 파일 있냐고 물어보는 메소드
        System.out.println(file.isFile()); // false -> true
        System.out.println(file.isDirectory()); // false
        System.out.println(file.length()); // 0 -> 37 byte 세주는 것

        //파일 생성
        try {
            boolean bool = file.createNewFile();
            System.out.println(bool ? "파일을 생성했습니다." : "파일이 이미 존재합니다.");

            //절대 경로 : 루트 디렉토리부터 시작되는 경로 윈도우 -> C:\~, D:\~, 맥/리눅스/유닉스 -> /Users/honggd/~
            //상대 경로 : 현재 파일 기준으로 작성된 경로 -> 현재 디렉토리 ./~, 부모 디렉토리 ../~
            System.out.println(file.getAbsolutePath()); //C:\Workspaces\java_workspace\HongJimin\_14_io\test.txt
        } catch (IOException e) {
            e.printStackTrace();
        }

        //파일 삭제
        boolean bool = file.delete();
        System.out.println(bool ? "파일을 삭제했습니다." : "파일을 삭제하지 못했습니다.");
    }
}
