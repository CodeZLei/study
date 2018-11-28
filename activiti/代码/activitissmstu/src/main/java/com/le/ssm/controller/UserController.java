package com.le.ssm.controller;

import com.le.ssm.model.User;
import com.le.ssm.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@RequestMapping("/user")
@Controller("userController")
public class UserController {

	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@RequestMapping("/findUser")
	public String findUser(Model model) {
		User user = userService.getUserById();
		model.addAttribute("user", user);
		return "user/findUser";
	}

}
