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

    @OneToMany
    @JoinColumn(name = "game_id" ) // tbl_game_member.game_id FK컬럼이 tbl_game.id PK컬럼을 참조
    @MapKeyColumn(name = "role_name")// 아래 Map<String 이걸 담당한다
    @Builder.Default
    private Map<String , GameMember> participants=new HashMap<>();

    @CreationTimestamp
    private LocalDateTime gameDate;

    public Game(Long id, Map<String, GameMember> participants, LocalDateTime gameDate) {
        this.id = id;
        this.participants =new HashMap<>(participants);
        this.gameDate = gameDate;
    }

    public void addParticipant(String roleName, GameMember member)
    {
        this.participants.put(roleName,member);
    }


    public void removeParticipant(String roleName)
    {
        this.participants.remove(roleName);
    }
}
