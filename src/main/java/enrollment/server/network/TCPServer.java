package enrollment.server.network;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class TCPServer {
//    public static void main(String[] args) {
//        int PORT = 9999;
//        try {
//            ServerSocket serverSocket = new ServerSocket(PORT);
//            while (true) { // 여러번의 요청을 처리하기 위해 무한반복
//                // 요청별로 쓰레드를 만들어서 응답처리
//                new Thread(() -> {
//                    System.out.println("[서버 대기중...]");
//
//                    Socket clientSocket = serverSocket.accept(); // 새로운 소켓을 만들어서 반환해줌
//                    System.out.println(clientSocket);
//                    // ServerSocket#accept() 클라이언트 요청이 올때까지 대기
//                    // 요청이 들어오면, 새로운 소켓을 생성해 반환
//                    System.out.println(clientSocket.getInetAddress().getHostAddress() + "로부터 요청...");
//
//                    // 클라이언트로부터 데이터를 읽어들일 BufferedReader 생성
//                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                    String message;
//                    while ((message = in.readLine()) != null) {
//                        System.out.println("클라이언트로부터 수신한 메시지: " + message);
//                    }
//
//                    clientSocket.close();
//                    serverSocket.close();
//                }).start();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    Socket socket;
    BufferedReader reader;
    BufferedWriter writer;
    public TCPServer(Socket socket){
        try {
            this.socket = socket;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean send(String msg){
        try{
            this.writer.write(msg);
            this.writer.flush();
            return true;
        }catch(IOException e){
            return false;
        }
    }

    public String receive(){
        //[TODO] 메시지가 도착한 것을 어떻게 확인하고 읽을 것인지.
        try{
            String msg = this.reader.readLine();
            while(msg==null) {
                msg = this.reader.readLine();
            }
            return msg;
        }catch(IOException e){
            return null;
        }
    }
}

