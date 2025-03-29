package com.sh.network._01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <pre>
 *  ### InetAddress
 * - IP (Internet Protocol Address)주소를 관리하는 클래스
 * - new 생성자 호출 없이 static 메소드만 제공함
 * - 도메인을 입력하면, 그에 상응하는 ip주소를 DNS에 먼저 질의 후, 반환함
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //구글 도메인
        try {
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println(google.getHostAddress()); //142.250.206.228 -> url 복붙하면 구글 사이트 나옴!

            //n개의 ip 주소 확인
            InetAddress[] navers = InetAddress.getAllByName("www.naver.com");
            for (InetAddress naver : navers) {
                System.out.println(naver.getHostAddress());
                /*
                223.130.200.236
                223.130.200.219
                223.130.192.247
                223.130.192.248
                */
            }

            //내 컴퓨터 ip 확인 localhost 127.0.0.1
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostAddress()); //192.168.0.155

        } catch (UnknownHostException e) { //도메인 이름이 잘못 되었을 때의 예외처리
            e.printStackTrace();
        }
    }
}
