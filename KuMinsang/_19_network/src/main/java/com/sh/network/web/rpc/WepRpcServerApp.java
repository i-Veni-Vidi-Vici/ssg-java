package com.sh.network.web.rpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WepRpcServerApp {
    public static void main(String[] args) {
        int port = 80;
        try (ServerSocket serverSocket = new ServerSocket(port)){
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostAddress()+ "로부터 웹 요청...");
                new Thread(()->{
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter pw = new PrintWriter(socket.getOutputStream())){
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Socket socket = new Socket();
    }

}
