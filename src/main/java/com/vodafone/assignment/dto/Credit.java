package com.vodafone.assignment.dto;

import java.io.Serializable;
	
public final class Credit extends UserInfo implements  Serializable {
	
	private static final long serialVersionUID = 6183817595189695998L;

	public String creditId;
	public String points;
	


	public Credit(String creditId, String points, String firstName, String lastName) {
		super();
		this.creditId = creditId;
		this.points = points;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public String getCreditId() {
		return creditId;
	}
	public String getPoints() {
		return points;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	
	
	

}
