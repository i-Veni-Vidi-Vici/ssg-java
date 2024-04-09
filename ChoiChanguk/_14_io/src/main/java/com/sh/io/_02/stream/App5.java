package com.sh.io._02.stream;

import java.io.*;

/**
 * <pre>
 * 1. copy.txt 파일을 읽어서 콘솔에 출력하세요
 * 2. 프로젝트루트에 pasted.txt파일로 출력하세요
 * </pre>
 */
public class App5 {
    public static final String ROOT="ChoiChanguk/_14_io/";

    public static void main(String[] args) {

        /**
         *try(FileReader fw =new~)
         * catch(IOException e)
         * { e.printStackTrace();
         *  }
         *  대신 try()안에 선언과 동시에 객체 생성을 해야 한다
         *  이렇게 쓰면 file.close(); 이거 안해도된다
         */


        FileReader fr=null;
        FileWriter fw=null;

        try {
            fr=new FileReader("C:\\Users\\TECH5-11\\"+"copyme.txt");
            System.out.println("helloworld.txt와 연결된 FileReader객체를 생성했습니다");

            int len=(int)new File("C:\\Users\\TECH5-11","copyme.txt").length();
            char[] chars=new char[len];
            int filelen=fr.read(chars);

            for(int i=0;i<filelen;i++) {
                System.out.printf("%c", chars[i]);//파일 출력
            }

            fw=new FileWriter(ROOT+"pasted.txt");
            fw.write(chars);

        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
                try
                {
                    if (fr != null)
                        // 여기서 만약 에러가 떠서 바로 catch로 갔다??
                        // 그러면 아래 fw.close 작동을 안하고 계속 메모리에 남아있다
                        // fw.close(); 이거를 따로 try로 만들면 된다
                        fr.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                try
                {
                    if(fw!=null)
                    fw.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
        }

    }
}
