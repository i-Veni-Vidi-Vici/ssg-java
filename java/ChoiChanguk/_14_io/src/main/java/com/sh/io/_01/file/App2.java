package com.sh.io._01.file;

import java.io.File;
import java.io.FileReader;

/**
 * <pre>
 * 디렉토리 관리
 * - 존재하는 or 하지 않는, 디렉토리 가리킬 수 있다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        File dir=new File(App1.ROOT);
        System.out.println(dir);
        System.out.println("경로인가?? : "+dir.isDirectory());
        System.out.println("경로가 존재하니?? : "+dir.exists());

        //디렉토리 내부 파일 확인
        File[] files=dir.listFiles();
        for(File f:files)
        {
            if(f.isDirectory())
                System.out.println(f.getName()+"/");

            else System.out.println(f.getName());
        }

        //디렉토리 생성 가능 = 폴더 생성느낌
        File myDir=new File(dir,"abc");
        if (myDir.exists()) {
            System.out.println("abc디렉토리 존재");
        }
        else {
            boolean bool=myDir.mkdir();//makeDir
            System.out.println(bool?"abc디렉토리 생성완료":"디렉토리 생성실패");

        }

    }
}
