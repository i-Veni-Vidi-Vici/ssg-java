package com.sh.app._03.one2many._01.set;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Team-Play 관계
 * - 1개의 Team에는 N명의 Player가 존재한다.
 * - 양방향관계를 만들지 않기 위해 반대방향은 설계 시 고려하지 않는다.
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
    @JoinColumn(name = "team_id") // tbl_playe.team_id컬럼(FK)에서 tbl_team.id컬럼(PK)을 참조한다.
    @Builder.Default // builder패턴에 의해 객체 생성시에도 기본값으로 사용 (null 대신 HashSet<>()이 들어가서 add를 처리할 수 있게 됨)
    private Set<Player> players = new HashSet<>();

    public Team(Long id, String name, Set<Player> players) {
        this.id = id;
        this.name = name;
        // Set.of(), List.of(), Map.of()로 만든 객체는 변경할 수 없다.
        // Set.of()로 만들어진 ImmutableCollection객체를 다시 변경가능한 Set객체로 처리
        this.players = new HashSet<>(players);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

}
