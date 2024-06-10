package com.sh._12_listener.application;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyApplicationListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("🎈 contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("🎈 contextDestroyed");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("🎈 attributeAdded " + event.getName() + " = " + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("🎈 attributeRemoved " + event.getName() + " = " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("🎈 attributeReplaced " + event.getName() + " = " + event.getValue());
    }


}
