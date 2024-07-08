package com.sh.app._01.sns.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class User {
    @Column(name = "fullName", table = "tbl_userInfo")
    private String fullName;
    @Column(name = "birth", table = "tbl_userInfo")
    private LocalDate dateOfBirth;
    @Column(name = "gender", table = "tbl_userInfo")
    private Gender gender;
    @Column(name = "phoneNumber", table = "tbl_userInfo")
    private String phoneNumber;
    @Column(name = "address", table = "tbl_userInfo")
    private String address;
    @Column(name = "website", table = "tbl_userInfo", nullable = false)
    private String website;
    @Column(name = "aboutMe", table = "tbl_userInfo", nullable = false)
    private String bio;

    public void changeBio(String newUserBio) {
        this.bio = newUserBio;
    }
}
