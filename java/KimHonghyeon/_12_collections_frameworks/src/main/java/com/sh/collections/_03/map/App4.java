package com.sh.collections._03.map;

import java.io.*;
import java.util.Properties;

public class App4 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("password", "1234");
        prop.setProperty("url", "jdbc:mysql://localhost");
        prop.setProperty("driver", "OracleDriver");
        prop.setProperty("user", "Kim");
        try{
            OutputStream os = new FileOutputStream("KimHonghyeon/_12_collections_frameworks/datasource.properties");
            prop.store(os, "data source");
            os.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        Properties prop2 = new Properties();
        try {
            InputStream is = new FileInputStream("KimHonghyeon/_12_collections_frameworks/datasource.properties");
            prop2.load(is);
            System.out.println(prop2);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
