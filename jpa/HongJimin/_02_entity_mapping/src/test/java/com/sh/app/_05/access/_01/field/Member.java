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
 *   Access
 * - JPA가 엔티티의 필드값을 읽거나 쓰기하는 방식을 결정함
 * - `@Access(AccessType.*FIELD*)` → 기본값
 *     - field에 직접 접근해서 읽기/쓰기 처리
 * - `@Access(AccessType.*PROPERTY*)`
 *     - Getter/Setter를 사용해 읽기/쓰기 처리
 * </pre>
 */
@Entity(name = "Member0501") // 영속성 컨텍스트에서 관리되는 이름
@Table(name = "tbl_member0501") // DB 테이블과 매핑
@DynamicInsert // insert시 값이 null인 필드는 제외한다.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 주석처리한 build와 관련된 모든 코드를 대신 만들어줌
@Access(AccessType.FIELD) // ✨클래스 레벨에 작성,클래스 모든 필드에 접근 방식을 필드 레벨로 결정
public class Member {
    @Id
    @Column(name = "member_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.FIELD) // ✨필드 레벨에 작성, 이 필드에 대한 접근 방식만 필드 레벨로 결정 / 기본값이어서 안써도 무방함
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

}
