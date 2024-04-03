package com.sh.io._01.file;

import java.io.File;

/**
 * 디렉토리 관리
 * -존재하는 (존재하지 않는) 디렉토리를 가리킬수 있다.
 *
 */
public class App2 {
    public static void main(String[] args) {
        File dir = new File(App.ROOT);
        System.out.println(dir);
        System.out.println(dir.isDirectory());
        System.out.println(dir.exists());

        File[] files = dir.listFiles();
        for(File f:files){
            if(f.isDirectory())
                System.out.println(f.getName()+"/");
            else System.out.println(f.getName());
        }
        //디렉토리 생성
        File myDir = new File(dir,"abc");
        if(myDir.exists())
            System.out.println("abc디렉토리가 존재합니다.");
        else{
            boolean bool = myDir.mkdir();
            System.out.println(bool?"abc디렉토리를 생성했습니다.":"abc디렉토리 생성에 실패했습니다.");
        }
    }
}
