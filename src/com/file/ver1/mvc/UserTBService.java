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
		
		//UserRepository의 findById()호출
		User user = userTBRepository.getLoginBean(login.getId());
		
		//위 결과인 user 결과 login 파라미터 값을 비교
		if(user.getId().equals(login.getId()) && user.getPassword().equals(login.getPassword())){
			return true;
		}
		
		return false;
	}
	
	public User getLoginId(String id) {
		return userTBRepository.getLoginBean(id);
	}
}
