package com.sh.app._04._enum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * <pre>
 *  @Enumerated 어노테이션은 Enum 타입 매핑을 위해 사용된다.
 *  - ✨EnumType.ORDINAL : Enum 타입을 순서로 매핑한다. (✨default)
 *  - EnumType.STRING : Enum 타입을 문자열로 매핑한다.
 *
 *  ORDINAL 사용 시의 장점은 데이터 베이스에 저장 되는 데이터의 크기가 작다는 것이고
 *  단점은 이미 저장 된 enum의 순서를 변경할 수 없다는 것이다.
 *
 *  STRING 사용 시의 장점은 저장된 enum의 순서가 바뀌거나 enum이 추가 되어도 안전하다는 것이고
 *  단점은 데이터 베이스에 저장 되는 데이터의 크기가 ordinal에 비해 크다는 것이다.
 * </pre>
 */
@Entity(name = "Member04") // 영속성 컨텍스트에서 관리되는 이름
@Table(name = "tbl_member04") // DB 테이블과 매핑
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // ✨주석처리한 build와 관련된 모든 코드를 대신 만들어줌
public class Member {
    @Id
    @Column(name = "member_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code; // memberCode를 씀
    @Column(name = "member_id")
    private String id; // 사용자가 입력한 id
    @Column(name = "member_password", nullable = false, length = 20) // not null 제약 조건 걸어주는 것, 길이 20으로 지정해줌
    private String password;
    @Column(name = "member_name", columnDefinition = "varchar(100) default '홍길동'") // " "안에 잇는 철자도 중요함!
    private String name;

    @Column(name = "member_gender")
    @Enumerated(EnumType.ORDINAL) // enum name 선언 인덱스를 db에서 관리
    private Gender gender;

    @Column(name = "member_role")
    @Enumerated(EnumType.STRING) // enum name값은 문자열로 db에서 관리
    private MemberRole memberRole;

    @Column(name = "member_email", unique = true)
    private String email;
    @Column(name = "member_created_at")
    private LocalDateTime createdAt;
    @Column(name = "member_enabled")
    private boolean enabled;

//    public static Builder builder() {
//        return new Builder(); // 내부 클래스 객체 반환
//    }
//
//    // 내부 클래스 생성
//    public static class Builder {
//        private String id;
//        private String password;
//        private String name;
//        private String email;
//        private LocalDateTime createdAt;
//        private boolean enabled;
//
//        public Builder id(String id) {
//            this.id = id;
//            return this; // 내부 클래스 객체를 반환해서 연속적으로 메소드르 호출할 수 있게 한다.(메소드 체이닝 기법)
//        }
//
//        public Builder password(String password) {
//            this.password = password;
//            return this;
//        }
//
//        public Builder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Builder email(String email) {
//            this.email = email;
//            return this;
//        }
//
//        public Builder createdAt(LocalDateTime createdAt) {
//            this.createdAt = createdAt;
//            return this;
//        }
//        public Builder enabled(boolean enabled) {
//            this.enabled = enabled;
//            return this;
//        }
//
//        public Member build() {
//            return new Member(id, password, name, email, createdAt, enabled);
//        }
//    }

}
