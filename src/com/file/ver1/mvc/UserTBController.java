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
		//서비스에서 로그인 결과를 boolean 타입으로 받는다.
		boolean loginfo = userTBService.checkLoginInfo(login);
		//true : 세션에 id 값을 넣는다.("loginfo", login.getId())
		//false : 로그인 페이지를 이동한다.
		
		
		
		if(loginfo){
			session.setAttribute("loginfo", login.getId());
		}else{
			return "redirect:login";
		}
		System.out.println("로그인 성공 여부  : "+loginfo );
		
		System.out.println("세션에 저장된 아이디 값 : "+session.getAttribute("loginfo"));
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
		
		//세션에 있는 항목 1개만 삭제
		//session.removeAttribute("loginfo");
		
		//세션 모두 비우기
		session.invalidate();
		
		return "redirect:/";
	}
}
