package com.sh.network._02.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * <pre>
 * - java.net.URL을 통해 url문자열을 파싱처리할 수 있다
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        String path=
                "https://docs.oracle.com:443/javase/8/docs/api/java/lang/String.html?name=hellojava#method.summary";
        try {
            URL url=new URL(path);
            System.out.println("protocol : "+url.getProtocol());
            System.out.println("host : "+url.getHost());
            System.out.println("port : "+url.getPort());
            System.out.println("path : "+url.getPath());
            System.out.println("query : "+url.getQuery());// 쿼리스트링 name = hellojava
            System.out.println("ref : " +url.getRef()); //method.summary//anchor 북마킹// 페이지내 특정 부분
            System.out.println();
            // 해당 URL 자원 가져오기(통신)
            URLConnection urlConnection=url.openConnection();

            //문자기반 보조스트림 - 브릿지스트림(inputStreamReader) - byte기반 입력스트림
            try (BufferedReader br=new BufferedReader
                    (new InputStreamReader
                            (urlConnection.getInputStream()))) {
                String data = null;
                while((data=br.readLine())!=null)
                {
                    System.out.println("data : "+ data);
                }

            }
            System.out.println("urlConnection : "+urlConnection);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
