package com.sh.app._03.one2many._03.map;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.xml.namespace.QName;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
@Table(name = "tbl_game")
@Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id") // tbl_game_member.game_id컬럼(FK)이 tbl_game.id컬럼(PK)을 참조
    @MapKeyColumn(name = "role_name")
    @Builder.Default
    private Map<String, GameMember> participants = new HashMap<>();
    @Column(name = "game_date")
    @CreationTimestamp
    private LocalDateTime gameDate;

    public Game(Long id, Map<String, GameMember> participants, LocalDateTime gameDate) {
        this.id = id;
        this.participants = new HashMap<>(participants); // Map.of()로 넘어오는 애가 있을 수도 있기 때문임
        this.gameDate = gameDate;
    }

    public void addParticipant(String roleName, GameMember member) {
        this.participants.put(roleName, member);
    }

    public void removeParticipant(String roleName) {
        this.participants.remove(roleName);
    }
}
