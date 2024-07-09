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
        ),
        @SecondaryTable(
                name = "tbl_picture",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "userId")
        )
})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userID; // 사용자 ID
    @Column(name = "userName")
    private String username; // 사용자 이름
    private String emailAddress; // 이메일 주소
    private String password; // 비밀번호
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "pictureName", column = @Column(name = "pictureName", table = "tbl_picture")),
            @AttributeOverride(name = "path", column = @Column(name = "picturePath", table = "tbl_picture"))
    })
    private Picture profilePicture; // 프로필 사진
    private LocalDateTime signUpDate; // 가입 날짜
    private LocalDateTime lastLoginDate; // 마지막 로그인 날짜
    private AccountStatus accountStatus; // 계정 상태
    @Embedded
    private User user; // 개인 정보
    @Embedded
    private SNSInfo snsInfo; // SNS 관련 정보
    @Embedded
    private SettingInfo settingInfo; // 설정 및 환경

    public void changeUserBio(String newUserBio) {
        this.user.changeBio(newUserBio);
    }

    public void changeNumOfLike(int newNumOfLike) {
        if(this.snsInfo.getNumberOfPosts() != 0) {
            this.snsInfo.changeNumOfLike(newNumOfLike);
        }
        else
            throw new IllegalStateException("게시물이 없어 좋아요를 수정할 수 없습니다.");
    }
}
