package com.sh.app._02.embeddable._03.attribute.override;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User { // 집과 직장 주소를 다 받는 경우!
    @Id
    private String id;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address1", column = @Column(name = "home_addr1")), //address에 잇는 필드 이름을 db 컬럼 명으로 써주는 것 쓰는 것!!!
            @AttributeOverride(name = "address2", column = @Column(name = "home_addr2")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "home_zip_code")),
    })
    private Address homeAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address1", column = @Column(name = "work_addr1")), //address에 잇는 필드 이름 쓰는 것!!!
            @AttributeOverride(name = "address2", column = @Column(name = "work_addr2")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "work_zip_code")),
    })
    private Address workAddress;

}
