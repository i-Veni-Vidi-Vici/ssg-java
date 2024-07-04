package com.sh.app._05.access._01.field;
import com.sh.app._04._enum.Gender;
import com.sh.app._04._enum.MemberRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * <pre>
 * @Access JPA가 엔티티의 필드값을 읽거나 쓰기하는 방식을 결정한다.
 * - @Access(AccessType.FIELD) 기본값, 필드에 직접 접근해서 읽기/쓰기처리
 * - @Access(AccessType.PROPERTY) Getter/Setter를 사용해 읽기/쓰기 처리
 * -
 * </pre>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Member0501") // 영속성 컨텍스트에서 관리되는 이름
@Table(name = "tbl_member0501")  // DB테이블 매핑
@Builder
@Access(AccessType.FIELD) // 클래스레벨에 작성, 클래스의 모든 필드에 접근방식을 필드레벨로 결정, 이 필드에 대한 접근방식만 필드레벨로 결정
@TableGenerator(
        name = "table_sequence_generator",
        table = "tbl_sequence",
        pkColumnName = "table_name", // 테이블별 식별자, next_val 컬럼을 통해 채번할 숫자를 관리한다.
        allocationSize = 50 // 기본값 50, 한 번 읽어서 메모리(DB가 아닌 앱)에서 배포할 숫자
)
public class Member {
    @Id
    @Column(name = "member_code")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "table_sequence_generator")
    private Long code;

    @Column(name = "member_id")
    private String id; // 사용자가 입력한 문자열 아이디

    @Column(name = "member_password", nullable = false, length = 20)
    private String password;

    @Column(name = "member_name",nullable = true, columnDefinition = "varchar(100) default '홍길동'")
    private String name;

    @Enumerated(EnumType.ORDINAL) // enum name의 선언 인덱스를 db에서 관리한다
    @Column(name = "member_gender")
    private Gender gender;


    @Enumerated(EnumType.STRING)//enum name의 언선 인덱스를 문자열로 관리한다
    @Column(name = "member_role")
    private MemberRole memberRole;

    @Column(name = "member_email", unique = true)
    private String email;

    @Column(name = "member_create_at")
    private LocalDateTime createAt;

    @Column(name = "member_enabled")
    private boolean enabled;

}
