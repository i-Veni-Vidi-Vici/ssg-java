package com.sh.app._03.one2many._01.set;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.util.Set;

/**
 * Team - Play 관계
 * - 1개의 Team에는 N명의 Player가 존재한다
 * - 양방향관계를 만들지 않기위해 반대방향은 설계시 고려하지 않는다 = 그니깐 팀에서 플레이어를 만든다
 *
 */

@Entity
@Table(name = "tbl_team")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name="team_id")// tbl_player.team_id컬럼(FK)에서 tbl_team.id(PK)컬럼을 참조
    private Set<Player> players;
}
