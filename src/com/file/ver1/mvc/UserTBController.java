package com.file.ver1.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.file.ver1.dto.Login;

@Controller
public class UserTBController {
	
	@Autowired
	private UserTBService userTBService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPage(@ModelAttribute Login login, HttpSession session){
		//���񽺿��� �α��� ����� boolean Ÿ������ �޴´�.
		boolean loginfo = userTBService.checkLoginInfo(login);
		//true : ���ǿ� id ���� �ִ´�.("loginfo", login.getId())
		//false : �α��� �������� �̵��Ѵ�.
		
		
		
		if(loginfo){
			session.setAttribute("loginfo", login.getId());
		}else{
			return "redirect:login";
		}
		System.out.println("�α��� ���� ����  : "+loginfo );
		
		System.out.println("���ǿ� ����� ���̵� �� : "+session.getAttribute("loginfo"));
		return "result";
	}
	
	@RequestMapping(value="/private", method=RequestMethod.GET)
	public String privatePage(){
		return "private";
	}
	
	@RequestMapping(value="/public", method=RequestMethod.GET)
	public String publicPage(){
		return "public";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		
		//���ǿ� �ִ� �׸� 1���� ����
		//session.removeAttribute("loginfo");
		
		//���� ��� ����
		session.invalidate();
		
		return "redirect:/";
	}
}
