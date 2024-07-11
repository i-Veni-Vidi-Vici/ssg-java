package com.sh.app._03.one2many._01.set;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Team-Play 관계
 * - 1개의 Team에는 N명의 Player가 존재한다.
 * - 양방향관계를 만들지 않기위해 반대방향은 설계시 고려하지 않는다.
 */
@Entity
@Table(name = "tbl_team")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER) // 기본값 LAZY
    @JoinColumn(name = "team_id") // tbl_player.team_id컬럼(FK)에서 tbl_team.id컬럼(PK)을 참조한다.
    @Builder.Default // builder패턴에 의해 객체 생성시에도 기본값으로 사용
    private Set<Player> players = new HashSet<>();

    public Team(Long id, String name, Set<Player> players) {
        this.id = id;
        this.name = name;
        // 변경가능한 Set객체로 처리
        this.players = new HashSet<>(players);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }
}
