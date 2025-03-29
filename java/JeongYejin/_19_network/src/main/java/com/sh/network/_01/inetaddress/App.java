package com.sh.network._01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress
 * - IP (Internet Protocl Address)주소를 관리하는 클래스
 * - new 생성자 호출없이 static 메소드만 제공한다.
 * - 도메인을 입력하면, 그에 상응하는 ip주소를 DNS에 먼저 질의후 반환한다.
 */
public class App {
    public static void main(String[] args) {
        // 구글 도메인
        try {
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println(google.getHostAddress()); // 142.250.207.100

            // n개의 ip주소 확인
            InetAddress[] googles = InetAddress.getAllByName("www.google.com");
            InetAddress[] navers = InetAddress.getAllByName("www.naver.com");
            for (InetAddress goole: googles)
                System.out.println(goole.getHostAddress());
            for (InetAddress naver: navers)
                System.out.println(naver.getHostAddress());
            // 223.130.192.248
            // 223.130.200.219
            // 223.130.200.236
            // 223.130.192.247

            // 내 컴퓨터 ip 확인 localhost 127.0.0.1
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostAddress()); // 192.168.0.154
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
