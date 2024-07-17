package com.sh.app._01.response;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * RestFul API Server 사용자 요청에 단순 자료형부터 객체까지 직접 응답할 수 있다.
 * - @ResponseBody 어노테이션을 통해 응답 응답 http메세지 본문에 데이터를 직접 기록할 수 있다.
 * - 클래스레벨에 @RestController어노테이션 선언을 통해 @Controller선언과 @ResponseBody 선언을 동시에 할 수 있다.
 *
 */
@RestController
@RequestMapping("/response")
public class ResponseController {
    @GetMapping("/string")
    public String string() {
        return "🐱‍👓Hello World ‍👓";
    }
    @GetMapping("/number")
    public int number() {
        return new Random().nextInt();
    }

    @GetMapping("/object")
    public Foo object() {
        return new Foo(1234, "Bar");
    }

    @GetMapping("/list")
    public List<String> list() {
        return List.of("🐱‍👓", "❤", "👍");
    }

    @GetMapping("/map")
    public Map<String, Integer> map() {
        return Map.of("🐱‍👓" , 10, "❤" ,20, "👍", 30);
    }

    // APPLICATION_OCTET_STREAM_VALUE 다운로드
    // IMAGE_PNG_VALUE 이미지 보여주기
    @GetMapping(path = "/image",
            produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] image() throws IOException {
        // 특정자원을 찾아 입력스트림을 가지고, byte[]로 변환
        return getClass().getResourceAsStream("/static/image/download.jpg").readAllBytes();
    }


}
