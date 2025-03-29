package com.sh.network._02.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * <pre>
 *     ### URL
 * - java.net.URL을 통해 url 문자열을 파싱처리할 수 있음
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        String path = "https://docs.oracle.com:443/javase/8/docs/api/java/lang/String.html?name=hellojava#method.summary";

        try {
            URL url = new URL(path);
            System.out.println("protocol : " + url.getProtocol()); //protocol : https
            System.out.println("host : " + url.getHost()); //host : docs.oracle.com
            System.out.println("port : " + url.getPort()); //port : 443
            System.out.println("path : " + url.getPath()); //path : /javase/8/docs/api/java/lang/String.html
            System.out.println("query : " + url.getQuery()); // 쿼리 스트링 -> query : name=hellojava
            System.out.println("ref : " + url.getRef()); // anchor(북마크) , 한 페이지 내 특정 부분을 가리킴-> ref : method.summary

            //해당 URL 자원 가져오기(통신)
            URLConnection urlConnection = url.openConnection();

            //문자 기반 보조 스트림 - 브릿지 스트림(형변환 스트림) - byte 기반 입력 스트림
            try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                String data = null;
                while ((data = br.readLine()) != null) {
                    System.out.println(data);
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
