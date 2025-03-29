package com.sh.app._03.one2many._03.map;

import jakarta.persistence.*;

import jakarta.persistence.SecondaryTable;

import lombok.*;

@Entity
@Table(name="tbl_game_member")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class GameMember {

    @Id
    private String username;
    private String name;
}
