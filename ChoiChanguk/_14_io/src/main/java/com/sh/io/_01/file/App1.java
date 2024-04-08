package com.sh.io._01.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * <pre>
 * java.io.File
 * - jdk1.0부터 지원한 파일 제어 클래스
 * - 실제 파일(가상파일)을 가리키는 자바객체이다.
 * </pre>
 */
public class App1 {
    public static final String ROOT="ChoiChanguk/_14_io/";//프로젝트 루트, 상대경로
    public static void main(String[] args) {
        File file=new File(ROOT+"test.txt");
        System.out.println("실제파일 위치+파일이름 : "+file);// toString 오버라이드 되어 있음
        System.out.println("실제 파일 위치 : "+file.getParent());
        System.out.println("파일이름 : "+file.getName());
        System.out.println("파일 존재유무 : "+file.exists());
        System.out.println("파일 인가?? : "+file.isFile());
        System.out.println("입력한게 파일 경로야?? : "+file.isDirectory());
        System.out.println("파일 크기 : "+file.length());


        //파일 생성
        try {
            boolean bool=file.createNewFile();//Exception 상속 받음, boolean반환
            System.out.println(bool?"파일 생성완료":"파일이 이미 존재");

            //절대경로 :
            // windows = 루트디렉토리부터 시작되는 경로 ex) C:~, D:~
            // 유닉스 리눅스 맥 = /user/cstangga/~
            //상대경로 : 파일 기준 작성된 경로. 현재디렉토리 ./~, 부모디렉토리 ../~
            System.out.println("절대 경로 반환 : "+file.getAbsolutePath());
            System.out.println("상대 경로 반환 : "+file.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //파일 삭제
        boolean bool=file.delete();
        System.out.println(bool?"파일 제거완료":"파일 삭제 실패");
    }
}
