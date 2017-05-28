package com.file.ver1.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.file.ver1.dto.Login;
import com.file.ver1.dto.User;

@Service
public class UserTBService {
	
	@Autowired
	private UserTBRepository userTBRepository;

	public boolean checkLoginInfo(Login login){
		
		//UserRepository�� findById()ȣ��
		User user = userTBRepository.getLoginBean(login.getId());
		
		//�� ����� user ��� login �Ķ���� ���� ��
		if(user.getId().equals(login.getId()) && user.getPassword().equals(login.getPassword())){
			return true;
		}
		
		return false;
	}
	
	public User getLoginId(String id) {
		return userTBRepository.getLoginBean(id);
	}
}
