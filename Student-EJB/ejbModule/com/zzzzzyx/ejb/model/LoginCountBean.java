package com.zzzzzyx.ejb.model;

public class LoginCountBean {

	private int totalPeopleNum;
	private int travellerNum;
	private int loginNum;
	public int getTotalPeopleNum() {
		return totalPeopleNum;
	}
	public void setTotalPeopleNum(int totalPeopleNum) {
		this.totalPeopleNum = totalPeopleNum;
	}
	public int getTravellerNum() {
		return travellerNum;
	}
	public void setTravellerNum(int travellerNum) {
		this.travellerNum = travellerNum;
	}
	public int getLoginNum() {
		return loginNum;
	}
	public void setLoginNum(int loginNum) {
		this.loginNum = loginNum;
	}
	public LoginCountBean(int totalPeopleNum, int travellerNum, int loginNum) {
		super();
		this.totalPeopleNum = totalPeopleNum;
		this.travellerNum = travellerNum;
		this.loginNum = loginNum;
	}
	public LoginCountBean() {
	}
	
	
}
