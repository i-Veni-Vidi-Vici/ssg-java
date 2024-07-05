package com.sh.app._01.sns.member;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_member")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SecondaryTables({
        @SecondaryTable(
                name = "tbl_userInfo",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "userId")
        ),
        @SecondaryTable(
                name = "tbl_snsInfo",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "userId")
        ),
        @SecondaryTable(
                name = "tbl_setting",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "userId")
        )
})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userID;
    @Column(name = "userName")
    private String username;
    private String emailAddress;
    private String password;
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "pictureName", column = @Column(name = "pictureName", table = "tbl_picture")),
//            @AttributeOverride(name = "path", column = @Column(name = "picturePath", table = "tbl_picture"))
//    })
//    private Picture profilePicture;
    private LocalDateTime signUpDate;
    private LocalDateTime lastLoginDate;
    private AccountStatus accountStatus;
    @Embedded
    private User user;
    @Embedded
    private SNSInfo snsInfo;
    @Embedded
    private SettingInfo settingInfo;
}
