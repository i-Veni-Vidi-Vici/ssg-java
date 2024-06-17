package com.sh._04_exception_handling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    @GetMapping("/errorsome")
    public String errorsome() {

        log.info("GET /errorsome");
        if (true)
            throw new RuntimeException("🥐🍞🥨🥯🍞"); // 여기서 에러가 던져지면  @ExceptionHandler의 메소드가 실행됨
        return "result";
    }

    /**
     * 특정 컨트롤러 하위에서 던져진 예외 클래스 별로 @ExceptionHandler를 작성할 수 있다.
     */
    @ExceptionHandler(Exception.class) // 어떤 예외에 관한 건지, 여러 타입 별로 여러개 둘 수 있음 / 다른 컨트롤러에서는 사용하지 못함
    public String exception(Exception e, Model model) {
        log.error(e.getMessage(), e); // 예외 스택을 로그로 확인할 수 있음
        model.addAttribute("message", "빵이 상했습니다😪");
        return "error"; // error가 view 네임
    }
}
