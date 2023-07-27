package com.tut;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	private String course;
	private String duation;
	private String platform;
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuation() {
		return duation;
	}
	public void setDuation(String duation) {
		this.duation = duation;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certificate(String course, String duation, String platform) {
		super();
		this.course = course;
		this.duation = duation;
		this.platform = platform;
	}
	
	
}
