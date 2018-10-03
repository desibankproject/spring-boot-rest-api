package com.synergisticit.web.rest;

/**
 * 
 * @author Nagendra
 *
 */
public class CustomerVO {
	private long cid;
	private String name;
	private String email;
	private String education;

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
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

	@Override
	public String toString() {
		return "CustomerVO [cid=" + cid + ", name=" + name + ", email=" + email + ", education=" + education + "]";
	}
}
