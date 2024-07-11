package com.sh.app._01.sns.member;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

//@Entity
//@Table(name = "tbl_member_info")
@Data
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class MemberInfo {
//    @Column(name="full_name")//, table = "tbl_member_info")
    @Column(name="full_name")
//    @Column(name="full_name"), table = "tbl_member_info")
    private String fullName;
    @Column(name="date_of_birth")
//    @Column(name="date_of_birth"), table = "tbl_member_info")
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    @Column(name="gender")
//    @Column(name="gender"), table = "tbl_member_info")
    private Gender gender;
    @Column(name="phone_number")
//    @Column(name="phone_number"), table = "tbl_member_info")
    private String phoneNumber;
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "address1", column = @Column(name = "addres1", table = "tbl_member_info")),
//            @AttributeOverride(name = "address2", column = @Column(name = "addres2", table = "tbl_member_info")),
//            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code", table = "tbl_member_info"))
//    })
//    @AttributeOverrides({
//            @AttributeOverride(name = "address1", column = @Column(name = "addres1")),
//            @AttributeOverride(name = "address2", column = @Column(name = "addres2")),
//            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code"))
//    })
    @Embedded
    private Address address;
    @Column(name="web_site")
//    @Column(name="web_site"), table = "tbl_member_info")
    private String webSite;
    @Column(name="bio")
//    @Column(name="bio"), table = "tbl_member_info")
    private String bio;

//    public void changeAddress(Address newAddress) {
//        this.address = newAddress;
//    }
}
