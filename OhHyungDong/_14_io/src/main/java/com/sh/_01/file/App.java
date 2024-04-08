package com.sh._01.file;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 *   java.io.File
 *   - jdk1.0부터 지원한 파일 / 디렉토리 제어 클래스
 *   - 실제 파일(가상파일)을 가리키는 자바 객체이다.
 * </pre>
 */
public class App {
    public static final String ROOT = "OhHyungDong/_14_io/"; // 프로젝트 루트(상대경로)
    public static void main(String[] args) {
        File file = new File(ROOT + "test.txt");
        System.out.println(file);
        System.out.println(file.getParent());//OhHyungDong/_14_io
        System.out.println(file.getName());//test.txt
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.length()); // 0 -> 37 (단위 : byte)

        //파일 생성
        try {
            boolean bool = file.createNewFile();//파일 만들었으면 - true, 이미 존재하거나 만들지 못했으면 ->false
            System.out.println(bool ? "파일을 생성 했습니다. " : " 파일이 이미 존재합니다.");

            //절대 경로 : 루트 디렉토리부터 시작되는 경로 C : \~, D : \~m 맥/리눅스/유닉스/ => 루트부터 시작 /Users//honggd/
            //상대 경로 : 현재 파일로 기준으로 작성된 경로 ㅎ션재 디렉토리 ./~, 부모디렉콜이 ../~
            System.out.println(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //파일 삭제
        boolean delete = file.delete();
        System.out.println(delete ? "파일을 삭제 했습니다. " : " 파일이 삭제하지 못했습니다.");

    }
}
