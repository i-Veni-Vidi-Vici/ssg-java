package com.sh.io._02.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App6 {
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("/Users/yoondohwan/copyme.rtf" );
            FileWriter fw = new FileWriter(App.ROOT+"pasted.txt");){
            int data=0;
            while((data=fr.read())!=-1){
                System.out.println((char)data);
                fw.write(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
