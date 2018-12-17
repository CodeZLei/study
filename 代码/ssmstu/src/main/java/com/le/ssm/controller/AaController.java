package com.le.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.le.ssm.domain.da.DaAroundCommunityPriceInfo;
import com.le.ssm.service.da.DaAroundCommunityPriceInfoService;

@Controller("userController")
public class AaController {
	
	@Autowired
	private DaAroundCommunityPriceInfoService daAroundCommunityPriceInfoService;

	@RequestMapping("/aa")
	@ResponseBody
	public DaAroundCommunityPriceInfo aa() {
		return daAroundCommunityPriceInfoService.selectByPrimaryKey("00000000000000079865");
	}
}
