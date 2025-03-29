package com.sh.network._03.tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <pre>
 * TCP Socket 프로그래밍
 * - 전송(Transport) 트랜스포트 프로토콜 TCP(연결지향적), UDP(연속적)
 * </pre>
 */
public class ServerApp {
    public static void main(String[] args) {
        int port = 9999; // 0 ~ 1024 well-known port 구간은 피해서 지정
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            while (true) {
                System.out.println("[서버 대기중...]");
                // ServerSocket#accept() 클라이언트 요청이 올때까지 대기.
                // 요청이 들어오면, 새로운 소켓을 생성해 반환
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostAddress() + "로부터 요청...");
                // 요청별로 쓰레드를 만들어서 응답처리
                new Thread(() -> {
                    // 클라이언트 소켓에 대해 출력스트림 생성
                    try (PrintWriter pw = new PrintWriter(socket.getOutputStream())) {
                        // 응답메세지 출력
                        pw.println("반갑습니다...🍖🍖🍖");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            // socket 자원 반납
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
