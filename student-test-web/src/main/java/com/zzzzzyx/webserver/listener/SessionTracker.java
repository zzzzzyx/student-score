package com.zzzzzyx.webserver.listener;

public class SessionTracker {

	static int sessionCount = 0;

	public static int getSessionCount() {
		return sessionCount;
	}

	public static void incSessionCount() {
		SessionTracker.sessionCount++;
	}
	public static void decSessionCount() {
		SessionTracker.sessionCount--;
	}
	
	static int loginCount = 0;

	public static int getLoginCount() {
		return loginCount;
	}

	public static void incLoginCount() {
		SessionTracker.loginCount++;
	}
	public static void decLoginCount() {
		SessionTracker.loginCount--;
	}
}
