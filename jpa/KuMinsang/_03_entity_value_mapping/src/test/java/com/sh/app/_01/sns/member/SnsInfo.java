package com.sh.app._01.sns.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class SnsInfo {
    @Column(name="num_of_followers", table="tbl_sns_info")
    private Long numOfFollowers;
    @Column(name="num_of_following", table="tbl_sns_info")
    private int numOfFollowing;
    @Column(name="num_of_posts", table="tbl_sns_info")
    private int numOfPosts;
    @Column(name="num_of_likes", table="tbl_sns_info")
    private int numOfLikes;
    @Column(name="num_of_comments", table="tbl_sns_info")
    private int numOfComments;
    @Column(name="num_of_stories", table="tbl_sns_info")
    private int numOfStories;
}
