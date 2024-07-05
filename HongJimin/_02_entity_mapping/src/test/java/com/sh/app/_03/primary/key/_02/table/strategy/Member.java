package com.sh.app._03.primary.key._02.table.strategy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;


/**
 * <pre>
 * 컬럼 매핑 시 @Column 어노테이션에 사용 가능한 속성들
 * 1. name : 매핑할 테이블의 컬럼 이름
 * 2. insertable : 엔티티 저장 시 필드 저장 여부 (default : true)
 * 3. updatable : 엔티티 수정 시 필드 수정 여부 (default : true)
 * 4. table : 엔티티와 매핑될 테이블 이름. 하나의 엔티티를 두 개 이상의 테이블에 매핑할 때 사용. (@SecondaryTable 사용)
 * 5. nullable : null값 허용 여부 설정. not null 제약조건에 해당함 (true 기본값)
 * 6. unique : 컬럼의 유일성 제약 조건
 * (두 개 이상 컬럼에 unique 제약조건을 설정하기 위해서는 클래스 레벨에서 @Table의 uniqueConstraints 속성에 설정)
 * 7. columnDefinition : 직접 컬럼의 DDL을 지정
 * 8. length : 문자열 길이. String 타입에서만 사용. (default : 255)
 * </pre>
 */
@Entity(name = "Member0302") // 영속성 컨텍스트에서 관리되는 이름
@Table(name = "tbl_member0302") // DB 테이블과 매핑
@TableGenerator(
        name = "table_sequence_generator", // ✨얘가 autoincrement를 읽어옴 -> @GeneratedValue name에다가 얘를 넣어줌
        table = "tbl_sequence",
        allocationSize = 50, // 기본값 50, 한번 읽어서 메모리 (DB가 아닌 앱)에서 배포할 크기
        pkColumnName = "table_name" // 테이블별 식별자, next_val 컬럼을 통해 채번할 숫자를 관리한다.
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // ✨주석처리한 build와 관련된 모든 코드를 대신 만들어줌
public class Member {
    @Id
    @Column(name = "member_code")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "table_sequence_generator"
            )
    private Long code; // memberCode를 씀
    @Column(name = "member_id")
    private String id; // 사용자가 입력한 id
    @Column(name = "member_password", nullable = false, length = 20) // not null 제약 조건 걸어주는 것, 길이 20으로 지정해줌
    private String password;
    @Column(name = "member_name", columnDefinition = "varchar(100) default '홍길동'") // " "안에 잇는 철자도 중요함!
    private String name;
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
