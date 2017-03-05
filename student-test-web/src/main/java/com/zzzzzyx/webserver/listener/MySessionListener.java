package com.zzzzzyx.webserver.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener{

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("add\tname: " + arg0.getName() + "\tvalue: " + arg0.getValue());
		if(arg0.getName().equals("login")){
			SessionTracker.incLoginCount();
		}
		
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("remove\tname: " + arg0.getName() + "\tvalue: " + arg0.getValue());
		if(arg0.getName().equals("login")){
			SessionTracker.decLoginCount();
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("replace\tname: " + arg0.getName() + "\tvalue: " + arg0.getValue());
		
	}

	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session create");
		SessionTracker.incSessionCount();
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session delete");
		SessionTracker.decSessionCount();
	}
}
