package com.sh.network._03.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <pre>
 * 웹요청을 처리하는 웹서버 작성
 * - http://localhost:80 요청
 * - 응답메세지 html 전송
 * </pre>
 */
public class WepServerApp {
    public static void main(String[] args) {
        int port = 8080; // http 프로토콜의 기본 port 80 (https -> 443)
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            // 반복적으로 client요청을 처리
            while (true) {
                System.out.println("서버 대기중 ...");
                Socket socket = serverSocket.accept(); // 클라이언트와 통신할 새 소켓을 생성
                System.out.println(socket.getInetAddress().getHostAddress() + "로부터 웹요청...");
                // 각 요청을 쓰레드로 처리 (응답성 향상)
                new Thread(() -> {
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter pw = new PrintWriter(socket.getOutputStream());
                        // 같은 소켓에 대해 쓰고 읽기를 동시에 하면 충돌 이슈들이 있다.
                         // 버퍼드리더 먼저! 하고 프린트라이터를 다음에 위치시키기.
                    ){
                        // 웹요청 확인
//                        String data = null;
//                        while ((data = br.readLine()) != null) {
//                            System.out.println(data);
//                        }
                        System.out.println(br.readLine()); // 요청메시지의 첫줄 method url spec

                        String header = """
                                HTTP/1.1 200 OK
                                Content-Type : text/html;charset=UTF-8
                                """;
                        String body = """
                                <h1> Welcome to My Web Server 🥩🥩🥩 </h1>
                                """;

                        pw.println(header);
                        pw.println(); // 공란 header/body 구분자 필수!
                        pw.println(body);

                    }  catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
