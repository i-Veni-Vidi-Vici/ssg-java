package com.sh.app._03.one2many._02.list;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_inquiry")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
}
