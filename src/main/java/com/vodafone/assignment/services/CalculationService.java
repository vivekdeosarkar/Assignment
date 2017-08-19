package com.vodafone.assignment.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.vodafone.assignment.dto.Credit;
import com.vodafone.assignment.dto.Reward;
import com.vodafone.assignment.dto.UserInfo;
import com.vodafone.assignment.dto.Voucher;
@Service
public class CalculationService {
	public Collection<Reward> getRewardsByPerson(List<Voucher> vouchers, List<Credit> credits) {
		Map<UserInfo, Reward> mapOfRewards =new HashMap<>();
		vouchers.parallelStream().forEach(voucher-> populateMapOfRewardsFromVouchers(voucher,mapOfRewards));		
		credits.parallelStream().forEach(credit-> populateCreditInfoToRewards(credit,mapOfRewards));
		return mapOfRewards.values();
	}	
	
	private Reward populateMapOfRewardsFromVouchers(Voucher voucher, Map<UserInfo, Reward> rewardsMap) {
		UserInfo existingVoucherUser = new UserInfo(voucher.getFirstName(), voucher.getLastName());		
		Reward reward = rewardsMap.get(existingVoucherUser);
		if(null != reward) {
			if(!reward.getVoucher().contains(voucher.getVoucherNumber())) {
				reward.getVoucher().add(voucher.getVoucherNumber());				
			}
		} else {
			final Reward newReward =  new Reward(voucher.getFirstName(), voucher.getLastName());
			newReward.getVoucher().add(voucher.getVoucherNumber());
			rewardsMap.put(existingVoucherUser, newReward);
		}
		return reward;
	}

	private Reward populateCreditInfoToRewards(Credit credit, Map<UserInfo, Reward> rewardsMap) {
		final UserInfo existingCreditUserInfo = new UserInfo(credit.getFirstName(), credit.getLastName());
		Reward reward = rewardsMap.get(existingCreditUserInfo);
		if(null != reward) {
			if(!reward.getCredit().contains(credit.getCreditId())) {
				reward.getCredit().add(credit.getCreditId());
			}			
		} else {
			final Reward newReward =  new Reward(credit.getFirstName(), credit.getLastName());
			newReward.getCredit().add(credit.getCreditId());
			rewardsMap.put(existingCreditUserInfo, newReward);
		}
		return reward;
	}	
}
