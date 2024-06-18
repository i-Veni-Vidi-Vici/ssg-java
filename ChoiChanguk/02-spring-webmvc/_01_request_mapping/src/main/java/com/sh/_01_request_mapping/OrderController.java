package com.sh._01_request_mapping;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/order") // 이렇게 하면 아래 /order는 지워도 된다
@Controller
@Slf4j // Simple Longging Faca// de for Java
public class OrderController {
    @GetMapping("/regist")
    public String regitstOrder(Model model) {
        model.addAttribute("message","Order,GET 주문 등록을 요청합니다");

        log.info("/order/regist");
        return "mappingResult";

    }

    @PostMapping("/regist")
    public String regitstOrder1(Model model) {
        model.addAttribute("message","Order,POST 주문 등록을 요청합니다");

        log.info("/order/regist");
        return "mappingResult";

    }



    /**
     * 하나의 핸들러에서 여러 url을 처리할 수 있다. 반대는 불가능. servlet이랑 비슷하지??
     * @param model
     * @return
     */
    @GetMapping({"/modify","/delete"}) //
    public String modifyOrDeleteOrder(Model model) {
        log.info("POST / order/regist 요청");
        model.addAttribute("message","modify or delete 요청입니다");

        log.info("/order/regist");
        return "mappingResult";

    }


    /**
     * 경로변수
     * @RequestMapping의 path속성중 {변수명}에 해당하는 부분을 핸들러의 매개변수 사용할 수 있다
     * - 보통은 경로변수 = 매개변수
     * - 다른 경우는 @PathVariable("변수명")
     * - 여러개도 가능하다
     * - 필요한 경우 형변환 처리도 지원한다
     *
     *  {id} 와 매개변수 id와 매핑한거다
     *  {id} String이다, 스프링이 대신 해주고 있는거다
     * @param model
     * @param id
     * @return
     */
//    @GetMapping("/detail/{id}")
    @GetMapping("/detail/{orderId}")
    // 만약 지금 Integer.Parse 할려고 했는데, asdf같은 문자는 변환을 못하니 status=400으로 에러가 뜬다
    public String findOrderById(Model model, @PathVariable("orderId") Long id) {
        log.info("POST / order/detail/{} 요청");
        model.addAttribute("message",id+"번 상세보기를 요청입니다");

        log.info("/order/regist");
        return "mappingResult";

    }
}
