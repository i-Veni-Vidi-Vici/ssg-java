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
//    @GetMapping(value = "/object", produces = "text/plain; charset=UTF-8")
//    @ResponseBody
//    public String object() {
//        return """
//                { "name" : "홍길동", "age" : 33, "married" : false, "pet": null }
//                """;
//    }

    @GetMapping(value = "/object", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Member object() {
        return new Member(1L, "홍길동", 33, true, new Pet("구리구리"));
    }

    @GetMapping(value = "/object2", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Map<String, Object> object2() {
        return Map.of(
                "name", "신사임당",
                "age", 44,
                "friends", List.of("논개", "유관순")
        );
    }

    @GetMapping(value = "/array", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Member> array() {
        return List.of(
                new Member(1L, "홍길동", 33, true, new Pet("구리구리")),
                new Member(2L, "이순신", 12, true, null),
                new Member(3L, "신사임당", 23, true, new Pet("임금"))
        );
    }
}
