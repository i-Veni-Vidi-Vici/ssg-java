package com.sh._02_json;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class indexController {

//    @GetMapping(path="/object", produces="application/json; charset=utf-8")
//    @ResponseBody
//    public String object(){
//        return """
//                {"name" : "홍길동" , "age" : 33, "married": false, "pet" : null}
//                """;
//    }

    /**
     * @ResponseBody 핸들러가 반환한 객체를 직접 응답 본문에 작성한다
     * - String인 경우, 그대로 작성
     * - 그 외 객체인 경우 HttpMessageConverter 빈에 의해 json문자열로 먼저 변환 후 응답에 작성
     * @return
     */
    @GetMapping(path="/object", produces="application/json; charset=utf-8")
    @ResponseBody
    public Member object(){

        return new Member(1L, "홍길동", 33, true, new Pet("구리구리"));
    }

    @GetMapping(path="/object2", produces="application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> object2(){
        return Map.of(
                "name", "신사임당",
                "age", 44,
                "friends", List.of("논개", "유관순")
        );
    }

    @GetMapping(path = "/array", produces="application/json; charset=utf-8")
    @ResponseBody
    public List<Member> array(){
        return List.of(
                new Member(1L, "홍길동", 33, true, new Pet("멍뭉미")),
                new Member(2L, "박춘배", 13, true, new Pet("고먐미")),
                new Member(3L, "이대식", 53, false, new Pet("햄토리"))
        );
    }

}
