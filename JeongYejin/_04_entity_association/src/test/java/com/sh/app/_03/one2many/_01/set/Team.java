package com.sh.app._03.one2many._01.set;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Team-Player 관계
 * - 1개의 Team에는 N명의 Player가 존재한다.
 * - 양방향관계를 만들지 않기 위해 반대방향은 설계시 고려하지 않는다.
 */
@Entity
@Table(name = "tbl_team") // 리눅스위의 mysql은 대소문자를 구별할 수 있으니 신경을 써야 한다. 윈도우환경에서는 대소문자 구별 없음
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id") // tbl_player.team_id 컬럼(FK)에서 tbl_team.id컬럼(PK)을 참조한다.
    @Builder.Default // builder패턴에 의해 객체 생성시에도 기본값으로 사용
    private Set<Player> players = new HashSet<>(); // 중복을 허용하지 않는 케이스가 많기때문에 의외로 set이 많이 선호된다.

    public Team(Long id, String name, Set<Player> players) {
        this.id = id;
        this.name = name;
        // Set.of()로 만들어진 ImmutableCollection객체를 다시 변경가능한 Set객체로 처리
        this.players = new HashSet<>(players);
//        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }
}
