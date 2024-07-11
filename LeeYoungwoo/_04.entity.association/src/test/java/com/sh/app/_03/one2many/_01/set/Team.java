package com.sh.app._03.one2many._01.set;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Team-Play 관게
 *  - 1개의 Team에는 N명의 Player가 존재한다.
 *  - 양방향관계를 만들지 않기 위해 반대방향은 설계시 고려하지 않는다.
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
    @OneToMany(fetch = FetchType.EAGER) // 기본값 FetchType.LAZY
    @JoinColumn(name = "team_id") // tbl_player.team_id컬럼(FK)에서 tbl_team.id컬럼(PK)을 참조한다.
    @Builder.Default // builder 패턴에 의해 객체 생성시에도 기본값으로 사용
    private Set<Player> players = new HashSet<>(); // 선수가 팀에 중복으로 들어가지 않기 때문에 Set을 쓴다.

    public Team(Long id, String name, Set<Player> players) {
        this.id = id;
        this.name = name;
        // Set.of()로 만들어진 변경 불가능한(ImmutableCollection) 객체를 다시 변경 가능한 Set 객체로 만들어 처리한다.
        // 위에 필드는 new HashSet<>() -> 변경 가능하지만 Set.of()로 받아오면 변경 불가능해지므로 바꾸는게 필요한 것
        this.players = new HashSet<>(players);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }
}
