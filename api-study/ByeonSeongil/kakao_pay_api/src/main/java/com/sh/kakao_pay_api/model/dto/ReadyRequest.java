package com.sh.kakao_pay_api.model.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ReadyRequest {
    private String cid;
    private String partnerOrderId;
    private String partnerUserId;
    private String itemName;
    private Integer quantity;
    private Integer totalAmount;
    private Integer taxFreeAmount;
    private Integer vatAmount;
    private String approvalUrl;
    private String cancelUrl;
    private String failUrl;
}
