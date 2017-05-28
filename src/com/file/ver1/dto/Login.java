package com.file.ver1.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Login {
	
	private String id;
	private String password;

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
		return "Domain [id=" + id + "]";
	}
}

