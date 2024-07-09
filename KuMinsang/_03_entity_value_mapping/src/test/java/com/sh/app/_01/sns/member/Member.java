package com.sh.app._01.sns.member;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * <기본 정보>
 *
 * 사용자 ID (User ID)
 * 사용자 이름 (Username)
 * 이메일 주소 (Email Address)
 * 비밀번호 (Password) (암호화된 상태로 저장)
 * 프로필 사진 (Profile Picture)
 * 가입 날짜 (Sign-up Date)
 * 마지막 로그인 날짜 (Last Login Date)
 * 계정 상태 (Account Status) (활성, 비활성, 정지 등)
 *
 * <개인 정보>
 * 성명 (Full Name)
 * 생년월일 (Date of Birth)
 * 성별 (Gender)
 * 전화번호 (Phone Number)
 * 주소 (Address)
 * 웹사이트 (Website)
 * 자기소개 (Bio)
 *
 * <SNS 관련 정보>
 * 팔로워 수 (Number of Followers)
 * 팔로잉 수 (Number of Following)
 * 게시물 수 (Number of Posts)
 * 좋아요 수 (Number of Likes)
 * 댓글 수 (Number of Comments)
 * 스토리 수 (Number of Stories)
 *
 * <설정 및 환경>
 * 알림 설정 (Notification Settings)
 * 공개/비공개 계정 설정 (Public/Private Account Setting)
 * 언어 설정 (Language Settings)
 * 시간대 설정 (Timezone Settings)
 * 테마 설정 (Theme Settings) (다크모드/라이트모드 등)
 */
@Entity
@Table(name = "tbl_sns_member")
@SecondaryTables({
//        @SecondaryTable(
//                name = "tbl_member_info", pkJoinColumns = @PrimaryKeyJoinColumn(name = "member_id", referencedColumnName = "user_id")
//        ),
        @SecondaryTable(
                name = "tbl_sns_info", pkJoinColumns = @PrimaryKeyJoinColumn(name = "member_id", referencedColumnName = "user_id")
        ),
        @SecondaryTable(
                name = "tbl_setting", pkJoinColumns = @PrimaryKeyJoinColumn(name = "member_id", referencedColumnName = "user_id")
        )
})
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;
    @Column(name="user_name", nullable = false)
    private String userName;
    @Column(name="email", unique = true)
    private String email;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="Profile_picture")
    private UUID profilePicture;
    @Column(name="sign_up_date")
    @CreationTimestamp
    private LocalDate signUpDate;
    @Column(name="last_login_date")
    @UpdateTimestamp
    private LocalDate lastLoginDate;
    @Column(name="account_status")
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @Embedded
    private MemberInfo memberInfo;
    @Embedded
    private SnsInfo snsInfo;
    @Embedded
    private  Setting setting;

    public Member(Long userId, String userName, String email, String password, UUID profilePicture, LocalDate signUpDate, LocalDate lastLoginDate, MemberInfo memberInfo, SnsInfo snsInfo, Setting setting) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = setPassword(password);
        this.profilePicture = profilePicture;
        this.signUpDate = signUpDate;
        this.lastLoginDate = lastLoginDate;
        this.memberInfo = memberInfo;
        this.snsInfo = snsInfo;
        this.setting = setting;
    }

    private String setPassword(String password){
        return null;
    }
//
//    private void changeAddress(Address newAddress){
//        memberInfo.changeAddress(newAddress);
//    }
}
