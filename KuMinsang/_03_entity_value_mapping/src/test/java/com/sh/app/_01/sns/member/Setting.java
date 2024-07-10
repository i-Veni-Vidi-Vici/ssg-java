package com.sh.app._01.sns.member;

import jakarta.persistence.*;
import lombok.*;

import java.util.TimeZone;

@Data
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Setting {
    @Column(name="notify", table = "tbl_setting")
    private boolean notify;
    @Column(name="account_setting", table = "tbl_setting")
    private boolean accountSetting;
    @Enumerated(EnumType.STRING)
    @Column(name="language", table = "tbl_setting")
    private Language language;
    @Column(name="time_zone", table = "tbl_setting")
    private TimeZone timeZone;
    @Enumerated(EnumType.STRING)
    @Column(name="theme", table = "tbl_setting")
    private Theme theme;
}
