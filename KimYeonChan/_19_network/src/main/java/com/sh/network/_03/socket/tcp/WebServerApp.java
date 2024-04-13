package com.sh.network._03.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 웹 요청을 처리하는 웹서버 작성
 *  - http://localhost:80 요청
 *  - 응답 메세지 html 전송
 */
public class WebServerApp {
    public static void main(String[] args) {
        int port = 80; // http 프로토콜의 기본 port 80 (https -> 443)
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // 반복적으로 client 의 요청을 처리
            while (true) {
                System.out.println("서버 대기중...");
                Socket socket = serverSocket.accept(); // client 와 통신 소켓 생성
                System.out.println(socket.getInetAddress().getHostAddress() + "로 부터 웹요청...");
                // 각 요청을 쓰레드로 처리(사용자 응답성이 좋아짐)
                new Thread(() -> {
                    try (
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter pw = new PrintWriter(socket.getOutputStream());
                    ){
                        // 웹 요청 확인
                        String data = null;
                        while ((data = br.readLine()) != null && !data.isEmpty()) {
                            System.out.println(data);
                        }
//                        System.out.println(br.readLine()); // 요청 메세지의 첫줄 method url spec
                        // html 응답 작성
                        String header = """
                        HTTP/1.1 200 OK
                        Content-Type : text/html; charset=UTF-8
                        """;
                        String body = """
                        <h1>Welcome to my Web Server 👋</h1>
                        """;
                        pw.println(header);
                        pw.println(); // 공간 header/body 구분자 필수
                        pw.println(body);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
