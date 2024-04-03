package com.sh._04.checked;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App4 {
    public static void main(String[] args) {
        FileReader fileReader =null;
        BufferedReader br =null;
        try{
            fileReader = new FileReader("KimHongHyeon/_13_exception/helloworld.txt");
            System.out.println("파일 읽기 성공");
            br = new BufferedReader(fileReader);
            String line = br.readLine();
            while(line!=null){
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("지정된 파일을 찾을 수 없습니다.");
            e.printStackTrace();
        }
        finally{
            try{
                fileReader.close();
                br.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
