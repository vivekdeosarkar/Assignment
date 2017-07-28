package com.vodafone.assignment.dto;

import java.io.Serializable;

public final class Voucher extends UserInfo implements Serializable {
	
	private static final long serialVersionUID = 4793976818139106943L;

	private final String voucherNumber;
	private final String voucherValue;
	private final Currency curency;
	
	public Voucher(String voucherNumber, String voucherValue, Currency curency, String firstName, String lastName) {
		this.voucherNumber = voucherNumber;
		this.voucherValue = voucherValue;
		this.curency = curency;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getVoucherNumber() {
		return voucherNumber;
	}

	public String getVoucherValue() {
		return voucherValue;
	}

	public Currency getCurency() {
		return curency;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	
	
	
	
	
		

}
