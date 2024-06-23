package com.sh._02_json;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
@Slf4j
public class IndexController {
//    @GetMapping(path = "/object", produces = "application/json; charset=utf-8")
//    @ResponseBody
//    public String objcet() {
//        return """
//                {"name" : "홍길동", "age" : 13, "married" : false, "pet" : null}
//                """;
//    }

    /**
     * @ResponseBody : 핸들러가 반환한 객체를 직접 응답 본문에 작성한다.
     * - String인 경우, 그대로 작성
     * - 그 외 객체인 경우, 내부적으로 HttpMessageConverter 빈에 의해 json문자열로 먼저 변환 후 응답에 작성
     *
     */
    @GetMapping(path = "/object", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Member objcet() {
        return new Member(1L, "홍길동", 33, true, new Pet("부리부리"));
    }

    @GetMapping(path = "/object2", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> objcet2() {
        return Map.of(
                "name", "신사임당",
                "age", 44,
                "friends", List.of("논개", "유관순")
        );
    }

    @GetMapping(path = "/array", produces = "application/json; charset = utf-8")
    @ResponseBody
    public List<Member> array() {
        return List.of(
                new Member(1L, "홍길동", 33, true, new Pet("구리구리")),
        new Member(2L, "신사임당", 44, false, null),
        new Member(3L, "이순신", 55, true, new Pet("용용"))
        );

    }
}
