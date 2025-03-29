package com.sh.io._01.file;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 * java.io.File
 * -jdk1.0부터 지원한 파일/디렉토리 제어 클래스
 * - 실제파일(가상파일)을 가리키는 !자바 객체! 이다.
 * </pre>
 *
 *
 *
 */


public class App {

    public static final String ROOT = "KimNakyoung/_14_io/"; // 프로젝트 루트 (상대경로)
    public static void main(String[] args) {
        File file = new File(ROOT + "test.txt");
        System.out.println(file); // KimNakyoung/_14_io/test.txt 실제 파일 결로로 toStirng 오버라이딩 되어있음
        System.out.println(file.getParent()); // KimNakyoung/_14_io
        System.out.println(file.getName()); // test.txt
        System.out.println(file.exists()); // 지금은 없으니까 false // 만들면 true
        System.out.println(file.isDirectory()); // 이거 파일이야? 디렉토리야?
        System.out.println(file.length()); // 파일의 크기 파일의 크기는 메소드 쓰네? 문자열길이 아는 거랑같은거 쓰는구나


        //파일 생성
        try {
            boolean bool = file.createNewFile();
            System.out.println(bool ? "파일을 생성했습니다." : "파일이 이미 존재합니다.");

            System.out.println(file.getAbsolutePath()); // 절대 경로 반환함
            // C:\Workspaces\java_workspace\KimNakyoung\_14_io\test.tx
            // 절대경로 : 루트디렉토리부터 시작되는 경로 윈도우 C:\~, D:\~, 맥/리눅스/유닉스 /Users/honggd~
            // 상대경로 : 현재파일 기준으로 작성된 경로 현재디렉토리 ./~, 부모디렉토리 ../~
        } catch (IOException e) {
            e.printStackTrace(); // 에러변수.프린트스택트레스
        }

        //파일 삭제
        boolean bool = file.delete();
        System.out.println(bool ? "파일을 삭제했습니다." : " 파일을 삭제하지 못했습니다.");
    }
}
