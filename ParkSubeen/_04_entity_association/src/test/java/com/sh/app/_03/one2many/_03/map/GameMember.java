package com.sh.app._03.one2many._03.map;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_game_member")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class GameMember {
    @Id
    private String username;
    private String name;
}
