package com.sh.app._04_enum;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;


/**
 * <pre>
 *  @Enumerated 어노테이션은 Enum 타입 매핑을 위해 사용된다.
 *  - EnumType.ORDINAL : Enum 타입을 순서로 매핑한다. (default)
 *  - EnumType.STRING : Enum 타입을 문자열로 매핑한다.
 *
 *  ORDINAL 사용 시의 장점은 데이터 베이스에 저장 되는 데이터의 크기가 작다는 것이고
 *  단점은 이미 저장 된 enum의 순서를 변경할 수 없다는 것이다.
 *
 *  STRING 사용 시의 장점은 저장된 enum의 순서가 바뀌거나 enum이 추가 되어도 안전하다는 것이고
 *  단점은 데이터 베이스에 저장 되는 데이터의 크기가 ordinal에 비해 크다는 것이다.
 *  enum 타잉ㅂ을 사용하면, 노출되는 값 name 값이지만, 내부적으로는 숫자값을 사용하기 때문에 효율성이 좋다.
 * </pre>
 */

@Entity(name = "Member04") // 영속성 컨텍스트에서 관리되는 이름
@Table(name = "tbl_member04") // DB 테이블을 매핑
@TableGenerator(
        name = "table_sequence_generator",
        table = "tbl_sequence",
        allocationSize = 50, // 매번조화 불필요
        pkColumnName = "table_name" //테이블별 식별자, next-val 컬럼을 통해 채번할 숫자를 관리한다.
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Builder
public class Member {
    @Id
    @Column(name = "member_code")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_sequence_generator")
    private Long code;
    @Column(name = "member_id")
    private String id; //사용자가 입력한 문자열 아이디

    @Column(name = "member_password", nullable = false, length = 20)
    private String password;
    @Column(name = "member_name", nullable = true, columnDefinition = "varchar(100) default '홍길동'")
    private String name;
    @Column(name = "member_email", unique = true)
    private String email;
    @Column(name = "member_created_at")
    private LocalDateTime createdAt;
    @Column(name = "member_enabled")
    private boolean enabled;
    @Column(name = "member_gender")
    @Enumerated(EnumType.ORDINAL) // enum name 선언 인덱스를 db에서 관리
    private Gender gender;
    @Column(name = "member_role")
    @Enumerated(EnumType.STRING) // enum name값은 문자열로 db에서 관리
    private MemberRole memberRole;


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
