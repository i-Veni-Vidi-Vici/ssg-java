package com.sh.network._01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        try {
            // 구글 도메인
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println(google.getHostAddress());

            // n개의 ip 주소 확인
            InetAddress[] navers = InetAddress.getAllByName("www.naver.com");
            for (InetAddress naver : navers)
                System.out.println(naver.getHostAddress());

            // 내 컴퓨터 ip 확인 localhost 127.0.0.1
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
