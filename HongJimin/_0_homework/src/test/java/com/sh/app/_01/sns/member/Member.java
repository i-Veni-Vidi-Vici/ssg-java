package com.sh.app._01.sns.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String userId;
    private String userName;
    private String emialAddress;
    private String password;
    private Image prodilePicture;
    private LocalDate signUpDate;
    private Status accountStatus;
}
