package com.sh.io._01.file;

import java.io.File;
import java.io.IOException;

/**
 * java.io.File
 * -jdk1.0부터 지원한 파일/디렉토리 제어 클래스
 * -실제파일(가상파일)을 가리키는 자바객체이다.
 */
public class App {
    public static final String ROOT = "java/YoonDohwan/_14_io/";
    public static void main(String[] args) {
        File file = new File(ROOT+"test.txt");
        System.out.println(file); //
        System.out.println(file.getParent());
        System.out.println(file.getName());
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        try {

            boolean bool = file.createNewFile();
            System.out.println(bool?"파일을 생성했습니다.":"파일이 이미 존재합니다.");
            System.out.println(file.getAbsolutePath());//절대경로
            //상대경로 : 현재파일 기준으로 작성된 경로₩
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}
