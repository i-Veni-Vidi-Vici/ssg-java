package com.sh.network._03.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServerApp {
    public static void main(String[] args){
        int port = 80;  //http 프로토콜의 기본포트 80
        try(ServerSocket serverSocket = new ServerSocket(port)){
            while(true){
                System.out.println("[서버 대기중...]");
                Socket socket = serverSocket.accept();//클라이언트와 통신할 새 소켓을 생성
                System.out.println(socket.getInetAddress().getHostAddress()+ "로부터 웹 요청...");
                //각 요청을 쓰레드로 처리(응답성 향상)
                new Thread(()->{
                    try(
                            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            PrintWriter pw = new PrintWriter(socket.getOutputStream());
                    ){
                        //웹 요청 확인
//                        String data = null;
//                        while((data = br.readLine()) != null){
//                            System.out.println(data);
//                        }
                        System.out.print("요청한 메시지: ");
                        System.out.println(br.readLine());  //요청 메시지의 첫줄만 읽기
                        //html 응답작성
                        String header = """
                        HTTP/1.1 200 OK
                        Content-Type : text/html;charset=UTF-8
                        """;
                        String body = """
                        <h1>Welcome to My Web server🎈</h1>        
                        """;
                        pw.println(header);
                        pw.println();   //✨공란 header와 body의 구분자이며 필수이다✨
                        pw.println(body);

                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }).start();
            }
        }catch ( IOException e){
            e.printStackTrace();
        }
    }
}
