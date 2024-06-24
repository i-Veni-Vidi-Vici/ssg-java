package com.sh._03_auto_complete;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class ClassmatesSearchController {
    private List<String> classmates = List.of(
            "김동현",
            "구민상",
            "김나경",
            "김도현",
            "김연찬",
            "나지영",
            "박민혁",
            "박수빈",
            "박정은",
            "박태준",
            "변성일",
            "신윤정",
            "심재람",
            "양희윤",
            "오형동",
            "윤도환",
            "이영우",
            "이용준",
            "전현선",
            "정성연",
            "정예진",
            "최창욱",
            "홍지민"
    );

    @GetMapping(path = "/classmate/search", produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<String> classmateSearch(@RequestParam String value) {
        log.debug("value = {}", value);
        return classmates.stream()
                .filter((name) -> name.contains(value))
//                .collect(Collectors.toList());
                .toList();
    }
}
