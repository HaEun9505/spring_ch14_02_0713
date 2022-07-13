package com.haeun.ch1402;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	@RequestMapping("/studentConfirm")
	public String studentRedirect(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		if(id.equals("tiger")) {
			model.addAttribute("id", id);
			return "redirect:studentOk";
			//redirect가 있으면 새로운 studentOk를 반환(아예 다른 페이지로 이동) ->  404에러
			//모델 객체 전달 x
		}
		model.addAttribute("id", "Fail!!");
		return "redirect:studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk() {
		return "studentOk";
	}
	
	@RequestMapping("/studentNg")
	public String studentNg() {
		return "studentNg";
	}
	@RequestMapping("/student1")
	public String student1() {
		
		return "redirect:http://localhost:8888/ch1402/test.jsp";
		//직접 접근할수 있는 주소 지정
	}
}
