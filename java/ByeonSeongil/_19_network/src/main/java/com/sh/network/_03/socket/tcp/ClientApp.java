package com.sh.network._03.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 9999;

        try {
            // 클라이언트 최초 연결 요청
            Socket clientSocket = new Socket(host, port);
            System.out.println(host + ":" + port + "에 접속중...");

            // 서버소켓으로부터 데이터 읽기 스트림 생성
            try(BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
                // 서버 데이터 한줄 읽어오기
                String data = br.readLine();
                System.out.println("[서버] " + data);

            }


            System.out.println("통신을 마칩니다...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
