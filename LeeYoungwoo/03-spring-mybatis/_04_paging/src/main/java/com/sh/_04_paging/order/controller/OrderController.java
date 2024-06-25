package com.sh._04_paging.order.controller;

import com.sh._04_paging.order.model.dto.OrderDto;
import com.sh._04_paging.order.model.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/create")
    public void create() {}

    @PostMapping("/create")
    public String create(@ModelAttribute OrderDto orderDto, RedirectAttributes redirectAttributes) {
        log.debug("orderDto = {}", orderDto);
        // 서비스 호출전 데이터 준비
        orderDto.setOrderDate(LocalDate.now());
        orderDto.setOrderTime(LocalTime.now());
        // 서비스 호출
        int result = orderService.createOrder(orderDto);
        // 리다이렉트 후 사용자 메세지 전달
        redirectAttributes.addFlashAttribute("message", "성공적으로 주문을 등록했습니다. 🎉🎉");
        return "redirect:/order/create"; // 동일한 url로 리다이렉트해도, 전송방식이 달라지기 때문에 url변경효과는 있다.
    }
}
