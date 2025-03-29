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
//    public String object() {
//        return """
//            { "name" : "홍길동", "age" : 33, "married" : false, "pet" : null }
//            """;
//    }

    /**
     * @ResoponseBody
     * - String인 경우, 그대로 작성
     * - 그 회객체인 경우, HttpSessageConverter빈에 의해 json문자열로 먼저 변환 후 응답에 작성
     * @return
     */
    @GetMapping("/object")
    @ResponseBody
    public Member object(){
        return new Member(1L,"홍길동",33,true,new Pet("고라파덕"));
    }

    @GetMapping("/object2")
    @ResponseBody
    public Map<String ,Object> object2(){
        return Map.of(
                "name","신사입니다",
                "age",44,
                "friends", List.of("논개","이순신")

        );
    }

    @GetMapping(value = "/array", produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Member> array(){

        return List.of(
                new Member(1L, "홍길동",33,true,new Pet("고라파덕")),
                new Member(2L, "신사임당",44,false,new Pet("잠만보")),
                new Member(3L, "허균",53,true,new Pet("치커리"))
        );
    }
}
