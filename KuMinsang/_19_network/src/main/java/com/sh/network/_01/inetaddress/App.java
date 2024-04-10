package com.sh.network._01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <pre>
 *     InetAddress
 *     - IP (Internet Protocol Address)주소를 관리하는 클래스
 *     - new 생성자 호출 없이 static 메소드만 제공
 *     - 도메인을 입력하면, DNS에 질의 후 그에 상응하는 ip주소를 반환한다
 *     -
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //google 도메인을 입력
        try {
            InetAddress google = InetAddress.getByName("google.com");
            System.out.println(google.getHostAddress()); //142.250.207.110
            //n개의 ip주소 확인
            InetAddress[] navers = InetAddress.getAllByName("naver.com");
            for(InetAddress naver : navers)
                System.out.println(google.getHostAddress());
            //내 컴퓨터 ip 확인 localhost 127.0.0.1
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostAddress());  //현재 접속중인 local 호스트 ip 172.27.144.1
            System.out.println(localHost);
            //인터넷공인 ip 14.52.189.239

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }



    }
}
