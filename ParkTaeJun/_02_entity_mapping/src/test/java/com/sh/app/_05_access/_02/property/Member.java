package com.sh.app._05_access._02.property;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;


/**
 * <pre>
 * @GeneratedValue
 * - 항상 @Id와 함께 작성한다.
 * - strategy : 자동 생성 전략을 지정
 *     - GenerationType.IDENTITY : 기본 키 생성을 데이터베이스에 위임(MySQL의 AUTO_INCREMENT)
 *     - GenerationType.SEQUENCE : 데이터베이스 시퀀스 객체 사용(ORACLE의 SEQUENCE)
 *     - GenerationType.TABLE : 키 생성 테이블 사용
 *     - GenerationType.AUTO : 자동 선택 (MySQL이라면 IDENTITY, ORACLE이라면 SEQUENCE로 선택)
 * - generator : strategy 값을 GenerationType.TABLE로 지정한 경우 사용되는 테이블 이름을 지정
 * - initialValue : strategy 값을 GenerationType.SEQUENCE로 지정한 경우 시퀀스 초기값을 지정
 * - allocationSize : strategy 값을 GenerationType.SEQUENCE로 지정한 경우 시퀀스 증가치를 지정
 * </pre>
 */

/**
 * @Access JPA가 엔티티의 필드값을 읽거나 쓰기하는 방식을 결정한다.
 * - @Access(AccessType.FIELD) (기본값) 필드에 직접 접근해서 읽기/쓰기 처리
 * - @Access(AccessType.PROPERTY) Getter/Setter를 사용해  읽기/쓰기 처리
 *          -@ID @GeneratedValue @Column 모두getter위에 작성해야 한다.
 */

@Entity(name = "Member0502") // 영속성 컨텍스트에서 관리되는 이름
@Table(name = "tbl_member0502") // DB 테이블을 매핑
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Builder
@Access(AccessType.PROPERTY) // 클래스레벨에 작성, 클래스의 모든 필드에 접근방식을 프로퍼티레벨로 결정
public class Member {
    @Id
    @Column(name = "member_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY) // 필드레벨에 작성, 이 필드에 대한 접근방식만 필드레벨로 작성
    private Long code;

    private String id; //사용자가 입력한 문자열 아이디


    private String password;

    private String name;

    private String email;

    private LocalDateTime createdAt;

    private boolean enabled;



    @Column(name = "member_id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "member_password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "member_name", nullable = true, columnDefinition = "varchar(100) default '홍길동'")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "member_email", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "member_created_at")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "member_enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void  setCode(Long code){
        this.code = code;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCode(){
        return this.code;
    }


//    public static Builder builder() {
//        return new Builder();
//    }
//
//    private static class Builder{
//        private String id;
//        private String password;
//        private String name;
//        private String email;
//        private LocalDateTime createdAt;
//        private boolean enabled;
//
//        public  Builder id(String id){
//        this.id = id;
//        return  this;
//        }
//        public Builder password(String password){
//            this.password = password;
//            return this;
//        }
//        public Builder name(String name){
//            this.name = name;
//            return this;
//        }
//        public Builder email(String email){
//            this.email = email;
//            return this;
//        }
//
//        public Builder createdAt(LocalDateTime createdAt){
//            this.createdAt = createdAt;
//            return this;
//        }
//
//        public Builder enabled(boolean enabled){
//            this.enabled = enabled;
//            return this;
//        }
//
//        public Member build(){
//            return new Member(id, password, name, email, createdAt, enabled);
//        }
//    }



}
