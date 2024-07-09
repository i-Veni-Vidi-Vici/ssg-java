package com.sh.app._01.sns.member;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_member")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
@SecondaryTables({
        @SecondaryTable(
                name = "tbl_account",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "member_id", referencedColumnName = "id")
        ),
        @SecondaryTable(
                name = "tbl_profile",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "member_id", referencedColumnName = "id")
        ),
        @SecondaryTable(
                name = "tbl_sns",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "member_id", referencedColumnName = "id")
        ),
        @SecondaryTable(
                name = "tbl_settings",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "member_id", referencedColumnName = "id")
        )
})
@Builder
public class Member {
    @Id
    @Column(name = "id")
    private String id;
    @Embedded
    private Account account;
    @Embedded
    private Profile profile;
    @Embedded
    private SNS sns;
    @Embedded
    private Settings settings;
}