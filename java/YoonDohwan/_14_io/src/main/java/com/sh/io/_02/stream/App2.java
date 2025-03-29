package com.sh.io._02.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App2 {
    public static void main(String[] args) {
        FileReader fr=null;
        try {
            fr =new FileReader(App.ROOT+"helloworld.txt");
            int data = fr.read();
            System.out.println(data + " "+(char)data);
            int len =(int)new File(App.ROOT,"helloworld.txt").length();
            char[] chars = new char[len];
            fr.read(chars);
            for(char ch : chars){
                System.out.println(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                if(fr!=null)
                    fr.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
