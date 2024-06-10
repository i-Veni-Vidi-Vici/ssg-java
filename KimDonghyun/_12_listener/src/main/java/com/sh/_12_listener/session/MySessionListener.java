package com.sh._12_listener.session;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("세션이 생성되었습니다. " + se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 세션 만료, invalidate 호출시
        System.out.println("세션이 제거되었습니다. " + se);
    }
    
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("세션 속성이 추가되었습니다. " + event.getName() + " = " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("세션 속성이 제거되었습니다. " + event.getName() + " = " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("세션 속성이 대체되었습니다. " + event.getName() + " = " + event.getValue());

        HttpSession session = event.getSession();
        Object newValue = session.getAttribute(event.getName());
        System.out.println(newValue);
    }


}
