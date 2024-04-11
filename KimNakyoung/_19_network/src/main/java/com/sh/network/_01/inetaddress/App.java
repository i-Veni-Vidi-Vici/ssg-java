package com.sh.network._01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <pre>
 *  InetAddress
 *  - IP ( Internet Protocol Address) 주소를 관리하는 클래스
 *  - new 생성자 호출없이 static메소드만 제공한다.
 *  - 도메인을 입력하면, 그에 상응하는 ip주소를 DNS에 먼저 질의후 반환한다.
 * </pre>
 *
 */

public class App {
    public static void main(String[] args) {
        // 네이버 도메인
        try {
            InetAddress google1 = InetAddress.getByName("www.google.com");
            System.out.println(google1.getHostAddress()); //142.250.207.100 구글 ip

            // n개의 ip 주소 확인
            InetAddress[] googles = InetAddress.getAllByName("www.google.com");
            for(InetAddress google : googles){
                System.out.println(google.getHostAddress());
            } // 구글은 하나

            System.out.println("--------------------------------------------------");

            InetAddress[] navers = InetAddress.getAllByName("www.naver.com");
            for(InetAddress naver : navers){
                System.out.println(naver.getHostAddress());
            } // 네이버는 4개

            System.out.println("--------------------------------------------------");

            //내 컴퓨터 ip 확인 localhost 127.0.0.1
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace(); // 한번 찍고 말자~

        }
    }
}
