package com.sh.io._01.file;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 *     java.io.File
 *      - jdk1.0 부터 지원한 파일/디렉토리 제어 클래스
 *      - 실제 파일(가상파일)을 가리키는 자바객체이다.
 * </pre>
 */
public class App {
    public static final String ROOT= "KimYeonChan/_14_io/"; // 프로젝트 루트
    public static void main(String[] args) {
        File file = new File(ROOT + "test.txt");
        System.out.println(file);
        System.out.println(file.getParent());
        System.out.println(file.getName());
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.length());

        try {
            boolean bool = file.createNewFile();
            System.out.println(bool ? "파일 생성": "파일 생성 실패");

            // 절대 경로: 루트디렉토리부터 시작되는 경로
            // 상대 경로: 프로젝트루트
            System.out.println(file.getAbsoluteFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        boolean bool = file.delete();
        System.out.println(bool ? "파일 삭제" : "파일 삭제 불가");
    }
}
