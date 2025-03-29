package com.sh.network._02.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * <pre>
 *     URL
 *     - java.net.URL을 통해 url 문자열을 파싱처리할 수 있다
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        String path = "https://docs.oracle.com:443/javase/8/docs/api/java/lang/String.html?name=hellojava#method.summary";

        try {
            URL url = new URL(path);
            System.out.println("protocol : " + url.getProtocol());  //https
            System.out.println("host : " + url.getHost());  //docs.oracle.com
            System.out.println("port : " + url.getPort());  //443
            System.out.println("path : " + url.getPath());  ///javase/8/docs/api/java/lang/String.html
            System.out.println("query : " + url.getQuery());    //쿼리스트링 name=hellojava
            System.out.println("ref : " + url.getRef());    //앵커(북마크) method.summary

            //해당 url 자원 가져오기 (통신)

            URLConnection urlConnection = url.openConnection();
            try(BufferedReader br =new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                //바이트 기반의 입력스트림을 url 커넥션이 제공한다
                //bufferedReader는 문자열을 입력받으므로 중간 역할자가 필요하다
                //InputStreamReader을 브릿지 스트림으로 사용
                String data = null;
                while((data = br.readLine()) != null){
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
