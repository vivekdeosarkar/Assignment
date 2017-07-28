package com.vodafone.assignment.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vodafone.assignment.dto.Credit;
import com.vodafone.assignment.dto.Reward;
import com.vodafone.assignment.dto.UserInfo;
import com.vodafone.assignment.dto.Voucher;
import com.vodafone.assignment.services.CalculationService;
import com.vodafone.assignment.services.DataService;

@RestController
public class RewardController {
	
	@Autowired
	private DataService dataservice;
	@Autowired
	private CalculationService calcService;
	
	@RequestMapping(value = "/getRewardsByPerson", method = RequestMethod.GET)
    public List<Reward>  getRewardsByPerson() {
		return new ArrayList<Reward>(calcService.getRewardsByPerson(dataservice.getVouchers(), dataservice.getCredits()));
		
	}	

}
