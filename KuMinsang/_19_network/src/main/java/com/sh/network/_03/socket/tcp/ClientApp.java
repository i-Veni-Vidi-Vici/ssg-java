package com.sh.network._03.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) {
//        String host = "localhost";
        String host = "192.168.0.20";

//        int port = 8888;
        int port = 9999;

        try {
            //클라이언트 최초 연결 요청
            Socket clientSocket = new Socket(host, port);
            System.out.println(host + ":" + port + "에 접속중...");
            //서버소켓으로부터 데이터 읽기 스트림 생성
            try(BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
                //서버 데이터 한 줄 읽어오기
                String data = br.readLine();    //서버로부터 응답이 도달할대까지 블록되어 있는다
                //주의할 점은 서버가 응답하지 않으면 무한정 대기하므로 Timeout등의 처리 할것을 권장한다
                System.out.println("[서버] : "+data);
            }
            System.out.println("통신을 마칩니다");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
