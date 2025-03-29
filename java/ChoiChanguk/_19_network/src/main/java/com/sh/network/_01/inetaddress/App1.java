package com.sh.network._01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <pre>
 * InetAddress
 * - IP = Internet Protocol Address 주소를 관리하는 클래스
 * - new 생성자 호출없이 static 메소드만 제공한다
 * - 도메인을 입력하면, 그에 상응하는 ip주소를 DNS에 먼저 질의 후 반환해준다
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        // 네이버 도메인
        try {
            InetAddress google = InetAddress.getByName("google.com");
            System.out.println(google.getHostAddress());//

            InetAddress[] navers=InetAddress.getAllByName("naver.com");
            for(InetAddress naver: navers)
            {
                System.out.println(naver.getHostAddress());
                // 도메인은 하나지만 ip는 여러개가 있다
            }

            //내컴퓨터 ip확인 localhost 127.0.0.1
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("localhost: "+localHost);
            // 잘못된 도메인이 올 수 있으므로 try, catch를 한다
        } catch (UnknownHostException e) {
            //throw new RuntimeException(e); 만약에 예외를 던져버리면 프로그램 끝남
            e.printStackTrace(); // 넘어가되 콘솔창에 찍기만 하자
        }
    }
}
