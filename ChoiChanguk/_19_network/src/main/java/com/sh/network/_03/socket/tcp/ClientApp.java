package com.sh.network._03.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) {
        String host="80";// 서버에 들어간다
        int port=9999;// 이경우 들어갈려고 하는 host의 9999를 찾을려고 한다

        try {
            Socket clientSocket=new Socket(host,port);
            System.out.println("host : "+host+"  port"+port+"에 접속중");

            //서버소켓으로부터 데이터 읽기 스트림 생성
            try(BufferedReader br=new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
            {
                // 서버에서 받아온걸 읽기 스트림으로 해서 받아온다
                String data = br.readLine();
                System.out.println("서버 : "+data);
            }

            System.out.println("통신을 마칩니다");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
