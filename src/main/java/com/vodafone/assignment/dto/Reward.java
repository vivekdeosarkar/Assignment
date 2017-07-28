package com.vodafone.assignment.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Reward implements  Serializable {

	private static final long serialVersionUID = -8045468419900142797L;
	private List<String> credit;
	private List<String> voucher;
	private final String firstName;
	private final String lastName;
	
	public Reward(List<String> credit, List<String> voucher, String firstName, String lastName) {
		super();
		this.credit = credit;
		this.voucher = voucher;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	


	public Reward(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		credit = new ArrayList<>();
		voucher = new ArrayList<>();
		
	}




	public List<String> getCredit() {
		return credit;
	}

	public List<String> getVoucher() {
		return voucher;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	
	
}
