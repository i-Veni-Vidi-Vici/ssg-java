package com.sh.io._02.stream;

import com.sh.io._01.file.App;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 *     1. copyme.txt 파일을 읽어서 콘솔에 출력하세요.
 *     2. 프로젝트루트에 pasted.txt 파일로 출력하세요.
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        String sourcePath = "/Users/kim-yeonchan/Projects/study_bootcamp/etc/copyme.txt";
        String targetPath = App.ROOT + "pasted.txt";

        try (FileReader fr = new FileReader(sourcePath);
             FileWriter fw = new FileWriter(targetPath);
        ) {
            int data = 0;
            while ((data = fr.read()) != -1) {
                fw.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
