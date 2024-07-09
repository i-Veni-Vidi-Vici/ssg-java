package com.sh.app._01.sns.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class SNS {
    @Column(name = "number_of_followers", table = "tbl_sns")
    private int numberOfFollowers;
    @Column(name = "number_of_followings", table = "tbl_sns")
    private int numberOfFollowings;
    @Column(name = "number_of_posts", table = "tbl_sns")
    private int numberOfPosts;
    @Column(name = "number_of_likes", table = "tbl_sns")
    private int numberOfLikes;
    @Column(name = "number_of_comments", table = "tbl_sns")
    private int numberOfComments;
    @Column(name = "number_of_stories", table = "tbl_sns")
    private int numberOfStories;
}