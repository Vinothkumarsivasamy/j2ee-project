package com.model;

public class displaymodel {
	private int id;
	private String name;
	private String email;
	private long mobile;
	private String course;
	private String state;
	public displaymodel(int studentid, String name, String email, long mobile, String course, String state) {
		super();
		this.id = studentid;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.course = course;
		this.state = state;
	}

	public int getid() {
		return id;
	}

	public void setStudentid(int studentid) {
		this.id = studentid;
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
