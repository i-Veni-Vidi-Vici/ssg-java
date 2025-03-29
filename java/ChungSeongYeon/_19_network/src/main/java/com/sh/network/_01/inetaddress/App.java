package com.sh.network._01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <pre>
 * InetAddress
 * - IP (Internet Protocol Address)주소를 관리하는 클래스
 * - new 생성자 호출없이 static메소드만 제공한다.
 * - 도메인을 입력하면, 그에 상응하는 ip주소를 DNS에 먼저 질의 후 반환한다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        try {
            // 구글 도메인
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println(google.getHostAddress()); // 172.217.27.4

            // n개의 ip주소 확인
            InetAddress[] navers = InetAddress.getAllByName("www.naver.com");
            for(InetAddress naver : navers)
                System.out.println(naver.getHostAddress());

            // 내 컴퓨터 ip 확인 localhost 127.0.0.1
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostAddress()); // 192.168.0.52
            // 14.52.189.239

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
