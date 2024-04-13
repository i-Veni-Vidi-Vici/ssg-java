package com.ssg.network.web.rpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class WepRPCServerApp {
	public static final int PORT = 80;

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(PORT)){
			while(true) {
				System.out.printf("%s:%s 웹서버 대기중...\n", 
							InetAddress.getLocalHost().getHostAddress(),
							PORT);
				Socket socket = serverSocket.accept();
				new Thread(() -> {
					try(
							BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
							PrintWriter pw = new PrintWriter(socket.getOutputStream());
					) {
						// 요청처리
						String[] temp = br.readLine().split(" "); // GET / HTTP/1.1
						String url = temp[1];

						// 응답처리
						String html = null;
						if(url.startsWith("/rpc")) {
							html = """
							<!DOCTYPE html>
							<html>
								<head>
									<meta charset="utf-8"/>
								</head>
								<body>
									<h1>가위 바위 보</h1>
									<a href="/result?value=1">가위✌</a>
									<a href="/result?value=2">바위🤛</a>
									<a href="/result?value=3">보🖐</a>
								</body>
							</html>
							""";
						}
						else if(url.startsWith("/result")) {
							Map<String, String> param = getParameterMap(url.split("\\?")[1]);
							int userVal = Integer.parseInt(param.get("value"));
							int comVal = (int) (Math.random() * 3) + 1;
							System.out.println(userVal + " vs " + comVal);

							String user = getRcpText(userVal);
							String com = getRcpText(comVal);
							String result = "졌습니다.";
							if(userVal == comVal)
								result = "비겼습니다";
							else if((userVal == 1 && comVal == 3)
									|| (userVal == 2 && comVal == 1)
									|| (userVal == 3 && comVal == 2))
								result = "이겼습니다";
							html = """
								<!DOCTYPE html>
								<html>
									<head>
										<meta charset="utf-8"/>
									</head>
									<body>
										<h1>가위 바위 보 결과</h1>
										<div>
											당신은 %s, 컴퓨터는 %s → 당신이 %s.
										</div>
										<div>
											<a href="/rpc">가위바위보 다시하기</a>
										</div>
									</body>
								</html>
								""".formatted(user, com, result);
						}

						// 응답헤더
						pw.println("HTTP/1.1 200 OK"); // 정상응답
						pw.println("Content-Type : text/html");
						pw.println(); // 헤더/바디 구분자
						// 응답바디
						pw.println(html);
					} catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String getRcpText(int value) {
		return switch(value) {
		case 1 -> "가위✌";
		case 2 -> "바위🤛";
		case 3 -> "보🖐";
		default -> throw new IllegalArgumentException();
		};
	}

	public static Map<String, String> getParameterMap(String qs){ 
		Map<String, String> param = new HashMap<>();
		if(qs != null) {			
			// ["id=honggd", "num=123"]
			for(String _qs : qs.split("&")) { 
				String[] _temp = _qs.split("=");
				param.put(_temp[0], _temp[1]);
			}
		}
		return param;
	}

}