package com.sh.app._01.sns.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class SNSInfo {
    @Column(name = "numberOfFollowers", table = "tbl_snsInfo")
    private int numberOfFollowers;
    @Column(name = "numberOfFollowing", table = "tbl_snsInfo")
    private int numberOfFollowing;
    @Column(name = "numberOfPosts", table = "tbl_snsInfo")
    private int numberOfPosts;
    @Column(name = "numberOfLikes", table = "tbl_snsInfo")
    private int numberOfLikes;
    @Column(name = "numberOfComments", table = "tbl_snsInfo")
    private int numberOfComments;
    @Column(name = "numberOfStories", table = "tbl_snsInfo")
    private int numberOfStories;
}
