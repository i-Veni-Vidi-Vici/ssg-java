package com.sh.app._02.embeddable._02.multiple.table;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @SecondaryTable 선언하는 두가지 방법
 * 일단 Entity클래스 레벨에 @SecondaryTable 선언한다.
 * 복수개의 테이블을 사용하는 경우 @SecondaryTables를 사용한다.
 *
 * 해당필드를 @SecondTable 지정해야 한다.
 * 1. @Embeddable 클래스 하위 @Column(table)에 @SecondaryTable을 명시
 * 2. Entity 클래스 하위 @Embedded 필드에  @AttributeOverride(column = @Column(table))에 @SecondaryTable을 명시
 */
@Entity
@Table(name = "tbl_writer")
@SecondaryTables({
        @SecondaryTable(
                name = "tbl_writer_info",
                // @PrimaryKeyJoinColumn(name = "tbl_writer_info.pk컬럼명", referencedColumnName = "tbl_writer.id컬럼명")
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "writer_id", referencedColumnName = "id")
        ),
        @SecondaryTable(
                name = "tbl_writer_address",
                // @PrimaryKeyJoinColumn(referencedColumnName) 생략 가능하다.
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "writer_id")
        ),
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Embedded
    private WriterInfo writerInfo;
    @Embedded
    @AttributeOverrides({
            // @AttributeOverride(name = "Embedded클래스 필드명", column = @Column(name = "세컨테이블 컬럼명", table = "세컨테이블")),
            @AttributeOverride(name = "address1", column = @Column(name = "addr111", table = "tbl_writer_address")),
            @AttributeOverride(name = "address2", column = @Column(name = "addr222", table = "tbl_writer_address")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code", table = "tbl_writer_address")),
    })
    private Address address;
}