package com.sh.kakao_pay_api.service;

import com.sh.kakao_pay_api.model.dto.ApproveRequest;
import com.sh.kakao_pay_api.model.dto.RefundRequest;
import com.sh.kakao_pay_api.model.dto.ReadyRequest;
import com.sh.kakao_pay_api.model.dto.ReadyResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoPayService {
    @Value("${kakao.secret.key}")
    private String secretKey;
    private static final String KAKAO_PAY_READY_URL = "https://open-api.kakaopay.com/online/v1/payment/ready";
    private static final String KAKAO_PAY_APPROVE_URL = "https://open-api.kakaopay.com/online/v1/payment/approve";
    private static final String KAKAO_PAY_CANCEL_URL = "https://open-api.kakaopay.com/online/v1/payment/cancel";
    @Value("${cid}")
    private String cid;
    private String tid;


    public ReadyResponse ready(String openType) {
        RestTemplate restTemplate = new RestTemplate();

        // 1. 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "DEV_SECRET_KEY " + secretKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 2. 요청 본문 설정
        ReadyRequest readyRequest = ReadyRequest.builder()
                .cid(cid)
                .partnerOrderId("1")
                .partnerUserId("1")
                .itemName("초코파이")
                .quantity(1)
                .totalAmount(1100000)
                .taxFreeAmount(0)
                .approvalUrl("http://localhost:8080/" + "approve/" + openType) // 결제 성공 시 redirect url, 최대 255자
                .cancelUrl("http://localhost:8080/" + "cancel/" + openType) // 결제 취소 시 redirect url, 최대 255자
                .failUrl("http://localhost:8080/cancel" + "fail/" + openType) //결제 실패 시 redirect url, 최대 255자

                .build();

        // 3. HttpEntity 생성
        HttpEntity<ReadyRequest> entityMap = new HttpEntity<>(readyRequest, headers);

        // 4. RestTemplate 사용
        ResponseEntity<ReadyResponse> response = restTemplate.postForEntity(
                KAKAO_PAY_READY_URL,
                entityMap,
                ReadyResponse.class);

        ReadyResponse readyResponse = response.getBody();

        this.tid = readyResponse.getTid();
        // 5. 응답 처리
        return readyResponse;
    }

    public String approve(String pgToken) {
        // ready할 때 저장해놓은 TID로 승인 요청
        // Call “Execute approved payment” API by pg_token, TID mapping to the current payment transaction and other parameters.
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "SECRET_KEY " + secretKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Request param
        ApproveRequest approveRequest = ApproveRequest.builder()
                .cid(cid)
                .tid(tid)
                .partnerOrderId("1")
                .partnerUserId("1")
                .pgToken(pgToken)
                .build();

        // Send Request
        HttpEntity<ApproveRequest> entityMap = new HttpEntity<>(approveRequest, headers);
        try {
            ResponseEntity<String> response = new RestTemplate().postForEntity(
                    KAKAO_PAY_APPROVE_URL,
                    entityMap,
                    String.class
            );

            // 승인 결과를 저장한다.
            // save the result of approval
            String approveResponse = response.getBody();
            return approveResponse;
        } catch (HttpStatusCodeException ex) {
            return ex.getResponseBodyAsString();
        }
    }

    public String refund() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "SECRET_KEY " + secretKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Request param
        RefundRequest cancelRequest = RefundRequest.builder()
                .cid(cid)
                .tid("T6a8d38329fd342cdd38") // 임의 tid
                .cancelAmount("1100")  // 임의
                .cancelTaxFreeAmount("0")
                .build();
        //승인 결과(result of approval)
        //{"aid":"A6a8d3a301d33ed2dc3c",
        // "tid":"T6a8d38329fd342cdd38",
        // "cid":"TC0ONETIME",
        // "sid":null,
        // "partner_order_id":"1",
        // "partner_user_id":"1",
        // "item_name":"초코파이",
        // "item_code":null,
        // "payload":null,
        // "quantity":1,
        // "amount":{"total":1100000,"tax_free":0,"vat":100000,"point":0,"discount":0,"green_deposit":0},
        // "payment_method_type":"CARD",
        // "card_info":{"kakaopay_purchase_corp":"신한","kakaopay_purchase_corp_code":"701","kakaopay_issuer_corp":"신한","kakaopay_issuer_corp_code":"101","bin":"111111","card_type":"신용","install_month":"00","approved_id":"11111111","card_mid":"111111","interest_free_install":"N","card_item_code":"111111","installment_type":"CARD_INSTALLMENT"},
        // "sequential_payment_methods":null,
        // "created_at":"2024-07-30T20:50:27",
        // "approved_at":"2024-07-30T20:51:00"}
        //
        //취소 결과(result of approval)
        //{"tid":"T6a8d38329fd342cdd38",
        // "cid":"TC0ONETIME",
        // "status":"PART_CANCEL_PAYMENT",
        // "partner_order_id":"1",
        // "partner_user_id":"1",
        // "payment_method_type":"CARD",
        // "item_name":"초코파이",
        // "aid":"A6a8d6a129fd342cdd3c",
        // "quantity":1,
        // "amount":{"total":1100000,
        // "tax_free":0,"vat":100000,
        // "point":0,"discount":0,
        // "green_deposit":0},
        // "canceled_amount":{"total":1100,"tax_free":0,"vat":100,"point":0,"discount":0,"green_deposit":0},
        // "cancel_available_amount":{"total":1098900,"tax_free":0,"vat":99900,"point":0,"discount":0,"green_deposit":0},
        // "approved_cancel_amount":{"total":1100,"tax_free":0,"vat":100,"point":0,"discount":0,"green_deposit":0},
        // "created_at":"2024-07-30T20:50:27",
        // "approved_at":"2024-07-30T20:51:01",
        // "canceled_at":"2024-07-30T21:03:45"}
        // Send Request
        HttpEntity<RefundRequest> entityMap = new HttpEntity<>(cancelRequest, headers);
        try {
            ResponseEntity<String> response = new RestTemplate().postForEntity(
                    KAKAO_PAY_CANCEL_URL,
                    entityMap,
                    String.class
            );

            // 취소 결과를 저장한다.
            // save the result of cancel
            String cancelResponse = response.getBody();
            return cancelResponse;
        } catch (HttpStatusCodeException ex) {
            return ex.getResponseBodyAsString();
        }
    }
}
