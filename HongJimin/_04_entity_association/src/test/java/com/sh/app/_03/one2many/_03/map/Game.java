package com.sh.app._03.one2many._03.map;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "tbl_game")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id") // tbl_game_member.game_id컬럼(FK)이 tbl_game.id컬럼(PK)을 참조
    @MapKeyColumn(name = "role_name") // role_name을 Map의 key로 쓴다는 의미
    @Builder.Default
    private Map<String, GameMember> participants = new HashMap<>();
    @Column(name = "game_date")
    @CreationTimestamp
    private LocalDateTime gameDate;

    public Game(Long id, Map<String, GameMember> participants, LocalDateTime gameDate) {
        this.id = id;
        this.participants = new HashMap<>(participants);// 🙉변경 가능한 맵으로 보관🙉
        this.gameDate = gameDate;
    }

    public void addParticipant(String roleName, GameMember member) {
        this.participants.put(roleName, member);
    }
    public void removeParticipant(String roleName) {
        this.participants.remove(roleName);
    }
}
