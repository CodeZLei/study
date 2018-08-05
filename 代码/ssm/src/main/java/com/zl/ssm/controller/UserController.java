package com.zl.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zl.ssm.model.User;
import com.zl.ssm.service.UserService;

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
