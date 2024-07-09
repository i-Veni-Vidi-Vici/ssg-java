package com.sh.app._01.sns.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.Locale;
import java.util.TimeZone;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class Settings {
    @Column(name = "notification_settings", table = "tbl_settings")
    private boolean notificationSettings;
    @Column(name = "public", table = "tbl_settings")
    private boolean isPublic;
    @Column(name = "language", table = "tbl_settings")
    private Locale language;
    @Column(name = "timezone", table = "tbl_settings")
    private TimeZone timeZone;
    @Column(name = "theme", table = "tbl_settings")
    private boolean isDark;
}