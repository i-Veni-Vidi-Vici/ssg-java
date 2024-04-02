package com.sh.io._01.file;

import java.io.File;

/**
 * <pre>
 * 디렉토리 관리
 * - 존재하는/존재하지 않는 디렉토리를 가리킬 수 있음
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        File dir = new File(App.ROOT);
        System.out.println(dir); // ParkJeongeun\_14_io
        System.out.println(dir.isDirectory()); // true
        System.out.println(dir.exists()); // true

        // 디렉토리 내부 파일 확인
        File[] files = dir.listFiles();
        for (File f : files){
            if (f.isDirectory())
                System.out.println(f.getName() + "/");
            else
                System.out.println(f.getName());
        }

        // 디렉토리 생성
        File myDir = new File(dir, "abc");
        if (myDir.exists()) {
            System.out.println("abc디렉토리 존재");
        } else {
            boolean bool = myDir.mkdir();
            System.out.println(bool ? "abc디렉토리 생성" : "abc디렉토리 생성 실패");
        }
    }
}
