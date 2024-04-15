package com.ssg.network.web.rpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

public class WepRPCServerApp {
    public static void main(String[] args) {
        int port = 80;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // 반복적으로 client 호출 대기
            while (true) {
                // client 와 통신 소켓 생성
                Socket socket = serverSocket.accept();
                // 요청을 스레드로 처리
                new Thread(() -> {
                   try (
                           BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                           PrintWriter pw = new PrintWriter(socket.getOutputStream())
                   ) {
                       // html 응답 작성
                       createHtmlResponse(br.readLine(), pw);
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void createHtmlResponse(String request, PrintWriter pw) {
        String header = null;
        String body = null;

        if (request.startsWith("GET /rpc")) {
            header = "HTTP/1.1 200 OK\nContent-Type: text/html; charset=UTF-8\n";
            body = "<h1>Welcome to Rock paper scissors 👋</h1>"
                    + "<div><b>가위, 바위, 보 중 하나를 선택하세요.</b><div>"
                    + "<div>"
                    + "    <a href=\"/result?value=1\">✌️</a>"
                    + "    <a href=\"/result?value=2\">✊</a>"
                    + "    <a href=\"/result?value=3\">✋</a>"
                    + "</div>";
        }
        else if (request.startsWith("GET /result")) {
            header = "HTTP/1.1 200 OK\nContent-Type: text/html; charset=UTF-8\n";
            body = createBodyGameResult(request);
        }

        pw.println(header);
        pw.println();
        pw.println(body);
    }

    static String createBodyGameResult(String request) {
        String body;
        String playerChoice = getRequestValue(request);
        String computerChoice = String.valueOf((int) (Math.random() * 3) + 1);

        body = "<div>"
                + "당신은 " + convertToEmojis(playerChoice)
                + ", 컴퓨터는 " + convertToEmojis(computerChoice)
                + " -> " + getGameResult(playerChoice, computerChoice)
                + "</div>";

        body += "<a href=\"/rpc\">다시 하기</a>";
        return body;
    }

    static String getRequestValue(String request) {
        String value;
        value = request.split(" ")[1]; // /result?value=1
        value = value.split("\\?")[1]; // value=1
        value = value.split("=")[1]; // 1
        return value;
    }

    static String convertToEmojis(String value) {
        return switch (value) {
            case "1" -> "가위 ✌️";
            case "2" -> "바위 ✊";
            case "3" -> "보 ✋";
            default -> null;
        };
    }

    static String getGameResult(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "비겼습니다.";
        }
        else if ((playerChoice.equals("1") && computerChoice.equals("3"))
                || (playerChoice.equals("2") && computerChoice.equals("1"))
                || (playerChoice.equals("3") && computerChoice.equals("2"))) {
            return "당신이 이겼습니다.";
        }
        else {
            return "당신이 졌습니다.";
        }
    }
}
