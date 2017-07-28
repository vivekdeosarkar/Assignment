package com.vodafone.assignment.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vodafone.assignment.dto.Credit;
import com.vodafone.assignment.dto.Currency;
import com.vodafone.assignment.dto.Voucher;

@Service
public class DataService {

	public List<Voucher> getVouchers() {
		final List<Voucher> vouchers = new ArrayList<>();
		
		final Voucher voucher1 = new Voucher("V2378578346", "1200", Currency.INR, "Drew", "Barrymore");
		final Voucher voucher2 = new Voucher("V183240062", "5", Currency.USD, "Johnny", "Depp");
		final Voucher voucher3 = new Voucher("V45708293", "500", Currency.INR, "Drew", "Barrymore");
		final Voucher voucher4 = new Voucher("V1106", "60", Currency.INR, "Bradd", "Pitt");
		
		vouchers.add(voucher1);
		vouchers.add(voucher2);
		vouchers.add(voucher3);
		vouchers.add(voucher4);
		return vouchers;
	}
	
	public List<Credit> getCredits() {
		final List<Credit> credits = new ArrayList<>();
		
		final Credit credit1 = new Credit("C072341", "100", "Drew", "Barrymore");
		final Credit credit2 = new Credit("C3475634", "50", "Johnny", "Depp");
		final Credit credit3 = new Credit("C34857", "10", "Drew", "Barrymore");
		
		credits.add(credit1);
		credits.add(credit2);
		credits.add(credit3);
		return credits;
		
		
	}
	
}
