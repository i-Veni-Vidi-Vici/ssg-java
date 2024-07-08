package com.sh.app._01.sns.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.Locale;
import java.util.TimeZone;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class SettingInfo {
    @Column(name = "notification", table = "tbl_setting")
    private Notification notification;
    @Column(name = "account", table = "tbl_setting")
    private Account account;
    @Column(name = "language", table = "tbl_setting")
    private Locale language;
    @Column(name = "timeZone", table = "tbl_setting")
    private TimeZone timeZone;
    @Column(name = "theme", table = "tbl_setting")
    private Theme theme;
}
