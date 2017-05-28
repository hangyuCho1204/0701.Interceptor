package com.file.ver1.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.file.ver1.dto.Login;
import com.file.ver1.dto.User;
import com.file.ver1.mapper.FileMapper;

@Repository
public class UserTBRepository {
	
	@Autowired
	private FileMapper mapper;
	
	public User getLoginBean(String id) {
	return mapper.getLoginBean(id);
	}
	
	public boolean checkLoginInfo(Login login){
		//userRepository�� findById()ȣ��
		
		//�� ����� User ���� login �Ķ���� ���� ��
		
		return false;
	}
}
