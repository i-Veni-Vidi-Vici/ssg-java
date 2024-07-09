package com.sh.app._02.embeddable._02.secondary.table;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @SecondaryTable 선언하는 두가지 방법
 * 일단 Entity클래스 레벨에 @SecondaryTable 선언
 * 복수개의 테이블을 사용하는 경우  @SecondaryTables를 사용한다.
 *
 * 해당 필드를 @SecondTable에 지정해야 한다.
 * 1. @Embeddable 클래스 하위 @Column(table)에 @SecondaryTable을 명시 -> WriterInfo 클래스에서 @Embeddable 명시해줌
 * 2. Entity 클래스 하위 @Embedded 필드에  @AttributeOverride(column = @Column(table))에 @SecondaryTable을 명시
 *
 *
 *  ✨✨Writer은 하위의 3개의 테이블(tbl_writer, tbl_writer_info, tbl_writer_address)과 매칭됨✨✨ -> 이거 너무 머리 아프면 🙉01.single.table 방법으로 해도됨!!🙉
 *  VO 클래스는 0개의 테이블과 매칭될 수 있음!
 *
 */
@Entity
@Table(name = "tbl_writer")
@SecondaryTables({ // 복수의 secondaryTable 사용할 경우
        @SecondaryTable(
                name = "tbl_writer_info",
                // @PrimaryKeyJoinColumn(name ="✨tbl_writer_info의 pk 컬럼명 정하기✨", referencedColumnName = "✨tbl_write의 id 컬럼명 정하기✨")
                pkJoinColumns = @PrimaryKeyJoinColumn(name ="writer_id", referencedColumnName = "id")
        ),
        @SecondaryTable(
                name = "tbl_writer_address",
                // @PrimaryKeyJoinColumn(referencedColumnName) 생략 가능!
                pkJoinColumns = @PrimaryKeyJoinColumn(name ="writer_id")
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
    private WriterInfo writerInfo; // 작가의 자기소개 글
    @Embedded
    @AttributeOverrides({
            // @AttributeOverride (name = "embedded클래스 필드명" , column = @Column(name = "세컨테이블 컬렴명", table = "세컨 테이블")
            @AttributeOverride(name = "address1", column = @Column(name = "addr111", table = "tbl_writer_address")), // 여기서 secondarytable을 또 명시함
            @AttributeOverride(name = "address2", column = @Column(name = "addr222", table = "tbl_writer_address")),
            @AttributeOverride(name = "zip_code", column = @Column(name = "zip_code", table = "tbl_writer_address"))

    })

    private Address address; // 걍 주소
}
