package com.sh._04_exceoption_hadnling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

    @GetMapping("/errorsome")
    public String errorsome(){
        log.info("GET/ errorsome");
        if(true)
            throw new RuntimeException("🍖🍖🍖🍖🍖🍖");
        return "result";
    }
    @ExceptionHandler(Exception.class)
    public String exception(Exception e){
        log.error(e.getMessage());
        return "error";
    }
}
