package com.sh.io._02.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * copyme.txt파일을 읽어서 콘솔에 출력하세요.
 * 프로젝트루트에 pasted.txt파일로 출력하세요.
 */
public class App5 {
    public static void main(String[] args) {
        String filePath = "/Users/yoondohwan/copyme.rtf";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line=br.readLine())!=null)
                System.out.println(line);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
