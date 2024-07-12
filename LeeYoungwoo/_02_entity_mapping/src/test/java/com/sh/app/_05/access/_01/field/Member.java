package com.sh.app._05.access._01.field;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

/**
 * <pre>
 * @Access - JPA가 엔티티에 필드값을 읽거나 쓰기하는 방식을 결정한다.
 *  - @Access(AccessType.FIELD) : (기본값) 필드에 직접 접근해서 읽기/쓰기 처리
 *  - @Access(AccessType.PROPERTY) : Getter/Setter를 사용해서 읽기/쓰기 처리
 *
 * </pre>
 */

@Entity(name = "Member0501") // 영속성컨텍스트에서 관리되는 이름
@Table(name = "tbl_member0501") // 실제 DB 테이블과 매핑되는 이름
@DynamicInsert // insert시 값이 null인 필드는 제외한다.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Access(AccessType.FIELD) // 클래스레벨에 작성. 클래스의 모든 필드에 접근방식을 필드레벨로 결정
public class Member {
    @Id
    @Column(name = "member_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 쓰겠다는 것
    @Access(AccessType.FIELD) // 필드레벨에 작성. 이 필드에 대한 접근방식만 필드레벨로 결정
    private Long code;
    @Column(name = "member_id")
    private String id; // 사용자가 입력한 문자열 아이디
    @Column(name = "member_password", nullable = false, length = 20)
    private String password;
    @Column(name = "member_name", columnDefinition = "varchar(100) default '홍길동'")
    private String name;
    @Column(name = "member_email", unique = true)
    private String email;
    @Column(name = "member_createdAt")
    private LocalDateTime createdAt;
    @Column(name = "member_endabled")
    private boolean enabled;

//    public static Builder builder() {
//        return new Builder(); // 내부클래스 객체 반환
//    }
//
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
//            return this; // 내부클래스객체를 반환해서 연속적으로 메소드를 호출할 수 있게 한다. (메소드 체이닝기법)
//        }
//        public Builder password(String password) {
//            this.password = password;
//            return this;
//        }
//        public Builder name(String name) {
//            this.name = name;
//            return this;
//        }
//        public Builder email(String email) {
//            this.email = email;
//            return this;
//        }
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
