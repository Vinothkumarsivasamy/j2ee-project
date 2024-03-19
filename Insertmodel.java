package com.model;

public class Insertmodel {
private String name;
private String email;
private long mobile;
private String course;
private String state;
public Insertmodel(String name, String email, long mobile, String course, String state) {
	super();
	this.name = name;
	this.email = email;
	this.mobile = mobile;
	this.course = course;
	this.state = state;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}

}
