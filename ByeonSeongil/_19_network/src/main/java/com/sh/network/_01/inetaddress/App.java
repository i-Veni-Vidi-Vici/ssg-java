package com.sh.network._01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress
 * - IP (Internet Protocol Address) 주소를 관리하는 클래스
 * - new 생성자 호출없이 static메서드만 제공
 * - 도메인을 입력하면, 그에 상응하는 ip주소를 dns에 먼저 질의후 반환한다.
 */
public class App {
    public static void main(String[] args) {
        // 구글 도메인
        try {
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println(google.getHostAddress());

            // n개의 ip주소 확인
            InetAddress[] googles = InetAddress.getAllByName("www.google.com");
            for (InetAddress google1 : googles) {
                System.out.println(google1.getHostAddress());
            }

            // 내 컴퓨터 ip 확인 localhost 127.0.0.1
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
