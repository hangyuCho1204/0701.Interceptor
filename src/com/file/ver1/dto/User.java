package com.file.ver1.dto;


public class User {
	private int no_seq;
	private String id;
	private String password;
	public int getNo_seq() {
		return no_seq;
	}
	public void setNo_seq(int no_seq) {
		this.no_seq = no_seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserModel [no_seq=" + no_seq + ", id=" + id + ", password="
				+ password + "]";
	}
}
