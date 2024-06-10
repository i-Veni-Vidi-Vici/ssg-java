package com.sh._12_listener.session;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements HttpSessionBindingListener {
    private String userId;
    private String password;
    private String name;

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("Member객체가 Session속성으로 등록되었습니다. " + this);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("Member객체가 Session속성에서 제거되었습니다. " + this);
    }
}
