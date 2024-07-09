package com.sh.app._01.sns.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDate;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class Profile {
    @Column(name = "full_name", table = "tbl_profile")
    private String fullName;
    @Column(name = "date_of_birth", table = "tbl_profile")
    private LocalDate dateOfBirth;
    @Column(name = "gender", table = "tbl_profile")
    private Gender gender;
    @Column(name = "phone_number", table = "tbl_profile")
    private String phoneNumber;
    @Column(name = "address", table = "tbl_profile")
    private String address;
    @Column(name = "website", table = "tbl_profile")
    private String website;
    @Column(name = "bio", table = "tbl_profile")
    private String bio;
}
