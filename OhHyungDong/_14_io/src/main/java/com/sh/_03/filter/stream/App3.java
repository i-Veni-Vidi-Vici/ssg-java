package com.sh._03.filter.stream;

import java.io.*;

public class App3 {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(App.ROOT + "datatypes.data"))) {
            dos.writeInt(100);
            dos.writeInt('K');
            dos.writeDouble(123.45);
            dos.writeUTF("hello world)");

        }catch(IOException e){
            e.printStackTrace();
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream((App.ROOT + " datatypes.get")))) {
            //쓰기 순서대로 자료형 별로 읽어와야한다.
            int n = dis.readInt();
            char ch = dis.readChar();
            double d = dis.readDouble();
            String str = dis.readUTF();
        }catch ( IOException e){
            e.printStackTrace();
        }
    }
}
