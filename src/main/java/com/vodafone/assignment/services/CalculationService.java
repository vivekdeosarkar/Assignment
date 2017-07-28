package com.vodafone.assignment.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.vodafone.assignment.dto.Credit;
import com.vodafone.assignment.dto.Reward;
import com.vodafone.assignment.dto.UserInfo;
import com.vodafone.assignment.dto.Voucher;
@Service
public class CalculationService {
	public Collection<Reward> getRewardsByPerson(List<Voucher> vouchers, List<Credit> credits) {
		Map<UserInfo, Reward> mapOfRewards = populateMapOfRewardsFromVouchers(vouchers);
		populateCreditInfoToRewards(mapOfRewards, credits);
		return mapOfRewards.values();
	}
	
	private Map<UserInfo, Reward> populateMapOfRewardsFromVouchers(List<Voucher> vouchers) {
		final Map<UserInfo, Reward> rewardsMap = new HashMap<>();
		for(final Voucher voucher : vouchers) {
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
		}
		// TODO Auto-generated method stub
		return rewardsMap;
	}
	
	private void populateCreditInfoToRewards(final Map<UserInfo, Reward> rewardsMap, List<Credit> credits) {
		for(final Credit credit : credits) {
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
			
		}
	}
}
