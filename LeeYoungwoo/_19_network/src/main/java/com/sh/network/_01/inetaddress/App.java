package com.sh.network._01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <pre>
 * InetAddress
 * - IP(Internet Protocol Address)주소를 관리하는 클래스
 * - new 생성자 호출없이 static메소드만 제공한다.
 * - 도메인을 입력하면, 그에 상응하는 ip주소를 DNS에 먼저 질의 후 반환한다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 네이버 도메인
        try {
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println(google.getHostAddress()); // 142.250.207.100

            // n개의 ip주소 확인
            InetAddress[] googles = InetAddress.getAllByName("www.naver.com");
            for (InetAddress naver : googles) {
                System.out.println(naver.getHostAddress());
            }

            // 내컴퓨터 ip 확인 localhost 127.0.0.1 내 컴퓨터 한정 ip
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostAddress()); // 192.168.0.156 강의실 한정 ip
            // 14.52.189.239 전체 강의실이 쓰는 네트워크를 합쳐서 건물 전체의 공인 네트워크 주소

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
