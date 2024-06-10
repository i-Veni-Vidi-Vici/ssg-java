package com.sh._12_listener.request;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyRequestListener implements ServletRequestListener, ServletRequestAttributeListener {

    /**
     * ServletRequestListener
     * @param sre
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request initialized! " + sre);
    }
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request destroyed! " + sre);
    }

    /**
     * ServletRequestAttributeListener
     * @param srae
     */
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("Attribute added! " + srae.getName() + " = " + srae.getValue());
    }
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("Attribute Removed! " + srae.getName());
    }
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("Attribute Replaced! " + srae.getName() + " = " + srae.getValue()); // 이전값 출력
    }
}
