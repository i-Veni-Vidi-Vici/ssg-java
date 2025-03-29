package com.sh.network._02.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * <pre>
 * URL
 * - java.net.URL을 통해 url문자열을 파싱처리할 수 있다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        String path = "https://docs.oracle.com:443/javase/8/docs/api/java/lang/String.html?name=hellojava#method.summary";

        try {
            URL url = new URL(path);
            System.out.println("protocol : " + url.getProtocol()); // https
            System.out.println("host : " + url.getHost()); // docs.oracle.com
            System.out.println("port : " + url.getPort()); // 443
            System.out.println("path : " + url.getPath()); // /javase/8/docs/api/java/lang/String.html
            System.out.println("query : " + url.getQuery()); // 쿼리스트링 name=hellojava
            System.out.println("ref : " + url.getRef()); // anchor(북마크) 페이지내 특정부분 method.summary

            // 해당 URL 자원 가져오기
            URLConnection urlConnection = url.openConnection();
            // 문자기반보조스트림 - 브릿지스트림 - byte기반 입력스트림
            try(BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))){
                String data = null;
                while((data = br.readLine()) != null){
                    System.out.println(data);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

    }
}
