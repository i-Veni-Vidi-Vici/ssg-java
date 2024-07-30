package com.sh.kakao_pay_api.controller;

import com.sh.kakao_pay_api.model.dto.ReadyResponse;
import com.sh.kakao_pay_api.service.KakaoPayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Controller
public class KakaoPayController {

    private final KakaoPayService kakaoPayService;

    @GetMapping("/pay")
    public void pay() {

    }

    @GetMapping("/readyToKakaoPay/{openType}")
    public String readyToKakaoPay(@PathVariable("openType")String openType, Model model) {
        ReadyResponse readyResponse = kakaoPayService.ready(openType);

        // pc
        model.addAttribute("response", readyResponse);
        return openType+"/ready";
    }

    @GetMapping("/approve/{openType}")
    public String approve( @PathVariable("openType") String openType, @RequestParam("pg_token") String pgToken, Model model) {
        String approveResponse = kakaoPayService.approve(pgToken);
        model.addAttribute("response", approveResponse);
        return  openType + "/approve";
    }

    @GetMapping("/cancel/{openType}")
    public String cancel( @PathVariable("openType") String openType) {
        // 주문건이 진짜 취소되었는지 확인 후 취소 처리
        // 결제내역조회(/v1/payment/status) api에서 status를 확인한다.
        // To prevent the unwanted request cancellation caused by attack,
        // the “show payment status” API is called and then check if the status is QUIT_PAYMENT before suspending the payment
        return  openType + "/cancel";
    }

    @GetMapping("/fail/{agent}/{openType}")
    public String fail(@PathVariable("openType") String openType) {
        // 주문건이 진짜 실패되었는지 확인 후 실패 처리
        // 결제내역조회(/v1/payment/status) api에서 status를 확인한다.
        // To prevent the unwanted request cancellation caused by attack,
        // the “show payment status” API is called and then check if the status is FAIL_PAYMENT before suspending the payment
        return openType + "/fail";
    }
}
