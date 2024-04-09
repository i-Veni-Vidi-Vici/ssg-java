package com.sh.network._03.socket.tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <pre>
 * TCP Socket 프로그래밍
 * - 전송(Transport) 프로토콜 TCP(연결지향적), UDP(연속적)
 *
 * 레시피
 * 1. 서버의 포트번호 정함
 * 2. 서버용 소켓 객체 생성
 * 3. 클라이언트 쪽에서 접속 요청이 오길 기다림
 *
 * 4. 접속 요청이 오면 요청 수락 후 해당 클라이언트에 대한 소켓 객체 생성
 * 5. 연결 된 클라이언트와 입출력 스트림 생성
 * 6. 보조 스트림을 통해 성능 개선
 * 7. 스트림을 통해 읽고 쓰기
 * 8. 통신 종료
 *
 * </pre>
 */
public class ServerApp {
    public static void main(String[] args) {
        int port = 9999; // 0 ~ 1024 well-known port구간은 피해서 지정
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            
            while(true) {
                System.out.println("[서버 대기중...]");
                // ServerSocket#accept() 클라이언트 요청이 올때까지 대기.
                // 요청이 들어오면, 새로운 소켓을 생성해 반환
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostAddress() + "로부터 요청...");
                // 요청별로 쓰레드를 만들어서 응답처리
                new Thread(() -> {
                    // 클라이언트 소켓에 대해 출력스트림 생성
                    try(PrintWriter pw = new PrintWriter(socket.getOutputStream())) {
                        // 응답메세지 출력
                        pw.println("반갑습니다... 🍖🍖🍖");
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
