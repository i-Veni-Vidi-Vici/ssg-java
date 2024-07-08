package com.sh.app._01.sns.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Column(name = "user_name", table = "tbl_account")
    private String userName;
    @Column(name = "email_address", table = "tbl_account")
    private String emailAddress;
    @Column(name = "password", table = "tbl_account")
    private String password; //암호화된 상태로 저장
    @Column(name = "profile_picture", table = "tbl_account")
    private String profilePicture;
    @CreationTimestamp
    @Column(name = "sign-up_date", table = "tbl_account")
    private LocalDate signUpDate;
    @UpdateTimestamp
    @Column(name = "last_login_date", table = "tbl_account")
    private LocalDate lastLoginDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "account_status", table = "tbl_account")
    private AccountStatus accountStatus;


//    public Account(String userName, String emailAddress, String password, String profilePicture, LocalDate signUpDate, LocalDate lastLoginDate, AccountStatus accountStatus) {
//        this.userName = userName;
//        this.emailAddress = emailAddress;
//        this.password = new BCryptPasswordEncoder().encode(password);
//        this.profilePicture = profilePicture;
//        this.signUpDate = signUpDate;
//        this.lastLoginDate = lastLoginDate;
//        this.accountStatus = accountStatus;
//    }
}
