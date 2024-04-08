package com.sh.io._01.file;

import java.io.File;
import java.io.IOException;

/**
 * java.io.File
 * - jdk1.0 부터 지원한 파일/디렉토리 제어 클래스
 * - 실제파일(가상파일)을 가리키는 자바객체이다.
 */
public class App {
    public static final String ROOT = "Park-Taejun/_14_io/"; //프로젝트루트 (상대경로)
    public static void main(String[] args) {
        File file = new File(ROOT + "test.txt");
        System.out.println(file);  //Park-Taejun/_14_io/test.txt 파일경로로 toString 오버라이드 되어있다
        System.out.println(file.getParent()); //Park-Taejun \_14 _ io
        System.out.println(file.getName()); // test.txt
        System.out.println(file.exists()); // false -> true
        System.out.println(file.isFile()); // false -> true
        System.out.println(file.isDirectory()); // false
        System.out.println(file.length()); // 0 파일의 크기? ->38

        // 이 메소드의 선언부에 IOExeception 던집니다 try catch 하라고 알려주는것
        // 파일 생성
        try {
         boolean bool =  file.createNewFile();
           System.out.println(bool ? "파일을 생성했습니다" : "파일이 이미 존재");

            //절대경로 : 루트디렉토리부터 시작되는 경로 C:\~, D:\~, 맥/리눅스.유닉스 /Users/honggd/~
            //상대경로 : 현재파일 기준으로 작성된 경로 현재디렉토리 ./~, 부모디렉토리 ../~

            System.out.println(file.getAbsolutePath()); // 절대경로  반환 C:\Park-Taejun\java\Park-Taejun\_14_io\test.txt
       } catch (IOException e){
           e.printStackTrace();
       }

        //파일 삭제
        boolean bool = file.delete();
        System.out.println(bool ? "파일을 삭제했습니다." : "파일을 삭제하지 못했습니다");
    }
}
