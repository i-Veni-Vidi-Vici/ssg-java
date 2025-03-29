package com.sh.io._03.filter.stream;

import java.io.*;

/**
 * <pre>
 * DataInputStream / DataOutputStream 보조스트림
 *  - 자료형 단위로 읽기/쓰기 기능 지원
 * </pre>
 *
 */
public class App3 {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(App.ROOT + "dataTypes.dat"))) {
            dos.writeInt(100);
            dos.writeChar('k');
            dos.writeDouble(123.456);
            dos.writeUTF("Helloworld");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(App.ROOT + "dataTypes.dat"))) {
            // 쓰기순서대로 자료형별로 읽어와야 한다.
            int n = dis.readInt();
            char ch = dis.readChar();
            double d = dis.readDouble();
            String str = dis.readUTF();

            System.out.println(n);
            System.out.println(ch);
            System.out.println(d);
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
