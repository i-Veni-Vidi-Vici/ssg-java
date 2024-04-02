package com.sh.io._02.stream;

import javax.annotation.processing.Filer;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 *     1. copyme.txt 파일을 읽어서 콘솔에 출력합니다
 *     2. 프로젝트루트에 pasted.txt 파일로 쓰기하세요
 * </pre>
 */
public class App5 {
    public static void main(String[] args){
        //FileWriter fw=null;
        try(FileReader fr = new FileReader("C:/Users/i/Documents/copyme.txt") ; FileWriter fw = new FileWriter(App.ROOT+"pasted.txt")){
            int len = (int) new File("C:/Users/i/Documents/copyme.txt").length();
            char [] chars = new char[len];
            int readleng = fr.read(chars);
            fw.write(chars,0,readleng);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
